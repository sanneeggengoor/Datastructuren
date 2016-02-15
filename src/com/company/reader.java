package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Hashtable;


/* Class for reading files into arrays
 *
 */
public class reader {

    // create bufferedreader words
    public static BufferedReader words;


    // create an array of strings from file
    public static String[] readfileArray(String file) {
        // read file in words
        try {
            words = new BufferedReader(new FileReader(new File(file)));
        }

        // if it doesn't work, println with error
        catch (Exception e) {
            System.out.println("Error1" + e);
        }

        // create array of string with 1000000 places
        String[] arrayWords = new String[1000000];

        // initiate counter
        int count = 0;

        // while true, add word to the array at place count
        while (true) {
            try {
                // read next line to word
                String word = words.readLine();
                // add word to count
                arrayWords[count] = word;

                // if word is null break out while loop
                if (word == null) {
                    break;
                }

                // count + 1
                count++;
            }

            // if it doesn't work, return error
            catch (Exception e) {//
                System.out.println("Error ");
                break;
            }
        }

        // return the array with the words
        return arrayWords;
    }


    // create a hashtable from file
    public static Hashtable<Integer, String> readfileHash(String file){
        // read file in words
        try {
            words = new BufferedReader(new FileReader(new File(file)));
        }

        // if it doesn't work, println with error
        catch (Exception e) {
            System.out.println("Error1" + e);
        }

        Hashtable<Integer, String> hashWords = new Hashtable<Integer, String>(999999);
        int count = 0;
        while (true) {
            try {
                // read next line to word
                String word = words.readLine();


                // if word is null break out while loop
                if (word == null) {
                    break;
                }

                // add word to count
                hashWords.put(count, word);

                // count + 1
                count++;
            }

            // if it doesn't work, return error
            catch (Exception e) {//
                System.out.println("Error "+ e);
                break;
            }
        }
        return hashWords;

    }

}