package Engine;

import Engine.Handlers.RejectedExecutionHandlerImpl;

import java.util.Map;
import java.util.concurrent.*;

/**
 * @author Steve
 *
 **/
public class WebsitePool implements Runnable {

    @Override
    public void run() {
        try {
            WebsiteData wd1 = new WebsiteData();
            String thread1 = "/wiki/Remington_Spartan_100";
            String thread2 = "/wiki/The_Kerry_Recruit";
            String thread3 = "/wiki/Special:Random";
            String thread4 = "/wiki/Maipú,_Buenos_Aires";
            String thread5 = "/wiki/2004_British_Grand_Prix";

            wd1.addThreadData(thread1,thread2,thread3,thread4);
            Analyser analyser = new Analyser(wd1);
            analyser.setCurrentThread(thread1);

            //
            Executor executor = Runnable::run;

            //Create Excel Parser object
            ExcelParser ep = new ExcelParser();
            executor.execute(ep);

            //Fill Hashmap
            Analyser.setWordMap(ep.getMoodValueMap());

            //Custom RejectedExecutionHandler
            RejectedExecutionHandlerImpl rejectedExecutionHandler = new RejectedExecutionHandlerImpl();

            //ThreadFactory implementation to use
            ThreadFactory threadFactory = Executors.defaultThreadFactory();

            //Creating the ThreadPoolExecutor
            ThreadPoolExecutor executorPool = new ThreadPoolExecutor(1, analyser.getWebsiteThreadSize(),5,
                    TimeUnit.SECONDS, new ArrayBlockingQueue<>(5),threadFactory);

            //Set RejectedExecutionHandler
            executorPool.setRejectedExecutionHandler(rejectedExecutionHandler);

            //Start the monitoring thread
            WebsiteMonitorThread monitor = new WebsiteMonitorThread(executorPool, 3);
            Thread monitorThread = new Thread(monitor);
            monitorThread.start();

            //Iterate through all page-threads and add them to the analyser whilst changing specific page to evaluate mood for.
            for(Map.Entry<String,Integer> entry : wd1.getThreadsArrayList().entrySet()){
                analyser.setCurrentThread(entry.getKey());
                executorPool.execute(analyser);
            }

            //Shutdown the pool
            Thread.sleep(5000);

            executorPool.shutdown();

            //Shutdown the monitor thread
            Thread.sleep(5000);
            monitor.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
