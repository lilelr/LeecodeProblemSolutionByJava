package note.twopoint.ImplementStrStr28;

/**
 * Created by yuxiao on 16/4/22.
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null){
            return 0;
        }

        if(haystack.isEmpty() && needle.isEmpty()){
            return 0;
        }

        for(int i=0;i<haystack.length();i++){
            if(haystack.substring(i,haystack.length()).startsWith(needle)){
                return i;
            }
        }
        return -1;

    }


    // KMP  O(m+n)
    public static int strStrKMP(String haystack, String needle) {
        int[] prefix = KMP(needle);
        int i = 0, j = 0;
        char[] charArr1 = haystack.toCharArray(), charArr2 = needle.toCharArray();
        while(i < haystack.length() && j < needle.length()) {
            if(charArr1[i] == charArr2[j]) {
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = prefix[j-1];
                } else {
                    i ++;
                }
            }
        }
        if (j == needle.length()) {
            return i - j;
        } else {
            return -1;
        }
    }

    private static int[] KMP(String needle) {
        int[] res = new int[needle.length()];
        char[] charArr = needle.toCharArray();
        int i = 0, j = 1;
        while(j < needle.length()) {
            if (charArr[i] == charArr[j]) {
                res[j] = i + 1;
                i ++;
                j ++;
            } else {
                if(i != 0) {
                    i = res[i-1];
                } else {
                    res[j] = 0;
                    j ++;
                }
            }
        }
        return res;
    }
}
