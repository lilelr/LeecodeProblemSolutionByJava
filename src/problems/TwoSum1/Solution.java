package problems.TwoSum1;

/**
 * Created by yuxiao on 4/9/16.
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int[] res = new int[2];
        int sum = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((nums[i] + nums[j]) == target) {
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }

}
