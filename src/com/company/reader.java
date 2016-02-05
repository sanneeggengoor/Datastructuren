package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

/**
 * Created by Sanne on 5-2-2016.
 */
public class reader {

    public void reader() {
        BufferedReader words = new BufferedReader(new FileReader("wordlist.txt"));
        ArrayList<String> arrayWords = new ArrayList();
        while (true){
            String word = words.readLine();
            if (word == ""){
                break;
            }
            arrayWords.add(word);
        }
        System.out.println(arrayWords);
    }
}
