package Engine;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Stephen Adu on 02/11/2016.
 */
public class Analyser implements Runnable {

    private static HashMap<String,Integer> wordMap;

    public Analyser(WebsiteData websiteData){

    }

    public static HashMap<String, Integer> getWordMap() {
        return wordMap;
    }

    @Override
    public void run() {

    }

    public static void main(String[] args){
        //Parse excel document
        ExcelParser ep = new ExcelParser();
        ep.run();

        //Map words with values
        wordMap = ep.getMoodValueMap();

        //Generate Value for
        ParsePage parsePage = new ParsePage("https://en.wikipedia.org","/wiki/Special:Random");
        parsePage.run();

        System.out.println(getMoodValue(parsePage.getRawStrings()));

    }

    public static int getMoodValue(ArrayList<String> wordsToCompare){
        int result = 0;
        if(!wordMap.isEmpty()) {
            try {
                String currentWord = "";

                for(int i = 0; i < wordsToCompare.size();i++){
                    currentWord = wordsToCompare.get(i);

                    if(getWordMap().get(currentWord) != null){
                        result += getWordMap().get(currentWord);
                    }

                }
                return result;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

}
