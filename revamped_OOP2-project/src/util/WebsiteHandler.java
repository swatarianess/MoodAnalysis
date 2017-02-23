package util;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * Created by Stephen Adu on 23/02/2017.
 */
public class WebsiteHandler {

    private String url;
    private ArrayList<String> webPageUrls;
    private LinkedHashMap<String,Integer> pageValues;

    public LinkedHashMap<String,Integer> getPageValues(){
        return new LinkedHashMap<>();
    }

    private LinkedHashMap<String, Integer> processSite (String url) {
            return new LinkedHashMap<>();
    }

    private static List<Future<String[]>> tryInvokeCallables(ArrayList<WebPageWorker> callables,
                                                             ExecutorService executor){
        List<Future<String[]>> futures = new ArrayList<>();
        try {
            futures = executor.invokeAll(callables);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return futures;
    }

    public static String[] getValue(Future<String[]> future){
        String[] value = new String[0];

        try {
            value = future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return value;
    }

}
