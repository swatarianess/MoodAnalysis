package utils;

/**
 * Created by Stephen Adu on 12/10/2016.
 */
public class threadData {

    private String[] strings;
    private int moodValue;
    private String url;

    public threadData(){
       this.url = "index.html";
    }

    public threadData(String url){
        this.url = url;
    }

    //Getters and Setters
    public void setStrings(String[] strings) {
        this.strings = strings;
    }

    public String[] getStrings() {
        return strings;
    }

    public double getMoodValue(){return this.moodValue;}

    public void setMoodValue(int moodValue) {
        this.moodValue = moodValue;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return String.valueOf(this.moodValue);
    }
}
