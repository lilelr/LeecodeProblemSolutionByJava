package note.hashmap.LongestSubstringWithoutRepeatingCaharacters3;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuxiao on 8/9/16.
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 */
public class Solution {
//    public int lengthOfLongestSubstring(String s) {
//        if (s.length() == 0) return 0;
//        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
//        int max = 0;
//        for (int i = 0, j = 0; i < s.length(); ++i) {
//            if (map.containsKey(s.charAt(i))) {
//                j = Math.max(j, map.get(s.charAt(i)) + 1);
//            }
//            map.put(s.charAt(i), i);
//            max = Math.max(max, i - j + 1);
//        }
//        return max;
//    }

//    public int lengthOfLongestSubstring(String s) {
//        /*
//        **O(n^2) worest case run time, happens when there is no repeating characters in the string
//        **O(1) space
//        **keep 2 pointers for the start and end of the substring
//        */
//        if (s == null || s.equals("")) return 0;
//
//        //actually do not need to keep the start and end of the substring. Can only use one int value to keep the longest length of the substring
//        int start = 0;
//        int end = 0;
//        int tmpstart = 0;
//        int tmpend = 1;
//        for (; tmpend < s.length(); tmpend++){
//            for (int i = tmpstart; i  < tmpend; i++) {
//                if (s.charAt(tmpend) == s.charAt(i)) {
//                    tmpstart = i + 1;
//                }
//            }
//            if (tmpend - tmpstart + 1 > end - start + 1) {
//                start = tmpstart;
//                end = tmpend;
//            }
//        }
//
//        return end - start + 1;
//    }

    //https://discuss.leetcode.com/topic/50224/java-easy-to-understand-dp-solution-with-detailed-explanation
    public int lengthOfLongestSubstring(String s) {

        //it is DP problem with O(n)
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
