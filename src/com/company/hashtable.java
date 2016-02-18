package com.company;


/**
 * Class for analysing wordlists in hashtables
 */
public class hashtable {

    // create a twodimensional array as hashtable
    static String[][] hashWordList;

    public static void analyseHashes(){
        // read files in hashtable
        hashWordList = reader.readfileHashOpen("wordlist.txt");

        // compare samples to hashtables
        compareSamples();
    }

    private static void compareSamples(){
        /* for every sample compare the words in the sample to
         * the words in the wordlist. Starts at 1, because when
         * starting at 0 the header is included.
         */
        for (int i = 1; i < 31; i++){
            // get the file name from place i and make array
            String file = Main.AllSamples[i];
            String[] samplearray = reader.readfileArray(file);

            // take time before comparing
            long time1 = System.nanoTime();

            // get number of words of sample that are in wordlist
            int good = numGoodOfSample(samplearray);

            // take time after comparing
            long time2 = System.nanoTime();
            // computes total time
            double totaltime = (time2 - time1);

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

        // get length of sample
        int length = Main.computelength(samplearray);

        // for every word, check if in list, if so count++
        for (int i = 0; i < length; i++){
            String word = samplearray[i];

            //check if the wordlist contains word
            if (contains(word)){
                // if so, count++
                count++;
            }
        }

        // return integer count
        return count;
    }

    // check if a word is included in wordlist
    private static boolean contains(String word){
        // get hashnumber
        int hashnumber = hash(word);
        int i = 0;

        while (true){
            // get the word in hashWordList at position [hashnumber][i]
            String wordoriginal = hashWordList[hashnumber][i];

            // if the word equals a word from the original list, return true
            if(word.equals(wordoriginal)){
                return true;

            // if there aren't words left in the array, break
            } else if (hashWordList[hashnumber][i] == null){
                break;
            }

            // increase integer i with 1
            i++;
        }

        // else return false
        return false;
    }

    // create a hashnumber from a word
    public static int hash(String word){

        // initialise counter
        int count = 0;

        // bring word to array of characters
        char[] wordChar = word.toCharArray();
        // an array with the alphabet
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
                'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
                'w', 'x', 'y', 'z'};

        // compute number for every char and add to count
        for(int i = 0; i<wordChar.length; i++){

            // get the character lowercase
            char lowerchar = Character.toLowerCase(wordChar[i]);

            // for every letter in the alphabet, check if equals
            for (int j = 0; j<26; j++){

                // if the character equals the letter from alphabet compute number
                if (lowerchar == alphabet[j]){

                    // add 3*number in alphabet + number in word
                    count = count + (3*j) + i;

                    // a character can never be two letters, so break
                    break;
                }
            }
        }

        // count modulo 600 so there is a maximum of 600 categories
        count = count % 600;

        // return count
        return count;
    }
}

