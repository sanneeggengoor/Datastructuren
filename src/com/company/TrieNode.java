package com.company;

/**
 * Class for Trienodes
 */


public  class TrieNode {
    private String wordNow;
    private TrieNode[] nextNodes;

    // create new TrieNode
    public TrieNode() {
        nextNodes = new TrieNode[27];
    }

    // add word to position
    public void addWord(String word){
        this.wordNow = word;
    }

    // get the word from position
    public String getWord(){
        return this.wordNow;
    }

    // go to next node
    public TrieNode[] getNext() {
        return nextNodes;
    }

}
