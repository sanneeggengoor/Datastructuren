package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.SyncFailedException;

public class Main {

    static String[] arrayWords;
    static String[] arraySample;

    public static void main(String[] args) {
  //      try {
            arrayWords = reader.readfile("wordlist.txt");
            arraySample = reader.readfile("sample_o]_4D=12UBt.txt");
            System.out.println(arraySample[999999]);
            int good = compareSample();
            int length = computelength(arraySample);
            System.out.println(good+"/"+length);
    //    }
      //  catch (Exception e){
        //    System.out.println("Error!");
    //    }
    }

    private static int compareSample(){
        int count = 0;
        int length = computelength(arraySample);
        for (int i = 0; i < length; i++){
            if (compare(arraySample[i])){
                count++;
            }
        }
        return count;
    }

    private static boolean compare(String word){
        int length = computelength(arrayWords);
        //System.out.print(length);
        for (int i = 0; i < length; i++) {

            if (word.equals(arrayWords[i])){
                System.out.println("Hier ben ik nu");
                return true;
            }
        }
        return false;
    }

    private static int computelength(String[] arr){
        int index = 0;
        while (true){
            if (arr[index] == null){
                break;
            }
            index++;
        }
        return index;
    }
}
