package note.dp.UniquePathsII63;

/**
 * Created by yuxiao on 6/29/16.
 * https://leetcode.com/problems/unique-paths-ii/
 */
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[m - 1][n - 1] == 1) return 0;
        if (obstacleGrid[0][0] == 1) return 0;
        int[][] resGrid = new int[m][n];
        resGrid[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    resGrid[0][0] = 1;
                } else {
                    if (obstacleGrid[i][j] == 1) {
                        resGrid[i][j] = 0;
                    } else if (i == 0) {
                        resGrid[0][j] = resGrid[0][j - 1];
                    } else if (j == 0) {
                        resGrid[i][0] = resGrid[i - 1][0];
                    } else {
                        resGrid[i][j] = resGrid[i][j - 1] + resGrid[i - 1][j];
                    }
                }
            }
        }

        return resGrid[m - 1][n - 1];

    }
}
