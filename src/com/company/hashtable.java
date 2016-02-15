package com.company;


import java.util.Hashtable;

/**
 * Created by Sanne on 14-2-2016.
 */
public class hashtable {

    public static Hashtable<Integer, String> hashWordList;
    public static Hashtable<Integer, String> hashWordSamples;
    public static Hashtable<Integer,String> hashSample;
    public static void createHashes(){
        hashWordList = reader.readfileHash("wordlist.txt");
        hashWordSamples = reader.readfileHash("samplestext.txt");
        compareSamples();


    }

    private static void compareSamples(){
        /* for every sample compare the words in the sample to
         * the words in the wordlist. Starts at 1, because when
         * starting at 0 an error occurs.
         */
        for (int i = 1; i < 31; i++){
            // get the file name from place i and make array
            String file = hashWordSamples.get(i);
            hashSample= reader.readfileHash(file);

            // take time before comparing
            long time1 = System.nanoTime();

            // get number of words of sample that are in wordlist
            int good = numGoodOfSample();

            // take time after comparing
            long time2 = System.nanoTime();
            // computes total time
            long totaltime = time2 - time1;



            /* prints information about which sample has how many
             * good words and how many time it has taken.
             */
            System.out.println(file);
            System.out.println("time : "+ totaltime);
            System.out.println(good+"/"+hashSample.size());
        }


    }

    // get integer with how many words of sample are in wordlist
    private static int numGoodOfSample(){
        // initiate counter and get num of words in sample
        int count = 0;

        // for every word, check if in list, if so count++
        for (int i = 0; i < hashSample.size(); i++){
            String word = hashSample.get(i);
            if (hashWordList.contains(word)){
                count++;
            }
        }

        // return integer count
        return count;
    }
}
