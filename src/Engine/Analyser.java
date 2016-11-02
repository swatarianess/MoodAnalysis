package Engine;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Steve on 02/11/2016.
 */
public class Analyser implements Runnable {

    private static HashMap<String,Integer> wordMap = new HashMap<>();
    private static ArrayList<WebsiteData> websiteDataArrayList = new ArrayList<>();

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

        WebsiteData wd1 = new WebsiteData();
        wd1.addThreadData("/wiki/Special:Random");
        websiteDataArrayList.add(wd1);

        //Map words with values
        wordMap = ep.getMoodValueMap();

        //Generate Value for
        ParsePage parsePage = new ParsePage(websiteDataArrayList.get(0).getUrl(),websiteDataArrayList.get(0).getThreadDatas().get(0));
        parsePage.run();

        //
        int result = calculateMoodValue(parsePage.getRawStrings());
        websiteDataArrayList.get(0).setMoodValue(result);
        System.out.printf("Moodvalue of %s%s is %s",websiteDataArrayList.get(0).getUrl(),websiteDataArrayList.get(0).getThreadDatas().get(0),websiteDataArrayList.get(0).getMoodValue() );
    }

    /**
     * @param wordsToCompare Array of words to compare against HashMap of words with values
     * @return Mood value of thread
     */
    private static int calculateMoodValue(ArrayList<String> wordsToCompare){
        int result = 0;
        if(!wordMap.isEmpty()) {
            try {
                String currentWord;

                for (String aWordsToCompare : wordsToCompare) {
                    currentWord = aWordsToCompare;

                    if (getWordMap().get(currentWord) != null) {
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
