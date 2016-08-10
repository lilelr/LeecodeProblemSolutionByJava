package note.string.ReverseWordsInaString151;

import org.junit.Test;

/**
 * Created by yuxiao on 8/10/16.
 * https://leetcode.com/problems/reverse-words-in-a-string/
 */
public class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        if(s.equals("")){
            return s;
        }
        String[] listStrs = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = listStrs.length - 1; i > 0; i--) {
            if(listStrs[i].equals(" ") || listStrs[i].isEmpty()) continue;
            sb.append(listStrs[i] + " ");
        }
        sb.append(listStrs[0]);
        return sb.toString();
    }

    @Test
    public void test(){
//        String str = "the sky is blue";
        String str = "   a   b ";
        System.out.println(reverseWords(str));
    }


}
