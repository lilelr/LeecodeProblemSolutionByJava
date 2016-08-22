package note.math.UglyNumber263;

import org.junit.Test;

/**
 * Created by yuxiao on 4/5/16.
 * https://leetcode.com/problems/ugly-number/
 */
public class Solution {
    public boolean isUgly(int num) {
        if (num == 1) return true;
        if (num == 0) return false;

        int[] factors = {2, 3, 5};
        while (true) {

            if (num % 2 != 0 && num % 3 != 0 && num % 5 != 0) {
                return false;
            }
            for (int item : factors) {
                if (num % item == 0) {
                    num = num / item;
                }
            }
            if (num == 1) return true;

        }
    }


    @Test
    public void testIsUgly() {
        System.out.println(isUgly(8));
    }
}
