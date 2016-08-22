package note.twopoint.RemoveElement27;

/**
 * Created by yuxiao on 4/7/16.
 * https://leetcode.com/problems/remove-element/
 */
public class Solution {

    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        if (len == 0) return 0;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != val) count++;
        }

        int pos = 0;
        for (int i = 0; i < count; i++) {
            if (nums[i] == val) {
                int j = i + 1;
                while (nums[j] == val) j++;
                nums[i] = nums[j];
                nums[j] = val;
            }
        }

        return count;
    }
}
