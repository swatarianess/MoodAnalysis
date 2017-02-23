package util;

import java.util.LinkedHashMap;
import java.util.concurrent.Callable;

/**
 * Created by Stephen Adu on 23/02/2017.
 */
public class WebsiteWorker implements Callable<LinkedHashMap<String,Integer>> {

    private String url;

    WebsiteWorker(String url){
        this.url = url;
    }

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public LinkedHashMap<String, Integer> call() throws Exception {
        //WebsiteEng testSute = bew WebsiteEng(url);
        return null;
    }
}
