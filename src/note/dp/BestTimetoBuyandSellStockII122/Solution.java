package note.dp.BestTimetoBuyandSellStockII122;

/**
 * Created by yuxiao on 16/7/6.
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/discuss/39441/A-simple-solution-with-O(n)-time-and-O(1)-space
 */
public class Solution {
    //greedy
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1) return 0;
        if (len == 2) {
            return prices[0] < prices[1] ? (prices[1] - prices[0]) : 0;
        }

        int lastbuy = prices[0];
        int profit = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i] > lastbuy) {
                profit = profit + prices[i] - lastbuy;
            }
            lastbuy = prices[i];
        }
        return profit;
    }

}
