package note.dp.RangeSumQuery2D304;

import org.junit.Test;

/**
 * Created by yuxiao on 7/19/16.
 * https://leetcode.com/problems/range-sum-query-2d-immutable/
 */
public class NumMatrix {

    private int[][] sum;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return;
        int n = matrix[0].length;
        sum = new int[m][n];
        sum[0][0] = matrix[0][0];
        for (int j = 1; j < n; j++) {
            sum[0][j] = sum[0][j - 1] + matrix[0][j];
        }
        for (int i = 1; i < m; i++) {
            sum[i][0] = sum[i - 1][0] + matrix[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] + matrix[i][j] - sum[i - 1][j - 1];
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 == 0 && col1 == 0) {
            return sum[row2][col2];
        } else if (row1 == 0) {
            return sum[row2][col2] - sum[row2][col1 - 1];
        } else if (col1 == 0) {
            return sum[row2][col2] - sum[row1 - 1][col2];
        } else {
            return sum[row2][col2] - sum[row2][col1 - 1] - sum[row1 - 1][col2] + sum[row1 - 1][col1 - 1];
        }
    }


}
