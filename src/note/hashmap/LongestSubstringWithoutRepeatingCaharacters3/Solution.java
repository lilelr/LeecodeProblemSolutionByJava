package note.hashmap.LongestSubstringWithoutRepeatingCaharacters3;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuxiao on 8/9/16.
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class Solution {

    //https://discuss.leetcode.com/topic/50224/java-easy-to-understand-dp-solution-with-detailed-explanation
    // O(n)
    public int lengthOfLongestSubstring(String s) {

        int l = s.length();
        int maxl = 0;
        int dupindex = -1;
        int count = 0;
        if (l == 1) return 1;
        //map char to its index
        Map<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < l; i++) {
            //not only check if it  has duplicate
            //but also check if  the duplicate  appear before dupindex (should not be used)
            //(in other words, be updated by new index)
            if (hm.containsKey(s.charAt(i)) && hm.get(s.charAt(i)) > dupindex) {
                //get length
                count = i - 1 - dupindex;
                dupindex = hm.get(s.charAt(i));//new substring will start form dupindex+1
                //update its value(index)
                hm.put(s.charAt(i), i);
                if (count > maxl) maxl = count;
            } else {
                hm.put(s.charAt(i), i);
            }

        }
        //reach the end, process last substring
        if (((l - 1) - dupindex) > maxl) return ((l - 1) - dupindex);
        else return maxl;
    }

    @Test
    public void test() {
//        String s = "abcabcbb";
        String s = "abbebcbb";
        int res = lengthOfLongestSubstring(s);
        System.out.println(res);
    }
}
