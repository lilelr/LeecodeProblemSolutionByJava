package note.stack.LargestRectangleinHistogram84;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by yuxiao on 7/3/16.
 */
public class Solution {
    public int largestRectangleArea(int[] heights) {
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

    @Test
    public void test() {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(heights));
    }
}
