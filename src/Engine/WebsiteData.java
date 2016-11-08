package Engine;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.HashMap;

/**
 * Model class for Website
 *
 * @author Steve
 */
public class WebsiteData{

    private SimpleStringProperty url = new SimpleStringProperty();
    private SimpleIntegerProperty moodValue = new SimpleIntegerProperty();
    private HashMap<String,Integer> threadsArrayList = new HashMap<>();

    public WebsiteData(String website){
        url.set(website);
    }

    public WebsiteData()
    {
        url.set("https://en.Wikipedia.org/");
    }

    //Getters and Setters

    String getUrl() {
        return url.getValue();
    }

    void setUrl(String url) {
        this.url.setValue(url);
    }

    public IntegerProperty getMoodValue() {
        return this.moodValue;
    }

    public void setMoodValue(int moodValue) {
        this.moodValue.set(moodValue);
    }

    public void addThreadData(String td){
        threadsArrayList.put(td,0);
    }

    public void addThreadData(String ... td){
        for (String aTd : td) {
            threadsArrayList.put(aTd, 0);
        }
    }

    public HashMap<String,Integer> getThreadsArrayList() {
        return threadsArrayList;
    }


}
