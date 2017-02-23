package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Stephen Adu on 20/02/2017.
 */
public class Webpage {

    private StringProperty url;
    private IntegerProperty value = new SimpleIntegerProperty(0);
    private Website website; //Owner

    public Webpage(String url, Website website){
        this.url = new SimpleStringProperty(url);
        this.website = website;

    }

    public String getUrl() {
        return url.get();
    }

    public void setUrl(String url) {
        this.url.set(url);
    }

    public int getValue() {
        return value.get();
    }

    public void setValue(int value) {
        this.value.set(value);
    }

    public StringProperty urlProperty() {return url;}

    public IntegerProperty valueProperty(){return value;}
}
