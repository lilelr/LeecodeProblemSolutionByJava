package note.stack.EvaluateReversePolishNotation150;

import java.util.Stack;

/**
 * Created by yuxiao on 8/10/16.
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 */
public class Solution {
    public int evalRPN(String[] tokens) {
        int a, b;
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (s.equals("+")) {
                stack.add(stack.pop() + stack.pop());
            } else if (s.equals("-")) {
                b = stack.pop();
                a = stack.pop();
                stack.add(a - b);
            } else if (s.equals("*")) {
                stack.add(stack.pop() * stack.pop());
            } else if (s.equals("/")) {
                b = stack.pop();
                a = stack.pop();
                stack.add(a / b);
            } else {
                stack.add(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}
