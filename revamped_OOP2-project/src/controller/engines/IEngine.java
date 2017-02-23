package controller.engines;

import model.Website;

import java.util.Collection;

/**
 * Created by Stephen Adu on 20/02/2017.
 */
public interface IEngine {

    /**
     *  Method that starts the engine
     */
    void start();

    /**
     * Method that stops the engine
     */
    void stop();

    /**
     *  Method that adds websites to the engine
     *
     * @param websites The collection of websites to add to the engine
     */
    void setWebsites(Collection<Website> websites);

    /**
     *  Method that adds single website to the engine
     *
     * @param website The website to add to the collection within the engine
     */
    void addWebsite(Website website);

    /**
     * @param minThreads The minimum number of threads for the threadPool in the engine
     */
    void setMinThreads(int minThreads);

    /**
     * @param maxThreads The maximum number of threads for the threadPool in the engine
     */
    void setMaxThreads(int maxThreads);

    /**
     * @param interval The interval between checks in Seconds
     */
    void setCheckInterval(int interval);

    /**
     * @param priority The priority?? TODO: Confirm what Priority Does exactly
     */
    void setPriority(int priority);


}
