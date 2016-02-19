package com.company;

/**
 * Created by Sanne on 18-2-2016.
 */
public class Trie {
    static String[] arraySample;
    static TrieNode wordTrie;

    public static void analyseTrie(){
        wordTrie = TrieManager.addWordList();

        compareSample();
    }

    private static void compareSample(){
        for (int i = 1; i < 31; i++){
            // get the file name from place i and make array
            String file = Main.AllSamples[i];
            arraySample = Reader.readfileArray(file);

            // take time before comparing
            long time1 = System.nanoTime();

            // get number of words of sample that are in wordlist
            int good = numGoodOfSample();

            // take time after comparing
            long time2 = System.nanoTime();
            // computes total time
            long totaltime = time2 - time1;

            // find out how many words in sample
            int length = Main.computelength(arraySample);


            /* prints information about which sample has how many
             * good words and how many time it has taken.
             */
            System.out.println("Trie");
            System.out.println(file);
            System.out.println("time : "+ totaltime);
            System.out.println(good+"/"+length);
        }

    }

    private static int numGoodOfSample(){
        // initiate counter and get num of words in sample
        int count = 0;
        int length = Main.computelength(arraySample);

        // for every word, check if in list, if so count++
        for (int i = 0; i < length; i++){
            if (TrieManager.checkWord(arraySample[i], wordTrie)){
                count++;
            }
        }

        // return integer count
        return count;

    }
}
