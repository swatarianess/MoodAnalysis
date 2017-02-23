package util;

import model.Webpage;

import java.util.concurrent.Callable;

/**
 * Created by Stephen Adu on 23/02/2017.
 */
public class WebPageWorker implements Callable<String[]> {

    private Webpage webpage;

    public WebPageWorker(Webpage webpage){
        this.webpage = webpage;
    }

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public String[] call() throws Exception {
        WebPageEvaluator webPageEvaluator = new WebPageEvaluator(webpage);


        return new String[0];
    }
}
