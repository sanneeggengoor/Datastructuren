package com.company;



/**
 * Created by Sanne on 14-2-2016.
 */
public class hashtable {

    static String[][] hashWordList;
    static String[] AllSamples;
    public static void createHashes(){
        hashWordList = reader.readfileHash("wordlist.txt");
        AllSamples = reader.readfileArray("samplestext.txt");
        compareSamples();
    }

    private static void compareSamples(){
        /* for every sample compare the words in the sample to
         * the words in the wordlist. Starts at 1, because when
         * starting at 0 an error occurs.
         */
        for (int i = 1; i < 31; i++){
            // get the file name from place i and make array
            String file = AllSamples[i];
            String[] samplearray = reader.readfileArray(file);

            // take time before comparing
            long time1 = System.nanoTime();

            // get number of words of sample that are in wordlist
            int good = numGoodOfSample(samplearray);

            // take time after comparing
            long time2 = System.nanoTime();
            // computes total time
            long totaltime = time2 - time1;

            int length = Main.computelength(samplearray);



            /* prints information about which sample has how many
             * good words and how many time it has taken.
             */
            System.out.println(file);
            System.out.println("time : "+ totaltime);
            System.out.println(good+"/"+length);
        }


    }

    // get integer with how many words of sample are in wordlist
    private static int numGoodOfSample(String[] samplearray){
        // initiate counter and get num of words in sample
        int count = 0;
        int length = Main.computelength(samplearray);

        // for every word, check if in list, if so count++
        for (int i = 0; i < length; i++){
            String word = samplearray[i];
            int hashnumber = hash(word);
            if (hashWordList.con){ //HIER VERDER STRAKS!
                count++;
            }
        }

        // return integer count
        return count;
    }

    public static int hash(String word){
        int count = 0;
        char[] wordChar = word.toCharArray();
        char [] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
                'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
                'w', 'x', 'y', 'z'};
        for(int i = 0; i<wordChar.length; i++){
            char lowerchar = Character.toLowerCase(wordChar[i]);
            for (int j = 0; j<26; j++){
                if (lowerchar == alphabet[j]){
                    count = count + (3*j) + i;
                    break;
                }
            }
        }
        count = count % 600;
        return count;
    }
}

