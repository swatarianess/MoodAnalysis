package utils;

import java.util.ArrayList;

/**
 * Created by Stephen Adu on 12/10/2016.
 */
@SuppressWarnings("SpellCheckingInspection")
public class websiteData {

    private String url;
    private double moodValue;
    private ArrayList<threadData> threadDatas;

    public websiteData(String website){
        setUrl(website);
    }

    public websiteData()
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

    public double getMoodValue() {
        double totalMoodValue = 0.00;
        for (threadData td: threadDatas) {
            totalMoodValue += td.getMoodValue();
        }
        setMoodValue(totalMoodValue);
        return this.moodValue;
    }

    private void setMoodValue(double moodValue) {
        this.moodValue = moodValue;
    }

    public ArrayList<threadData> getThreadDatas() {
        return threadDatas;
    }

    public void setThreadDatas(ArrayList<threadData> threadDatas) {
        this.threadDatas = threadDatas;
    }

    public void addThreadData(threadData td){
        threadDatas.add(td);
    }

    private void generateMoodValue(){

    }
}
