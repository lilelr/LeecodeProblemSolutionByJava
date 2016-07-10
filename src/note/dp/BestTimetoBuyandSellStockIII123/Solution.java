package note.dp.BestTimetoBuyandSellStockIII123;

import org.hamcrest.Matcher;
import org.junit.Test;

/**
 * Created by yuxiao on 16/7/10.
 */
public class Solution {
//    Idea is simple : Keep track of the minimum value till previous day and
//    check how much maximum profit can be obtained for current day.

    // for example find the max profit of [1,5,3,6,4] at most at two trancactions.
    // i=1 min = Math.min(min,price[j-1])
     // dp[1][j] = Math.max(dp[1][j-1],price[j]-min);
    //
    // in trans 2, dp[1][1] = 4
    // in order to add the max profit of the first trans, we let 4 reduced by 3 (3-4=-1)
    // so min = (min,-1) =-1
    // so after two trans ,the max profit is 6-(-1)=7
    // i=2 min = Math.min(min,price[j-1] - dp[1][j-1]);
    // dp [2][j] = Math.max(dp[2][j-1],prices[j]-min);
    public int maxProfit(int[] prices) {
        if(prices.length<2) return 0;
        int trans=2;
        int len = prices.length;
        int[][] dp = new int[trans+1][len];
        for(int i=1;i<=trans;i++){
            int min = Integer.MAX_VALUE;
            for(int j=1;j<len;j++){
                min = Integer.min(min,prices[j-1]-dp[i-1][j-1]);
                dp[i][j] = Integer.max(dp[i][j-1],prices[j] - min);
            }
        }
        return dp[trans][len-1];
    }


    // The second method. forward and backward iterative
    public int maxProfit2(int[] prices) {
        int len = prices.length;
        if(len<2) return 0;

        int[] forward = new int[len];
        forward[0]=0;
        int min = prices[0];
        for(int j=1;j<len;j++){
            min = Integer.min(min,prices[j-1]);
            forward[j] = Integer.max(forward[j-1],prices[j]-min);
        }

        int[] backward = new int[len];
        backward[len-1]=0;
        int max=prices[len-1];
        for(int i=len-2;i>=0;i--){
            max = Integer.max(max,prices[i]);
            backward[i] = Integer.max(backward[i+1],max-prices[i]);
        }

        int res = 0;
        for(int k=0;k<len;k++){
            res  =Math.max(res,forward[k]+backward[k]);
        }
        return res;
    }



    @Test
    public void test(){
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit2(prices));
    }

}
