package com.company;



public class Main {

    static String[] arrayWords;
    static String[] arraySample;
    public static String[] allsamples;

    public static void main(String[] args) {
        hashtable.createHashes();
        // make an array with all the filenames of the samples
        // allsamples = reader.readfileArray("samplestext.txt");
        // make an array with all the words
        // arrayWords = reader.readfileArray("wordlist.txt");
        // compare the samples with the wordlist
        // compareSample();


    }

    // compares samples with the wordlist
    private static void compareSample(){
        /* for every sample compare the words in the sample to
         * the words in the wordlist. Starts at 1, because when
         * starting at 0 an error occurs.
         */
        for (int i = 1; i < 31; i++){
            // get the file name from place i and make array
            String file = allsamples[i];
            arraySample = reader.readfileArray(file);

            // take time before comparing
            long time1 = System.nanoTime();

            // get number of words of sample that are in wordlist
            int good = numGoodOfSample();

            // take time after comparing
            long time2 = System.nanoTime();
            // computes total time
            long totaltime = time2 - time1;

            // find out how many words in sample
            int length = computelength(arraySample);


            /* prints information about which sample has how many
             * good words and how many time it has taken.
             */
            System.out.println(file);
            System.out.println("time : "+ totaltime);
            System.out.println(good+"/"+length);
        }


    }

    // get integer with how many words of sample are in wordlist
    private static int numGoodOfSample(){
        // initiate counter and get num of words in sample
        int count = 0;
        int length = computelength(arraySample);

        // for every word, check if in list, if so count++
        for (int i = 0; i < length; i++){
            if (compare(arraySample[i])){
                count++;
            }
        }

        // return integer count
        return count;
    }

    // boolean that checks if word is in wordlist
    private static boolean compare(String word){
        // get num of words in wordlist
        int length = computelength(arrayWords);

        // for every word in list, check if equal to word
        for (int i = 0; i < length; i++) {
            // if so, return true
            if (word.equals(arrayWords[i])){
                return true;
            }
        }

        // else return false
        return false;
    }

    // get number of words in array
    private static int computelength(String[] arr){
        // initiate counter
        int index = 0;

        // while the array at index isn't null, index++
        while (true){
            if (arr[index] == null){
                break;
            }
            index++;
        }

        // return index integer
        return index;
    }
}
