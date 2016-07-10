package note.dp.BestTimetoBuyandSellStockIV188;

import org.junit.Test;

/**
 * Created by yuxiao on 16/7/10.
 */
public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices.length < 2) return 0;
        int trans = k;
        int len = prices.length;
//        int[][] dp = new int[trans + 1][len];
//        for (int i = 1; i <= trans; i++) {
//            int min = Integer.MAX_VALUE;
//            for (int j = 1; j < len; j++) {
//                min = Integer.min(min, prices[j - 1] - dp[i - 1][j - 1]);
//                dp[i][j] = Integer.max(dp[i][j - 1], prices[j] - min);
//            }
//        }
//        int[] dp = new int[len];
//        int[] prevDp = new int[len];
//        for (int i = 1; i <= trans; i++) {
//            int min = Integer.MAX_VALUE;
//            int prevProfit = 0;
//            for (int j = 1; j < len; j++) {
//                min = Integer.min(min, prices[j - 1] - prevDp[j - 1]);
//                dp[j] = Integer.max(prevProfit, prices[j] - min);
//                prevProfit = dp[j];
//                prevDp[j-1] = dp[j-1];
//            }
//            prevDp[len-1] = dp[len-1];
//        }
        if(k>= len/2){
            int maxProfit = 0;
            for(int i=1;i<len;i++){
                if(prices[i]>prices[i-1]){
                    maxProfit += prices[i]-prices[i-1];
                }
            }
            return maxProfit;
        }

        int[] dp = new int[len];
        for (int i = 1; i <= trans; i++) {
            int min = Integer.MAX_VALUE;
            int preProfit = 0;
            int curProfit = 0;
            for (int j = 1; j < len; j++) {
                min = Integer.min(min, prices[j - 1] - dp[j - 1]);
                curProfit = Integer.max(preProfit, prices[j] - min);
                dp[j - 1] = preProfit;
                preProfit = curProfit;
            }
            dp[len-1] = preProfit;
        }
        return dp[len - 1];
    }

    @Test
    public void test() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(10, prices));
    }
}
