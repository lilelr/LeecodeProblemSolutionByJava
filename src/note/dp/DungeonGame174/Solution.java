package note.dp.DungeonGame174;

import java.util.Arrays;

/**
 * Created by yuxiao on 8/12/16.
 * https://leetcode.com/problems/dungeon-game/
 */
public class Solution {
    //    https://discuss.leetcode.com/topic/41045/java-dp-solution-with-explain
    // O(m*n) space
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        if (m == 0 || n == 0) {
            return 0;
        }
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = dungeon[m - 1][n - 1] > 0 ? 0 : dungeon[m - 1][n - 1];
        for (int i = n - 2; i >= 0; i--) {
            int val = dp[m - 1][i + 1] + dungeon[m - 1][i];
            if (val >= 0) {
                dp[m - 1][i] = 0;
            } else {
                dp[m - 1][i] = val;
            }
        }
        for (int i = m - 2; i >= 0; i--) {
            int val = dp[i + 1][n - 1] + dungeon[i][n - 1];
            if (val >= 0) {
                dp[i][n - 1] = 0;
            } else {
                dp[i][n - 1] = val;
            }
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int val = Math.max(dp[i + 1][j], dp[i][j + 1]) + dungeon[i][j];
                if (val >= 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = val;
                }
            }
        }
        return -dp[0][0] + 1;

    }

    // Java O(Math.min(m,n)) space DP solution (3ms)
    public int calculateMinimumHP2(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }
        int m = dungeon.length;
        int n = dungeon[0].length;
        int small;
        int large;
        if (m < n) {
            small = m;
            large = n;
        } else {
            small = n;
            large = m;
        }
        int[] health = new int[small + 1];
        Arrays.fill(health, Integer.MAX_VALUE);
        health[small] = 1;
        for (int i = large - 1; i >= 0; i--) {
            for (int j = small - 1; j >= 0; j--) {
                int temp = m < n ? dungeon[j][i] : dungeon[i][j];
                health[j] = Math.max(Math.min(health[j], health[j + 1]) - temp, 1);
            }
            health[small] = Integer.MAX_VALUE;
        }
        return health[0];
    }
}
