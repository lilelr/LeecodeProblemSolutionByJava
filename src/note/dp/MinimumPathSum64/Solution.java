package note.dp.MinimumPathSum64;

import org.junit.Test;

/**
 * Created by yuxiao on 6/29/16.
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] resGrid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    resGrid[0][0] = grid[0][0];
                } else {
                    if (i == 0) {
                        resGrid[0][j] = resGrid[0][j - 1] + grid[i][j];
                    } else if (j == 0) {
                        resGrid[i][0] = resGrid[i - 1][0] + grid[i][j];
                    } else {
                        resGrid[i][j] = Math.min(resGrid[i - 1][j], resGrid[i][j - 1]) + grid[i][j];
                    }
                }
            }
        }

        return resGrid[m - 1][n - 1];

    }

    @Test
    public void test(){
        int[][] grid = new int[2][2];
        grid[0] = new int[]{1,2};
        grid[1] = new int[]{1,1};
        System.out.println(minPathSum(grid));
    }
}
