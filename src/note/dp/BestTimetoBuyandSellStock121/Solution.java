package note.dp.BestTimetoBuyandSellStock121;

/**
 * Created by yuxiao on 16/7/6.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <=1) return 0;
        int min = prices[0];
        int maxProfix = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i] > min){
                maxProfix = Math.max(maxProfix,prices[i] - min);
            }else{
                min = Math.min(min,prices[i]);
            }
        }
        return maxProfix;
    }


}
