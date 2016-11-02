package Engine;

import java.util.ArrayList;

/**
 * Created by Steve on 12/10/2016.
 */
class WebsiteData{

    private String url;
    private int moodValue;
    private ArrayList<String> threadDatas = new ArrayList<>();

    public WebsiteData(String website){
        setUrl(website);
    }

    public WebsiteData()
    {
        setUrl("https://en.wikipedia.org");
    }


    //Getters and Setters

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getMoodValue() {
        return this.moodValue;
    }

    public void setMoodValue(int moodValue) {
        this.moodValue = moodValue;
    }

    public ArrayList<String> getThreadDatas() {
        return threadDatas;
    }

    public boolean addThreadData(String td){
       return threadDatas.add(td);
    }

}
