package com.company;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {

    static String[] arrayWords;
    static String[] arraySample;

    public static void main(String[] args) {
  //      try {
            arrayWords = reader.readfile("wordlist.txt");
            arraySample = reader.readfile("sample_o]_4D=12UBt.txt");
            int good = compareSample();
            System.out.println(good+"/"+arraySample.length);
    //    }
      //  catch (Exception e){
        //    System.out.println("Error!");
    //    }
    }

    private static int compareSample(){
        int count = 0;
        for (int i = 0; i < arraySample.length; i++){
            if (compare(arraySample[i])){
                count++;
            }
        }
        return count;
    }

    private static boolean compare(String word){
        for (int i = 0; i < arrayWords.length; i++) {

            if (word == arrayWords[i]){
                System.out.println("Hier ben ik nu");
                return true;
            }
        }
        return false;
    }
}
