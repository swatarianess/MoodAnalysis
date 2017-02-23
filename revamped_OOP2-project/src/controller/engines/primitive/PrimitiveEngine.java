package controller.engines.primitive;

import controller.engines.IEngine;
import model.Webpage;
import model.Website;
import util.WebPageEvaluator;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Stephen Adu on 20/02/2017.
 */
public class PrimitiveEngine implements IEngine {

    private boolean                 running;
    private boolean                 volatileWebsites = false;

    private int                     priority;
    private int                     minThreads;
    private int                     maxThreads;
    private int                     intervalChecks;

    private Thread                  innerThread;

    private Collection<Website>     websites;
    private Map<String, Integer>    wordMap = new HashMap<>();

    private ThreadPoolExecutor      threadPoolExecutor;

    private WebPageEvaluator wpEvaluator;


    public PrimitiveEngine(Collection<Website> websites, int minThreads, int maxThreads,
                           int intervalChecks, int priority) throws IOException{
        if (websites == null){
            throw new NullPointerException("Websites is null.");
        }

        this.websites = websites;
        this.minThreads = minThreads;
        this.maxThreads = maxThreads;
        this.intervalChecks = intervalChecks;
        this.priority = priority;

        //TODO: Add CSVReader portion

    }


    private void readPage(Webpage webpage, CountDownLatch latch){

    }

    private void sumScores(Website website, CountDownLatch latch){

    }

    /**
     *  Method that starts the engine
     */
    @Override
    public void start(){
        if(!running){
            running = true;
            threadPoolExecutor = new ThreadPoolExecutor(minThreads,maxThreads,5000L, TimeUnit.SECONDS,
                    new LinkedBlockingQueue<>(),
                    r -> {
                        Thread t = new Thread(r);
                        t.setPriority(priority);
                        return t;
                    }, (r, executor) -> {});
            innerThread = new Thread(()-> {
                while (true){
                    volatileWebsites = true;
                    for (Website website : websites){
                        CountDownLatch latch = new CountDownLatch(website.getPages().size());
                        Collection<Webpage> wPages = website.getPages();

                        for (Webpage webpage : wPages){
                            threadPoolExecutor.execute(()-> readPage(webpage,latch));
                            //TODO Execute Evaluater for all webPages within website Object
                        }

                        threadPoolExecutor.execute(() -> sumScores(website,latch));
                        //TODO: Execute thread that calculates the sum of scores for the website
                    }
                    volatileWebsites = false; // No longer Volatile

                    for (int i =0; i < intervalChecks; i++){
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ignore) {}
                    }
                }
            });
            innerThread.setDaemon(true);
            innerThread.start();
        }


    }

    /**
     * Method that stops the engine
     */
    @Override
    public void stop() {
        if (running){
            running = false;
            threadPoolExecutor.shutdown();
            innerThread.interrupt();
        }
    }

    /**
     * Method that adds websites to the engine
     *
     * @param websites The collection of websites to add to the engine
     */
    @Override
    public void setWebsites(Collection<Website> websites) {
        while (true){
            if(!(volatileWebsites)){
                break;
            }
            this.websites = websites;
        }
    }

    /**
     * Method that adds single website to the engine
     *
     * @param website The website to add to the collection within the engine
     */
    @Override
    public void addWebsite(Website website) {
        while (true){
            if(!(volatileWebsites)){
                break;
            }
            this.websites.add(website);
        }
    }

    /**
     * @param minThreads The minimum number of threads for the threadPool in the engine
     */
    @Override
    public void setMinThreads(int minThreads) {
        if(minThreads >= 0){
            threadPoolExecutor.setCorePoolSize(minThreads);
            if (threadPoolExecutor.getCorePoolSize() == minThreads){
                this.minThreads = minThreads; //TODO: Check if break is good enough?
            }
        }


    }

    /**
     * @param maxThreads The maximum number of threads for the threadPool in the engine
     */
    @Override
    public void setMaxThreads(int maxThreads) {
        if (maxThreads > 0) {
            threadPoolExecutor.setMaximumPoolSize(maxThreads);
            if (threadPoolExecutor.getMaximumPoolSize() == maxThreads){
                this.maxThreads = maxThreads;
            }
        }
    }

    /**
     * @param interval The interval between checks in Seconds
     */
    @Override
    public void setCheckInterval(int interval) {
        if (intervalChecks > 0){
            this.intervalChecks = interval;
        }

    }

    /**
     * @param priority The priority??
     */
    @Override
    public void setPriority(int priority) {
        //TODO what does set Priority do exactly?
        if (priority > 0 && priority < 11) {
            this.priority = priority;
            threadPoolExecutor.setThreadFactory(r -> {
                Thread t = new Thread(r);
                t.setPriority(priority);
                return t;
            });
        }
    }


    public Map<String, Integer> getWordMap() {
        return wordMap;
    }

    public void setWordMap(Map<String, Integer> wordMap) {
        this.wordMap = wordMap;
    }
}
