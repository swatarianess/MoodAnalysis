package Engine;

import java.io.*;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Steve on 20/10/2016.
 */

class ExcelParser implements Runnable {

    private static InputStream in = ExcelParser.class.getResourceAsStream("/values/WordValues.csv");

    private static HashMap<String, Integer> moodValueMap;

    ExcelParser(){
        moodValueMap = new HashMap<>();
    }


    HashMap<String, Integer> getMoodValueMap() {
        return moodValueMap;
    }

    public static void setMoodValueMap(HashMap<String, Integer> moodValueMap) {
        ExcelParser.moodValueMap = moodValueMap;
    }

    private static void addMoodValueItem(String word, Integer value){
        moodValueMap.put(word,value);
    }

    @Override
    public void run() {
        BufferedReader buffer = null;
        final String pattern = "(\\w.*)[?;](.*)";
        Pattern r = Pattern.compile(pattern);
        try {
            String line;
            buffer = new BufferedReader(new InputStreamReader(in));

            while ((line = buffer.readLine()) != null){
                Matcher m = r.matcher(line);
                if(m.find()) {
//                    System.out.printf("Word: %s | Value: %s \n", m.group(1), m.group(2));
                    addMoodValueItem(m.group(1), Integer.parseInt(m.group(2)));
                }
            }

        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                if(buffer != null)
                    buffer.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }


}
