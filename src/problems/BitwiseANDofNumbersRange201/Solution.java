package problems.BitwiseANDofNumbersRange201;

import org.junit.Test;

/**
 * Created by yuxiao on 16/4/18.
 * https://leetcode.com/discuss/94705/two-lines-solution-just-a-math-problem-python-c-java
 */
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
       int t = (int) Math.ceil(Math.log(n-m+1)/Math.log(2));
        return m&n >> t << t;

    }

    @Test
    public void test() {


        System.out.println(rangeBitwiseAnd(1, 4));
        System.out.println(rangeBitwiseAnd(5, 7));
        System.out.println(rangeBitwiseAnd(5, 8));
        System.out.println(rangeBitwiseAnd(8, 14));
        System.out.println(rangeBitwiseAnd(8, 16));
    }
}
