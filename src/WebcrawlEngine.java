import utils.ThreadData;
import utils.WebsiteData;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.concurrent.Callable;

/**
 * Created by Stephen Adu on 19/10/2016.
 */
@SuppressWarnings("SpellCheckingInspection")
public class WebcrawlEngine implements Runnable {

    private ArrayList<WebsiteData> WebsiteDatas;
    private static PrintStream p = System.out;

    WebcrawlEngine(){
        //Add ThreadData
        WebsiteData wd1 = new WebsiteData();
        WebsiteData wd2 = new WebsiteData("google.com");

        //Add ThreadData to WebsiteData
        wd1.addThreadData(new ThreadData());
        wd2.addThreadData(new ThreadData("/index.html"));

        //Add WebsiteData to array
        WebsiteDatas.add(wd1);
        WebsiteDatas.add(wd2);

    }


    @Override
    public void run() {

    }
}
