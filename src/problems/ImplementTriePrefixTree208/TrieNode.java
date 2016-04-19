package problems.ImplementTriePrefixTree208;

import java.util.HashMap;

/**
 * Created by yuxiao on 16/4/18.
 */
class TrieNode {

    private HashMap<Character,TrieNode> children;

    // Initialize your data structure here.


    public TrieNode() {
        this.children = new HashMap<>();
    }

    public TrieNode(Character c){

    }

    public HashMap<Character, TrieNode> getChildren() {
        return children;
    }

    public void setChildren(HashMap<Character, TrieNode> children) {
        this.children = children;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        HashMap<Character,TrieNode> children;
        for(int i=0;i<word.length();i++){
            char term = word.charAt(i);
            if(i==0){
                children = root.getChildren();
                if(children.containsKey(term)){

                } else{

                }
            }
        }

    }

    // Returns if the word is in the trie.
    public boolean search(String word) {

    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {

    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
