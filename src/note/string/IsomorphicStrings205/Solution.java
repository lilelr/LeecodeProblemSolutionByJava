package note.string.IsomorphicStrings205;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by yuxiao on 16/4/19.
 * https://leetcode.com/problems/isomorphic-strings/
 */
public class Solution {

    // 20 ms
    public boolean isIsomorphicM(String s, String t) {
        if (s == null) return t == null;
        if (s.equals("")) return t.equals("");
        Map<Character, Character> map = new HashMap<Character, Character>();
        HashSet<Character> set = new HashSet<Character>();
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        for (int i = 0; i < sArr.length; i++){
            if (!map.containsKey(sArr[i])){
                map.put(sArr[i], tArr[i]);
                if (!set.add(tArr[i])) return false;
            }else
            if (tArr[i] != map.get(sArr[i])) return false;
        }
        return true;
    }

    //3 ms  great solution, so it uses the arrays to mimic two hash table,
    // but more efficient than hash table.
    public boolean isIsomorphic(String sString, String tString) {

        char[] s = sString.toCharArray();
        char[] t = tString.toCharArray();

        int length = s.length;
        if(length != t.length) return false;

        char[] sm = new char[256];
        char[] tm = new char[256];

        for(int i=0; i<length; i++){
            char sc = s[i];
            char tc = t[i];
            if(sm[sc] == 0 && tm[tc] == 0){
                sm[sc] = tc; // a->b
                tm[tc] = sc; // b->a
            }else{
                if(sm[sc] != tc || tm[tc] != sc){
                    return false;
                }
            }
        }
        return true;
    }


}
