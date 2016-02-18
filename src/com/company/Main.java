package com.company;



public class Main {

    public static String[] AllSamples;

    public static void main(String[] args) {
        // create an array with all
        AllSamples = reader.readfileArray("samplestext.txt");

        // analyse data in hashtable
        hashtable.analyseHashes();

        // analyse data in arrays
        arrays.analyseArray();
    }

    // get number of words in array
    public static int computelength(String[] arr){
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
