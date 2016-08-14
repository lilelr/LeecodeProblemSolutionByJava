package note.greedy.Candy135;

import org.junit.Test;

/**
 * Created by yuxiao on 8/14/16.
 * https://leetcode.com/problems/candy/
 */
public class Solution {
//    O(N) Greedy     back and forth
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 0) return 0;
        if (n == 1) return 1;

        int left, right;
        int[] candy = new int[n];
        for (left = 1; left < n; left++) {
            if (ratings[left] > ratings[left - 1]) {
                candy[left] = candy[left - 1] + 1;
            }
        }

        for (right = n - 2; right >= 0; right--) {
            if (ratings[right] > ratings[right + 1]  && candy[right]<= candy[right+1]) {
                candy[right] = candy[right + 1] + 1;
            }
        }

        int sum = 0;
        for (int item : candy) {
            sum += item;
        }
        return sum + n;
    }

    @Test
    public void test() {
//        int[] ratings = {4, 3, 0, 2};
        int[] ratings = {4,2, 3,4, 1};
        int res = candy(ratings);
        System.out.println(res);
    }
}
