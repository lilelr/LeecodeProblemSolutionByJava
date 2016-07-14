package note.dp.ScrambleString87;

/**
 * Created by yuxiao on 7/14/16.
 */
public class Solution {

    //  O（n^3)
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        if (s1.equals(s2)) {
            return true;
        }

        int[] sameAlphs = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            sameAlphs[s1.charAt(i) - 'a']++;
            sameAlphs[s2.charAt(i) - 'a']--;
        }
        for (int item : sameAlphs) {
            if (item != 0) return false;
        }
        int len = s1.length();

        for (int i = 1; i < len; i++) {
            if (isScramble(s1.substring(0, i), s2.substring(len - i))
                    && isScramble(s1.substring(i), s2.substring(0, len - i))) {
                return true;
            }
            if (isScramble(s1.substring(0, i), s2.substring(0, i))
                    && isScramble(s1.substring(i), s2.substring(i))) {
                return true;
            }
        }
        return false;
    }
}
