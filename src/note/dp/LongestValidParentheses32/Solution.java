package note.dp.LongestValidParentheses32;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by yuxiao on 8/16/16.
 * https://leetcode.com/problems/longest-valid-parentheses/
 */
public class Solution {
    //https://discuss.leetcode.com/topic/7234/simple-java-solution-o-n-time-one-stack
    // stack + dp , dp exists in stack.peek()
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        int left = -1;
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == '(') stack.push(j);
            else {
                if (stack.isEmpty()) left = j;
                else {
                    stack.pop();
                    if (stack.isEmpty()) max = Math.max(max, j - left);
                    else max = Math.max(max, j - stack.peek());
                }
            }
        }
        return max;
    }


    @Test
    public void test() {
//        String s = ")()())()()()";
//        String s = "()))()(())";
        String s = "()(()";
        int res = longestValidParentheses(s);
        System.out.println(res);
    }
}
