package Engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Executor;

/**
 *  Handles webData and the various threads
 *
 * @author Steve
 */
public class Analyser implements Runnable {

    private static HashMap<String,Integer> wordMap;
    private WebsiteData websiteData;
    private static String CurrentThread;


    Analyser(WebsiteData wd){
        websiteData = wd;
    }

    @Override
    public void run() {
        //Create Executor
        Executor executor = Runnable::run;

        //CreateParse
        ParsePage page = new ParsePage(getWebsiteData().getUrl(), CurrentThread);
        executor.execute(page);
        System.out.println("[CT: " + getCurrentThread() + "] -> " + calculateMoodValue(page.getRawStrings()));

    }

    /**
     * @param wordsToCompare Array of words to compare against HashMap of words with values
     * @return Mood value of thread
     */
    private int calculateMoodValue(ArrayList<String> wordsToCompare){
        int result = 0;
        if(!getWordMap().isEmpty()) {
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


    public int getWebsiteThreadSize(){
        return websiteData.getThreadsArrayList().size();
    }

    public WebsiteData getWebsiteData() {
        return websiteData;
    }

    public String getCurrentThread(){
        return CurrentThread;
    }

    public void setCurrentThread(String thread){CurrentThread = thread;}

    public static void setWordMap(HashMap<String, Integer> wordMap) {
        Analyser.wordMap = wordMap;
    }

    private static HashMap<String, Integer> getWordMap() {
        return wordMap;
    }

    @Override
    public String toString() {
        return "[Analyser " + getCurrentThread() + "]";
    }
}
