package Engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/**
 * Created by Steve on 02/11/2016.
 */
public class WebsiteWatcher implements Runnable {

    private ArrayList<WebsiteData> websiteDatas = new ArrayList<>();

    public WebsiteWatcher(){


    }

    @Override
    public void run() {

    }

    public static void main(String[] args){
        WebsiteData wd1 = new WebsiteData();
        WebsiteData wd2 = new WebsiteData();
        WebsiteData wd3 = new WebsiteData();

        String thread1 = "/wiki/Remington_Spartan_100";
        String thread2 = "/wiki/The_Kerry_Recruit";
        String thread3 = "/wiki/Special:Random";
        String thread4 = "/wiki/Maipú,_Buenos_Aires";
        String thread5 = "/wiki/2004_British_Grand_Prix";

        wd1.addThreadData(thread1,thread2,thread3,thread4,thread5);

        ParsePage p = new ParsePage(wd1.getUrl(),thread1);
        ParsePage p2 = new ParsePage(wd1.getUrl(),thread2);
        ParsePage p3 = new ParsePage(wd1.getUrl(),thread3);
        ParsePage p4 = new ParsePage(wd1.getUrl(),thread4);

        Executor executor = Runnable::run;
        ExcelParser ep = new ExcelParser();
        executor.execute(ep);
        ep.getMoodValueMap();
        executor.execute(p);

    }



}
