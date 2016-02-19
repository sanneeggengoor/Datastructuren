package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Created by Sanne on 19-2-2016.
 */
public class TrieManager {
    // create bufferedreader words
    public static BufferedReader words;
    public static TrieNode wordTrie;

    public static TrieNode addWordList(){
        // read file in words
        try {
            words = new BufferedReader(new FileReader(new File("wordlist.txt")));
        }

        // if it doesn't work, println with error
        catch (Exception e) {
            System.out.println("Error1" + e);
        }

        wordTrie = new TrieNode();

        while (true) {
            try {
                // read next line to word
                String word = words.readLine();


                // if word is null break out while loop
                if (word == null) {
                    break;
                }

                readInWord(word);
            }

            // if it doesn't work, return error
            catch (Exception e) {//
                System.out.println("Error "+ e);
                break;
            }
        }

        return wordTrie;

    }

    public static TrieNode readInWord(String word){

        // create new wordTrie
        TrieNode wordTrie = new TrieNode();

        // loop through the letters of the word and add them
        // to the wordTrie
        for (int i = 0; i < word.length();i++) {

            // converse the letters to integers
            char let = word.charAt(i);
            let = Character.toLowerCase(let);
            int letter = let-'a';
            // if the letter isn't a letter, make it 26
            if(letter<0 || letter>25){
                letter = 26;
            }

            // if no word is found at that position, create new node
            if (wordTrie.getNext()[letter] == null) {
                wordTrie.getNext()[letter] = new TrieNode();
            }
            // wordTrie is the wordTrie plus the next letter
            wordTrie = wordTrie.getNext()[letter];
        }

        // add word to position
        wordTrie.addWord(word);

        return wordTrie;
    }

    // check if word is in trie
    public static boolean checkWord(String word, TrieNode wordTrie){
        // initiate integer for letter
        int letter;

        // loop through every letter in word
        for (int i = 0; i < word.length();i++) {

            // convert letter into integer
            char let = word.charAt(i);
            let = Character.toLowerCase(let);
            letter = let-'a';
            // if the letter isn't a letter make it 26
            if(letter<0 || letter>25){
                letter = 26;
            }

            // if this place does not exist, return false
            if (wordTrie.getNext()[letter] == null) {
                return false;
            }

            // go to next letter
            wordTrie = wordTrie.getNext()[letter];
        }

        // if the word in that place is the word, return true
        if(wordTrie.getWord()==word){
            return true;
        }

        // else return true
        return true;
    }

}
