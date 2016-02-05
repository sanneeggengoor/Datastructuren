package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by Sanne on 5-2-2016.
 */
public class reader {
    public static BufferedReader words;

    public static void reader() {
        try {
            words = new BufferedReader(new FileReader(new File("wordlist.txt")));
        }
        catch(Exception e){
            System.out.println(e);
            System.out.println("Error");
        }
        String[] arrayWords = new String[10000000];
        int count = 0;
        while (true){
            try {
                String word = words.readLine();
                arrayWords[count]= word;
                if (word == ""){
                    break;
                }
                count++;
            }
            catch (Exception e) {//            if (word == ""){
                System.out.println("Error");
            }
        }
        System.out.println(arrayWords.length);
    }
}
