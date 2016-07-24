package note.dp.BurstBalloons312;

import org.junit.Test;

/**
 * Created by yuxiao on 7/13/16.
 * https://leetcode.com/problems/burst-balloons/
 */
public class Solution {
    //https://discuss.leetcode.com/topic/30746/share-some-analysis-and-explanations
    public int maxCoins(int[] iNums) {
        int[] nums = new int[iNums.length + 2];
        for (int i = 0; i < iNums.length; i++) {
            nums[i + 1] = iNums[i];
        }
        int len = iNums.length + 2;
        nums[0] = nums[len - 1] = 1;
        int[][] memo = new int[len][len];
        int ans = 0;

        int[][] dp = new int[len][len];

//        ans = burst(memo,nums,0,len-1);
        ans = DP(dp, len, nums);
        return ans;
    }

//    D&V 12ms
    public int burst(int[][] memo, int[] nums, int left, int right) {
        if (left + 1 == right) return 0;
        if (memo[left][right] > 0) return memo[left][right];
        int ans = 0;
        for (int i = left + 1; i < right; i++) {
            ans = Integer.max(ans, nums[left] * nums[i] * nums[right] + burst(memo, nums, left, i)
                    + burst(memo, nums, i, right));
        }
        memo[left][right] = ans;
        return ans;
    }

    // 19ms
    public int DP(int[][] dp, int n, int[] nums) {
        for (int k = 2; k < n; k++) {
            for (int left = 0; left < n - k; ++left) {
                int right = left + k;
                for (int i = left + 1; i < right; i++) {
                    dp[left][right] = Math.max(dp[left][right], nums[left] * nums[i] * nums[right]
                            +dp[left][i]+ dp[i][right]);

                }
            }
        }
        return dp[0][n - 1];
    }

    @Test
    public void test() {
//        int[] iNums = {3, 1, 5, 1, 8};
        int[] iNums = {3, 4, 5};
        System.out.println(maxCoins(iNums));
    }
}
