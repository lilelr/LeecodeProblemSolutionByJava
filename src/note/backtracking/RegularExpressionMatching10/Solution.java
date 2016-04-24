package note.backtracking.RegularExpressionMatching10;

import org.junit.Test;

/**
 * Created by yuxiao on 4/24/16.
 */
public class Solution {


    //1 dp 6ms
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

    //2 backtracking 9ms  iterate from back
    boolean isMatchRecursive(String s,String p){
        int lenS = s.length(),lenP = p.length();
        return backtrackingBack(s, lenS, p, lenP);

    }

    boolean backtrackingBack(String s, int i,String p ,int j){
        if(i==0 && j==0) return true;
        if(i!=0 && j==0) return false;
        if(i ==0 && j!=0){
            // in this case only p = "c*c*c*" this pattern can match null string
            if(p.charAt(j-1) == '*'){
                return  backtrackingBack(s, i, p, j - 2);
            }
            return false;
        }

        // now both i and jj are not null
        if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.' ){
            return backtrackingBack(s, i - 1, p, j - 1);
        } else if(p.charAt(j-1) == '*'){
            // two cases: determines on whether p[j-2] == s[i-1]
            // first p[j-2]* matches zero characters of p
            //            // s = ab   p = ab* i=2,j=3

            if(backtrackingBack(s, i, p, j - 2)) return true;

            // second consider whether p[j-2] == s[i-1] , if true, then s[i-1] is matched, move to backtracking(i-1,j)
            // s = abb   p = ab* i=3,j=3
            if(p.charAt(j-2) == s.charAt(i-1) || p.charAt(j-2) == '.'){
                return backtrackingBack(s, i - 1,p,j);
            }
            return  false;
        }

        return false;

    }


    //3 Recursive iterate from front
    public boolean isMatchFrontIterate(String s, String p) {
        if (s == null || p == null) return false;
        return isMatch(s.toCharArray(), 0, p.toCharArray(), 0);
    }

    private boolean isMatch(char[] s, int i, char[] p, int j) {
        if (j == p.length) return i == s.length;
        if (j == p.length - 1 || p[j + 1] != '*') {
            if (i < s.length && (p[j] == '.' || s[i] == p[j])) {
                return isMatch(s, i + 1, p, j + 1);
            } else {
                return false;
            }
        }
        while (i < s.length && (p[j] == '.' || s[i] == p[j])) {
            if (isMatch(s, i, p, j + 2)) return true;
            i++;
        }
        return isMatch(s, i, p, j + 2);
    }

    @Test
    public void test(){
        String s= "abfc";
        String p="ab*";
        boolean res = isMatch(s,p);
        System.out.println(res);
    }
}
