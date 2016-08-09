package note.stack.BasicCalculatorII227;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by yuxiao on 8/9/16.
 * https://leetcode.com/problems/basic-calculator-ii/
 */
public class Solution {
    //https://discuss.leetcode.com/topic/16935/share-my-java-solution
    public int calculate(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if ((!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i)) || i == len - 1) {
                // when coming across operator ,firstly calcualtes the last val, then determine
                // the sign of next number according the current letter and update the value of sign
                // in order to handle the last item , terminates when i == len-1
                if (sign == '-') {
                    stack.push(-num);
                }
                if (sign == '+') {
                    stack.push(num);
                }
                if (sign == '*') {
                    stack.push(stack.pop() * num);
                }
                if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }

        int re = 0;
        for (int i : stack) {
            re += i;
        }
        return re;
    }

    @Test
    public void test(){
       String calStr = "5*4-3";
        int res = calculate(calStr);

    }
}
