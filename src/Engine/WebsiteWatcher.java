package Engine;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Stephen Adu on 02/11/2016.
 */
public class WebsiteWatcher implements Runnable {

    private ArrayList<WebsiteData> websiteDatas;


    public WebsiteWatcher(){

        WebsiteData wd1 = new WebsiteData();
        WebsiteData wd2 = new WebsiteData();
        WebsiteData wd3 = new WebsiteData();



        websiteDatas.addAll(Arrays.asList(wd1,wd2,wd3));

    }

    @Override
    public void run() {

    }

    public static void main(String[] args){

    }



}
