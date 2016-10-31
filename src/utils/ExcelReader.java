package utils;

import java.io.*;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Steve on 20/10/2016.
 */
public class ExcelReader{

    private static InputStream in = ExcelReader.class.getResourceAsStream("WordValues.csv");

    public ExcelReader(){

    }

    public static void main(String[] args){
        BufferedReader buffer = null;
        final String pattern = "(\\w.*)[?;](.*)";
        Pattern r = Pattern.compile(pattern);

        try {
            String line;
            buffer = new BufferedReader(new InputStreamReader(in));

            while ((line = buffer.readLine()) != null){
                Matcher m = r.matcher(line);
                if(m.find()) {
                    System.out.printf("Word: %s | Value: %s \n", m.group(1), m.group(2));

                    HashMap<String,Integer> result = new HashMap<>();
                    result.put(m.group(1), Integer.parseInt(m.group(2)));
                    System.out.println(result);
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
