package Drawing.Model;


import Engine.WebsiteData;
import javafx.collections.ObservableList;

/**
 * @author Stephen Adu
 */
public class Overseer{

    private ObservableList<WebsiteData> websiteObList;

    public ObservableList<WebsiteData> getWebsiteObList() {
        return websiteObList;
    }

    public void setWebsiteObList(ObservableList<WebsiteData> websiteObList) {
        this.websiteObList = websiteObList;
    }

    public void updateWebsiteDataObservableList(WebsiteData wd){
        this.websiteObList.add(wd);
    }

    public void updateThreadWebsiteDataObservableList(int index, String threadData){
        this.websiteObList.get(index).addThreadData(threadData);
    }
}
