package org.example;

import java.io.*;
import java.util.HashMap;

public class Measurement  {


    public static String [] splitText (String path){
        String [] result = null;
        String lineBuffer = null;
        String preSplitText = null;
        File fileReader = new File(path);
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader bufferedReaderFin = new BufferedReader(new FileReader(fileReader))) {
            while ((lineBuffer = bufferedReaderFin.readLine()) != null) {
                preSplitText += lineBuffer;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        result = preSplitText.split(" +");
        return result ;
    }


    public  static void wordCounter(String path) {
        String [] array = splitText(path);
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            counter++;
        }
        System.out.println(counter);
    }

    public static void maximumWordLength(String path){
        String [] result = splitText(path);
        String maxLenght = "" ;
        for (int i = 0; i < result.length; i++) {
            if ( result[i].length() > maxLenght.length() ){
                maxLenght = result[i];
            }
        }
        System.out.println(String.format("Самое длинное слово -> %s <-",maxLenght));
    }

    public static void duplicateWordCounter (String path){
        String [] result = splitText(path);
        HashMap<String, Integer> wordAndCounter = new HashMap<>();
        int buffer = 0;
        for (int i = 0; i < result.length; i++) {
            if (wordAndCounter.containsKey(result[i])){
                buffer = wordAndCounter.get(result[i]);
                wordAndCounter.put(result[i],buffer+1);
            }
            else {
                wordAndCounter.put(result[i],1);
            }
        }
        System.out.println("Слова и количество их повторений в тексте ");
        System.out.println(wordAndCounter);
    }
}
