package note.hashmap.AddandSearchWordDatastructuredesign211;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yuxiao on 8/4/16.
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/
 * HashMap Celebration
 */
public class WordDictionary {

    private HashMap<Integer, List<String>> map = new HashMap<>();

    public void addWord(String word) {
        int index = word.length();
        if (map.containsKey(index)) {
            map.get(index).add(word);
        } else {
            List<String> words = new ArrayList<>();
            words.add(word);
            map.put(index, words);
        }
    }

    public boolean search(String word) {
        int index = word.length();
        if (!map.containsKey(index)) {
            return false;
        }

        List<String> words = map.get(index);
        for (String itemWord : words) {
            if (isSame(word,itemWord,index)){
                return true;
            }

        }
        return false;
    }

    private boolean isSame(String word1,String word2,int  len){
        for (int i = 0; i < len; i++) {
            if (word1.charAt(i) != '.' && word1.charAt(i) != word2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
//        wordDictionary.addWord("bad");
//        wordDictionary.addWord("bad");
        System.out.println(wordDictionary.search("dad"));

        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b.."));
//        System.out.println(wordDictionary.search(""));
    }
}
