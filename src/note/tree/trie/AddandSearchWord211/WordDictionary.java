package note.tree.trie.AddandSearchWord211;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuxiao on 8/4/16.
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/
 */

//https://discuss.leetcode.com/topic/14209/my-java-trie-based-solution
public class WordDictionary {

    class TrieNode {
        boolean endHere;  // empty string, 1 node; string of length n, (n + 1) nodes.
        TrieNode[] branch;

        TrieNode() {
            endHere = false;
            branch = new TrieNode[26];
        }
    }

    TrieNode root = new TrieNode();

    // Adds a word into the data structure.
    public void addWord(String word) {
        addWord(word, 0, root);
    }

    private void addWord(String word, int p, TrieNode node) {
        if (p == word.length()) {
            node.endHere = true;
            return;
        }
        int index = word.charAt(p) - 'a';
        TrieNode succ = node.branch[index];
        if (succ == null) {
            succ = new TrieNode();
            node.branch[index] = succ;
        }
        addWord(word, p + 1, succ);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(word, 0, root);
    }

    private boolean search(String word, int p, TrieNode node) {

        if (p == word.length()) {
            return node.endHere;
        }
        char c = word.charAt(p);
        if (c != '.') {
            if (node.branch[c - 'a'] == null) {
                return false;
            }
            return search(word, p + 1, node.branch[c - 'a']);
        } else {
            // c == '.', we need to try every letter
            for (int i = 0; i < 26; i++) {
                if (node.branch[i] != null && search(word, p + 1, node.branch[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    @Test
    public void test() {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
//        wordDictionary.addWord("bad");
//        wordDictionary.addWord("bad");
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b.."));
//        System.out.println(wordDictionary.search(""));
    }
}


// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");