package Engine;

import java.util.ArrayList;

/**
 * Created by Steve on 12/10/2016.
 */
class WebsiteData{

    private String url;
    private int moodValue;
    private ArrayList<String> threadDatas;

    public WebsiteData(String website){
        setUrl(website);
    }

    public WebsiteData()
    {
        setUrl("https://en.wikipedia.org/");
    }


    //Getters and Setters

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getMoodValue() {
        return 0;
    }

    private void setMoodValue(int moodValue) {
        this.moodValue = moodValue;
    }

    public ArrayList<String> getThreadDatas() {
        return threadDatas;
    }

    public void setThreadDatas(ArrayList<String> ThreadDatas) {
        this.threadDatas = ThreadDatas;
    }

    public void addThreadData(String td){
        threadDatas.add(td);
    }

    private void generateMoodValue(){

    }
}
