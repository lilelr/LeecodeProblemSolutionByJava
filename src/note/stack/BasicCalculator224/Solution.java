package note.stack.BasicCalculator224;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by yuxiao on 8/9/16.
 * https://leetcode.com/problems/basic-calculator/
 */
public class Solution {
    //https://discuss.leetcode.com/topic/15816/iterative-java-solution-with-stack
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        int number = 0;
        int sign = 1;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            // utilize the function of Character
            if(Character.isDigit(c)){
                number = 10 * number + (int)(c - '0');
            }else if(c == '+'){
                // when meeting operator,
                // first adds the current number, secondly determines the sign of next number
                result += sign * number;
                number = 0;
                sign = 1;
            }else if(c == '-'){
                result += sign * number;
                number = 0;
                sign = -1;
            }else if(c == '('){
                //we push the result first, then sign;
                stack.push(result);
                stack.push(sign);
                //reset the sign and result for the value in the parenthesis
                sign = 1;
                result = 0;
            }else if(c == ')'){
                result += sign * number;  // Attention, ')' is regarded as the last operator
                number = 0;
                result *= stack.pop();    //stack.pop() is the sign before the parenthesis
                result += stack.pop();   //stack.pop() now is the result calculated before the parenthesis

            }
        }
        if(number != 0) result += sign * number;
        return result;
    }

    @Test
    public void test() {
//        String calcuStr = "2-3+1";
        String calcuStr = "2-3+(5-4)+1";
        int res = calculate(calcuStr);
        System.out.println(res);
    }
}
