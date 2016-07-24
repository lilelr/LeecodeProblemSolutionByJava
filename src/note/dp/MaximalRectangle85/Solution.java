package note.dp.MaximalRectangle85;

import org.junit.Test;

import java.sql.Struct;
import java.util.Stack;

/**
 * Created by yuxiao on 7/3/16.
 * https://leetcode.com/problems/maximal-rectangle/
 */
public class Solution {
    // 思路:http://blog.csdn.net/doc_sgl/article/details/11832965
    public int largestRectangleArea(int[] heights) {
        // 84. Largest Rectangle in Histogram
        // https://leetcode.com/problems/largest-rectangle-in-histogram/
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int maxArea = 0;
        int len = heights.length;
        while (i <= len) {
            int nextHeight = (i == len ? 0 : heights[i]);
            if (stack.empty() || heights[stack.peek()] <= nextHeight) {
                stack.push(i);
                i++;
            } else {
                int t = stack.pop();
                maxArea = Math.max(maxArea, heights[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }
        return maxArea;
    }

    public boolean isOne(char a) {
        return a == '1';
    }


    public int maximalRectangle(char[][] matrix) {
        int res = 0;
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        // array dp describes the bar graph. dp[i] describes 1's heights of the ith level.
        int[][] dp = new int[m][n];
        for (int j = 0; j < n; j++) {
            if (isOne(matrix[0][j])) dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isOne(matrix[i][j])) {
                    dp[i][j] = dp[i - 1][j] + 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            //  Considering the solution of finding the largest retangle in Histogram in problem 85.
            int tempRes = largestRectangleArea(dp[i]);
            res = Math.max(tempRes, res);
        }
        return res;
    }

    @Test
    public void test() {
        char[][] matrix = new char[4][5];
        matrix[0] = new char[]{'1', '0', '1', '0', '0'};
        matrix[1] = new char[]{'1', '0', '1', '1', '1'};
        matrix[2] = new char[]{'1', '1', '1', '1', '1'};
        matrix[3] = new char[]{'1', '0', '0', '1', '0'};
        System.out.println(maximalRectangle(matrix));
    }
}
