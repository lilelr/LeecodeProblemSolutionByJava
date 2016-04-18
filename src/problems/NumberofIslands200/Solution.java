package problems.NumberofIslands200;

import org.junit.Test;

/**
 * Created by yuxiao on 16/4/18.
 */
public class Solution {

    public int numIslands(char[][] grid) {
        if(grid.length==0) return 0;
        int lenCol = grid[0].length;
        int lenRow = grid.length;
        int sum=0;
        for(int i=0;i<lenRow;i++){
            for(int j=0;j<lenCol;j++){
                if(grid[i][j] == '1'){
                    sum++;
                    dps(grid,i,j,lenRow,lenCol);
                }
            }
        }
        return sum;
    }


    void dps(char[][] grid, int i, int j, int lenRow, int lenCol) {
        grid[i][j] = '0';
        if (i >= 1 && i < lenRow && grid[i - 1][j] == '1') {
            dps(grid, i - 1, j, lenRow, lenCol);
        }
        if (j >= 1 && j < lenCol && grid[i][j - 1] == '1') {
            dps(grid, i, j - 1, lenRow, lenCol);
        }
        if (i >= 0 && i <= lenRow - 2 && grid[i + 1][j] == '1') {
            dps(grid, i + 1, j, lenRow, lenCol);
        }
        if (j >= 0 && j <= lenCol - 2 && grid[i][j + 1] == '1') {
            dps(grid, i, j+1, lenRow, lenCol);
        }

    }

    @Test
    public void test(){

        char[][] grid = new char[2][2];
        grid[0][0] = '1';
        grid[0][1] = '0';
        grid[1][0] = '0';
        grid[1][1] = '1';
        System.out.println(numIslands(grid));
    }
}
