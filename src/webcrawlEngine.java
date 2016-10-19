import utils.parser;
import utils.threadData;
import utils.websiteData;

import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Created by Stephen Adu on 19/10/2016.
 */
@SuppressWarnings("SpellCheckingInspection")
public class webcrawlEngine implements Runnable {

    private ArrayList<websiteData> websiteDatas;
    private static PrintStream p = System.out;

    public webcrawlEngine(){
        //Add threadData
        websiteData wd1 = new websiteData();
        websiteData wd2 = new websiteData("google.com");

        //Add threadData to websiteData
        wd1.addThreadData(new threadData());
        wd2.addThreadData(new threadData());

        //Add websiteData to array
        websiteDatas.add(wd1);
        websiteDatas.add(wd2);

        parser psr1 = new parser();

    }

    @Override
    public void run() {
        try {
            for (websiteData webdata: websiteDatas
                 ) {

            }

        }catch (Exception e){
            p.print(e);
        }

    }
}
