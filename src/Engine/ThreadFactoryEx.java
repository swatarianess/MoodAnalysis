package Engine;

import java.util.ArrayList;
import java.util.concurrent.ThreadFactory;

/**
 * Created by Stephen Adu on 10/11/2016.
 */
public class ThreadFactoryEx implements ThreadFactory {

    private ArrayList<WebsiteData> websiteDataArrayList = new ArrayList<>();

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r);
    }
}
