package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

/**
 * Created by Sanne on 5-2-2016.
 */
public class reader {
    BufferedReader words;

    public void reader() {
        try {
            words = new BufferedReader(new FileReader("wordlist.txt"));
        }
        catch(Exception e){
            System.out.println("Error");
        }
        ArrayList<String> arrayWords = new ArrayList();
        while (true){
            try {
                String word = words.readLine();
                arrayWords.add(word);
            }
            catch (Exception e) {//            if (word == ""){
                break;
            }
        }
        System.out.println(arrayWords);
    }
}
