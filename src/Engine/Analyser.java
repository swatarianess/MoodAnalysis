package Engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Executor;

/**
 *  Handles webData and the various threads
 *
 * @author Steve
 */
@SuppressWarnings("unused")
class Analyser implements Runnable {

    private HashMap<String,Integer> wordMap;
    private WebsiteData websiteData;
    private String CurrentThread;
    private ParsePage page;

    @SuppressWarnings("WeakerAccess")
    public Analyser(WebsiteData wd){
        websiteData = wd;
    }

    public Analyser(WebsiteData wd, HashMap<String,Integer> wordMap){
        websiteData = wd;
        setWordMap(wordMap);
    }

    @Override
    public void run() {
        //Create Executor
        Executor executor = Runnable::run;

        //CreateParse
        setPage();

        //Execute webPage
        executor.execute(page);

        //Calculate and Print data.
        int currentMoodValue = calculateMoodValue(page.getRawStrings());

        websiteData.getThreadsArrayList().put(getCurrentThread(),currentMoodValue);
        websiteData.incrementMoodValue(currentMoodValue);
        System.out.println("[CT: " + getCurrentThread() + "] -> " + currentMoodValue);
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

                    if (wordMap.get(currentWord) != null) {
                        result += wordMap.get(currentWord);
                    }

                }
                return result;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    private HashMap<String, Integer> getWordMap() {
        return this.wordMap;
    }

    private void setPage(){
        this.page = new ParsePage(websiteData.getUrl(), CurrentThread);
    }

    private String getCurrentThread(){
        return this.CurrentThread;
    }

    public WebsiteData getWebsiteData() {
        return this.websiteData;
    }

    public ParsePage getPage(){
        return this.page;
    }

    int getWebsiteThreadSize(){
        return this.websiteData.getThreadsArrayList().size();
    }

    void setCurrentThread(String thread){CurrentThread = thread;}

    void setWordMap(HashMap<String, Integer> wordMap) {
        this.wordMap = wordMap;
    }

    @Override
    public String toString() {
        return "[Analyser " + getCurrentThread() + "]";
    }

}
