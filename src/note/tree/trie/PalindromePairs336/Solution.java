package note.tree.trie.PalindromePairs336;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yuxiao on 8/12/16.
 * https://leetcode.com/problems/palindrome-pairs/
 */

//  O(n*k^2) java solution with Trie structure (n: total number of words; k: average length of each word)
// https://discuss.leetcode.com/topic/39585/o-n-k-2-java-solution-with-trie-structure-n-total-number-of-words-k-average-length-of-each-word
// 55ms
public class Solution {
    class TrieNode {
        TrieNode[] next;
        int index;
        List<Integer> list;

        TrieNode() {
            next = new TrieNode[26];
            index = -1;
            list = new ArrayList<>(); // record the index of word whose prefix substring  from 0 to i is palindrome
        }
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();

        TrieNode root = new TrieNode();

        for (int i = 0; i < words.length; i++) {
            addWord(root, words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            search(words, i, root, res);
        }

        return res;
    }

    private void addWord(TrieNode root, String word, int index) {
        for (int i = word.length() - 1; i >= 0; i--) {
            if (root.next[word.charAt(i) - 'a'] == null) {
                root.next[word.charAt(i) - 'a'] = new TrieNode();
            }

            //if the prefix substring of word from 0 to i is palindrome, add its index to root.list.
            if (isPalindrome(word, 0, i)) {
                root.list.add(index);
            }

            root = root.next[word.charAt(i) - 'a'];
        }

        root.list.add(index);
        root.index = index;
    }

    private void search(String[] words, int i, TrieNode root, List<List<Integer>> list) {
        for (int j = 0; j < words[i].length(); j++) {
            if (root.index >= 0 && root.index != i && isPalindrome(words[i], j, words[i].length() - 1)) {
                // words[i] is the long word, for example words[i] = ls, curWord = s
                list.add(Arrays.asList(i, root.index));
            }

            root = root.next[words[i].charAt(j) - 'a'];
            if (root == null) return;
        }

        for (int j : root.list) {
            if (i == j) continue;
            // words[i] becomes the short word, for example words[i]=s, curWord = ls
            list.add(Arrays.asList(i, j));
        }
    }


    // judge whether word is palindrome
    private boolean isPalindrome(String word, int i, int j) {
        while (i < j) {
            if (word.charAt(i++) != word.charAt(j--)) return false;
        }

        return true;
    }
}
