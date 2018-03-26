package note.dp.WildcardMatching44;

/**
 * Created by yuxiao on 16/5/13.
 * https://leetcode.com/problems/wildcard-matching/
 */
public class Solution {

    // https://leetcode.com/problems/wildcard-matching/discuss/17810/Linear-runtime-and-constant-space-solution
    //https://discuss.leetcode.com/topic/27991/java-solution-o-n-2-dp-solution-with-some-explanations/2
    // O(n^2) DP solution with dp[][] matric transposed:
    //https://discuss.leetcode.com/topic/3040/linear-runtime-and-constant-space-solution/2
    public boolean isMatch(String s, String p) {
        int sL = s.length(), pL = p.length();

        boolean[][] dp = new boolean[pL+1][sL+1];
        dp[0][0] = true;

        for(int i=1; i<=pL; i++) {
            boolean flag = false; // The flag is moved here;

            for(int j=0; j<=sL; j++) {
                flag = flag || dp[i-1][j];
                char c = p.charAt(i-1);

                if(c != '*') {
                    dp[i][j] = j>0 && dp[i-1][j-1] && (c=='?' || c==s.charAt(j-1));
                }
                else {
                    // For k>=0 and k<=j, if any dp[i-1][k] is true,
                    // then '*' will match the rest sequence in s after index k;
                    dp[i][j] = i==1 || flag;
                }
            }
        }

        return dp[pL][sL];
    }
}