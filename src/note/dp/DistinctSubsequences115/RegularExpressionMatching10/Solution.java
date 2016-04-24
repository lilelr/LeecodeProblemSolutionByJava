package note.dp.DistinctSubsequences115.RegularExpressionMatching10;

import org.junit.Test;

/**
 * Created by yuxiao on 4/24/16.
 */
public class Solution {


    // dp 6ms
    //https://leetcode.com/discuss/93024/easy-dp-java-solution-with-detailed-explanation
//    1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
//    2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
//    3, If p.charAt(j) == '*':
//    here are two sub conditions:
//            1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
//            2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
//    dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a
//    or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
//    or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
    public boolean isMatch(String s, String p) {
        if(s == null || p == null){
            return false;
        }

        boolean[][] dp  = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for(int i=0;i<p.length();i++){
            if(p.charAt(i)== '*' && dp[0][i-1]){
                dp[0][i+1] = true; // s ="a"  p="a*" i=1
            }
        }

        for(int i=0;i<s.length();i++){
            for(int j=0;j<p.length();j++){
                if(p.charAt(j) == '.'){
                    dp[i+1][j+1] = dp[i][j];
                }

                if(p.charAt(j) == s.charAt(i)){
                    dp[i+1][j+1] = dp[i][j];
                }

                if(p.charAt(j) == '*'){
                    // s= "abjc" p = "ab*" i=2 ,j=2 dp[3][3]=dp[3][1]
                    if(p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.'){
                        dp[i+1][j+1] = dp[i+1][j-1];
                    } else{
                        // s= "abbc" p = "ab*" i=2 ,j=2 dp[3][3]=(dp[3][2]||dp[2][3]||dp[3][1]
                        dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    @Test
    public void test(){
        String s= "abfc";
        String p="ab*";
        boolean res = isMatch(s,p);
        System.out.println(res);
    }
}
