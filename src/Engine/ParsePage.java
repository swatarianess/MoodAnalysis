package Engine;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Steve
 */
public class ParsePage implements Runnable{

    private ArrayList<String> rawStrings = new ArrayList<>();

    private String website;
    private String threadName;

    ParsePage(String website, String threadName){
        this.website = website;
        this.threadName = threadName;
        System.out.println("Creating " + threadName);
    }


    @Override
    public void run() {
        System.out.println("Running " + threadName);
        try {
            URL url = new URL(website + threadName);

            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while ((line = in.readLine()) != null) {
                String s = extractText(line);
                fillWithWords(s.toUpperCase());
            }
            in.close();
        } catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        }
    }


    private void fillWithWords(String s){
        if(!s.isEmpty()){
            s = s.replaceAll("[\\-+\\.\\^:,]","");
            String[] split = s.split(" ");
            Collections.addAll(rawStrings, split);
        }
    }

    private String extractText(String html) throws IOException {
        final ArrayList<String> list = new ArrayList<>();

        ParserDelegator parserDelegator = new ParserDelegator();
        HTMLEditorKit.ParserCallback parserCallback = new HTMLEditorKit.ParserCallback() {
            public void handleText(final char[] data, final int pos) {
                list.add(new String(data));
            }
            public void handleStartTag(HTML.Tag tag, MutableAttributeSet attribute, int pos) { }
            public void handleEndTag(HTML.Tag t, final int pos) {  }
            public void handleSimpleTag(HTML.Tag t, MutableAttributeSet a, final int pos) { }
            public void handleComment(final char[] data, final int pos) { }
            public void handleError(final java.lang.String errMsg, final int pos) { }
        };
        parserDelegator.parse(new StringReader(html), parserCallback, true);

        String text = "";

        for(String s : list) {
            text += " " + s;
        }

        return text;
    }

    public ArrayList<String> getRawStrings(){
        return rawStrings;
    }


}