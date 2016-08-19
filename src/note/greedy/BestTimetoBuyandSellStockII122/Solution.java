package note.greedy.BestTimetoBuyandSellStockII122;

/**
 * Created by yuxiao on 16/7/10.
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class Solution {
    //    //
//    You make profit by buying low and selling high, so a person would buy at trough and sell at crest, here the subtle thing is it is equivalent to buying at i and selling at i + 1 as long as price is increasing, this is fine because you can do as many transactions as you want.
//
//    Suppose the prices are
//
//    1  2  3  4  5
//    then 5 - 1 == 2 - 1 + 3 - 2 + 4 - 3 + 5 - 4
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int min = prices[0];
        int maxProfix = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > min) {
                maxProfix = Math.max(maxProfix, prices[i] - min);
            } else {
                min = Math.min(min, prices[i]);
            }
        }
        return maxProfix;
    }
}
