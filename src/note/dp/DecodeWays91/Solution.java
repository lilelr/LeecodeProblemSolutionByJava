package note.dp.DecodeWays91;

import org.junit.Test;

/**
 * Created by yuxiao on 7/14/16.
 */
public class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if(n==0) return 0;
        int[] memo = new int[n+1];
        memo[n] = 1;
        memo[n-1] = s.charAt(n-1) !='0' ? 1:0;

        for(int i=n-2;i>=0;i--){
            if(s.charAt(i) == '0') continue;
            else{
                memo[i] = (Integer.parseInt(s.substring(i,i+2))<=26) ? memo[i+1]+memo[i+2] : memo[i+1];
            }
        }
        return memo[0];
    }

    @Test
    public void test(){
        String s = "1214";
        System.out.println(numDecodings(s));
    }
}
