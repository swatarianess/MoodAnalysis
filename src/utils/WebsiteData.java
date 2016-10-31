package utils;

import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by Steve on 12/10/2016.
 */
public class WebsiteData extends Observable {

    private String url;
    private int moodValue;
    private ArrayList<ThreadData> ThreadDatas;

    public WebsiteData(String website){
        setUrl(website);
    }

    public WebsiteData()
    {
        setUrl("Wikipedia.com");
    }


    //Getters and Setters

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getMoodValue() {
        int totalMoodValue = 0;
        for (ThreadData td: ThreadDatas) {
            totalMoodValue += td.getMoodValue();
        }
        setMoodValue(totalMoodValue);
        return this.moodValue;
    }

    private void setMoodValue(int moodValue) {
        this.moodValue = moodValue;
    }

    public ArrayList<ThreadData> getThreadDatas() {
        return ThreadDatas;
    }

    public void setThreadDatas(ArrayList<ThreadData> ThreadDatas) {
        this.ThreadDatas = ThreadDatas;
    }

    public void addThreadData(ThreadData td){
        ThreadDatas.add(td);
    }

    private void generateMoodValue(){

    }
}
