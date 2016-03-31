package problems.CoinChange322;

/**
 * Created by yuxiao on 3/31/16. Dynamic Programming
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount ==0){
            return 0;
        }
        if(coins==null || amount<0 || coins.length==0){
            return -1;
        }

        int len = coins.length;
        int[] ans = new int[amount+1];
        ans[0] =0;
        for (int i=0;i<coins.length;i++){
            if(coins[i] > amount){
                continue;
            }
            ans[coins[i]] = 1;
        }

        for (int i=0;i<=amount;i++){
            if (ans[i] ==0){
                ans[i] = Integer.MAX_VALUE;
            }
        }

        for (int i=1;i<=amount;i++){
            for (int j=0;j<len;j++){
                if (coins[j]<=i && ans[i-coins[j]] != Integer.MAX_VALUE){
                    ans[i] = Math.min(ans[i], 1+ans[i-coins[j]]);
                }
            }
        }

        if(ans[amount] == Integer.MAX_VALUE) return -1;
        return ans[amount];
    }
}
