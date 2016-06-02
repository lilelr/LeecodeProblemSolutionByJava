package note.sort.ValidAnagram242;

import java.util.Arrays;

/**
 * Created by yuxiao on 16/6/2.
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if(sLen != tLen) return false;
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        for(int i=0;i<sLen;i++){
            if(sArray[i] != tArray[i]) return false;
        }
        return true;
    }

}
