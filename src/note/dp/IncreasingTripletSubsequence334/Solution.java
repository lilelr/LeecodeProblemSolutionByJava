package note.dp.IncreasingTripletSubsequence334;

/**
 * Created by yuxiao on 4/3/16.
 * https://leetcode.com/problems/increasing-triplet-subsequence/
 * <p>
 * Increasing Triplet Subsequence
 * Dynamic Programming
 * Testcase [1,2,3,4,5]
 * [1,1,-2,6]
 */
public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] < min) {
                min = nums[i];
            } else {
                if (mid < nums[i]) {
                    return true;
                } else {
                    if (nums[i] != min) {
                        mid = nums[i];
                    }
                }
            }

        }
        return false;
    }
}
