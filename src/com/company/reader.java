package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;



/* Class for reading files into arrays
 *
 */
public class Reader {

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
    public static String[][] readfileHashOpen(String file){
        // read file in words
        try {
            words = new BufferedReader(new FileReader(new File(file)));
        }

        // if it doesn't work, println with error
        catch (Exception e) {
            System.out.println("Error1" + e);
        }

        String[][] hashWords  = new String[600][10000];

        while (true) {
            try {
                // read next line to word
                String word = words.readLine();


                // if word is null break out while loop
                if (word == null) {
                    break;
                }

                int hashnum = Hashtable.hash(word);
                // add word to count
                for(int i = 0; i<10000; i++) {
                    if(hashWords[hashnum][i]==null){
                        hashWords[hashnum][i] = word;
                        break;
                    }
                }
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