package note.dp.MaximalSquare221;

import org.junit.Test;

/**
 * Created by yuxiao on 7/3/16.
 * https://leetcode.com/problems/maximal-square/description/
 */
public class Solution {
    //[思路] http://blog.csdn.net/xudli/article/details/46371673
//    dynamic programing.  以当前点(x,y) = '1' 为右下角的最大正方形(squre)的边长f(x,y) = min( f(x-1,y), f(x,y-1), f(x-1,y-1)) + 1.
//    递推公式已建立, dp就自然而然了.
    public int maximalSquare(char[][] matrix) {
        int area = 0;

        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;

        int[][] res = new int[m][n];
        for (int i = 0; i < n; i++) {
            res[0][i] = Integer.valueOf(matrix[0][i]-'0');
            area = Math.max(res[0][i], area);
        }
        for (int j = 0; j < m; j++) {
            res[j][0] = Integer.valueOf(matrix[j][0]-'0');
            area = Math.max(res[j][0], area);

        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '0') {
                    res[i][j] = 0;
                } else {
                    res[i][j] = Math.min(Math.min(res[i - 1][j - 1], res[i - 1][j]), res[i][j - 1]) + 1;
                    area = Math.max(res[i][j], area);

                }
            }
        }
        return area * area;
    }



    @Test
    public void test() {
        char[][] matrix = new char[4][5];
        matrix[0] = new char[]{'1', '0', '1', '0', '0'};
        matrix[1] = new char[]{'1', '0', '1', '1', '1'};
        matrix[2] = new char[]{'1', '1', '1', '1', '1'};
        matrix[3] = new char[]{'1', '0', '0', '1', '0'};
        System.out.println(maximalSquare(matrix));
    }
}
