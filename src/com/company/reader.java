package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/*
 * Created by Sanne on 5-2-2016.
 */
public class reader {
    public static BufferedReader words;

    public static String[] readfile(String file) {
        try {
            words = new BufferedReader(new FileReader(new File(file)));
        }
        catch(Exception e){
            //System.out.println(e);
            System.out.println("Error1");
        }
        String[] arrayWords = new String[1000000];
        int count = 0;
        while (true){
            try {
                String word = words.readLine();
                arrayWords[count]= word;
                if (word == null){
                    break;
                }
                count++;
            }
            catch (Exception e) {//
                System.out.println("Error ");
                break;
            }
        }
        System.out.println(arrayWords[0]);
        return arrayWords;
    }
}
