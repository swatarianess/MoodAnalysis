package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Stephen Adu on 20/02/2017.
 */
public class Website {

    private StringProperty url;
    private StringProperty websiteTitle = new SimpleStringProperty("null");
    private Set<Webpage> pages;
    private ArrayList<String> threadUrls;

    public Website(String url){
        this.url = new SimpleStringProperty(url);
        this.pages = new LinkedHashSet<>();
        this.threadUrls = new ArrayList<>();
    }

    public String getWebsiteTitle() {
        return websiteTitle.get();
    }

    public String getUrl(){return url.get();}

    public void setUrl(String url){
        this.url.setValue(url);
    }

    public void addThreadUrl(String url){this.threadUrls.add(url);}

    public Set<Webpage> getPages(){
        return this.pages;
    }

    public ArrayList<String> getThreadUrls(){return threadUrls;}

    public void setPages(Set<Webpage> pages) {
        this.pages = pages;
    }

    //TODO: Modify and or move calculateAverage method to more appropriate place
    public ArrayList<Integer> calculateAverage(){
        /*ArrayList<Integer> averageScores = new ArrayList<>();
        int numberOfScores;
        ArrayList<Integer> sum = new ArrayList<>();

        for (String key : pages.keySet()) {
            ArrayList<Integer> scores = pages.get(key);
            if (!(scores.isEmpty())) {
                numberOfScores = scores.size();
                for (int i = 0; i <= (numberOfScores - 1); i++) {
                    if (!(sum.isEmpty()) && (sum.size() > i)) {
                        sum.set(i, (sum.get(i) + scores.get(i)));
                    } else {
                        sum.add(scores.get(i));
                    }
                }
            }
        }

        for (Integer score : sum) {
            averageScores.add(sum.indexOf(score), (score / (pages.size())));
        }
        return averageScores;*/
        return new ArrayList<>();
    }

    @Override
    public String toString() {
        return String.format("Website: {\n\t Title:%s \n\t Url:%s \n\t Pages:%s \n } ", websiteTitle, url.get(), Arrays.toString(pages.toArray()));
    }
}
