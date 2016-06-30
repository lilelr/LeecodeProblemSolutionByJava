package note.dp.ClimbingStairs70;

/**
 * Created by yuxiao on 6/30/16.
 */
public class Solution {
    public int climbStairs(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        if(n==2) return 2;
        int[] res = new int[n+1];
        res [1] = 1;
        res[2] = 2;
        for(int i=3;i<=n;i++){
            res[i] = res[i-2] + res[i-1];
        }
        return res[n];
    }
}
