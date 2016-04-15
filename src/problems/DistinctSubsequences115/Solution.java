package problems.DistinctSubsequences115;

import org.junit.Test;

/**
 * Created by yuxiao on 16/4/15.
 */
public class Solution {

    //define dp[i][j] as total distinct strings [0,j] of t in [0,i] of s, then we have two cases:
    //1. dp[i][j] = dp[i-1][j], which means we can find [0,j] in [0,i-1]
    //2. dp[i][j] = dp[i-1][j] + dp[i-1][j-1] if t[j] = s[i], either we can find [0,j] in
    //   [0,i-1], or [0,j-1] in [0,i-1] with t[j] = s[i]

    public int numDistinctTwoDismension(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        if (lenT > lenS) return 0;

        int[][] dp = new int[lenS + 1][lenT + 1];
        for (int j = 1; j < lenT; j++) {
            dp[0][j] = 0;
        }
        for (int i = 0; i < lenS; i++) {
            // if t is empty ,then only one sequence by deleting all elements of s matching t.
            dp[i][0] = 1;
        }


        for (int i = 1; i <= lenS; i++) {
            for (int j = 1; j <= lenT; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[lenS][lenT];

    }

    //O(n) space
    //with optimization, use one dimension and iterate back forward then
    // If not iterate back forward, there will make mistakes.
    // For example ,s is "r", t is "rr" , iterate directly, we will get dp[0] =1, then
    // s.charAt(0) == t.chart(1) so dp[1] = dp[0] + dp[1](equal 0) , so dp[1] = 1 which is incorrect.
    // If iterate back forward, when i=0 and j=1, dp[1] = 0. When i = 0 and j=0,dp[0] =1.

    //    dp[i] = dp[i]
    //    dp[i] = dp[i] + dp[i-1]
    public int numDistinctOneDimension(String s, String t) {
        int[] dp = new int[t.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = t.length() - 1; j >= 0; j--) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[j] = (j == 0 ? 1 : dp[j - 1]) + dp[j];
                }
            }

        }
        return dp[t.length() - 1];
    }

    @Test
    public void test() {
        String s = "rrr";
        String t = "rr";
//        int ans = numDistinct(s,t);
        int ans = numDistinctOneDimension(s, t);

    }

}
