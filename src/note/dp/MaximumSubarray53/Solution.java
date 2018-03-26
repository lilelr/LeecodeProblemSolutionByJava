package note.dp.MaximumSubarray53;

import org.junit.Test;

/**
 * Created by yuxiao on 6/23/16.
 * https://leetcode.com/problems/maximum-subarray/description/
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int tempSub = 0;
        for (int i = 0; i < nums.length; i++) {
            tempSub += nums[i];
            res = Math.max(tempSub, res);
//            res = Math.max(nums[i], res);
            if (tempSub < 0) {
                tempSub = 0;
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1};
        System.out.println(maxSubArray(nums));
    }
}
