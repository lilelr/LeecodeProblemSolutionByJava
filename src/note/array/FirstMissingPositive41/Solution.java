package note.array.FirstMissingPositive41;

import org.junit.Test;

/**
 * Created by yuxiao on 8/14/16.
 * https://leetcode.com/problems/first-missing-positive/
 */
public class Solution {
    //https://discuss.leetcode.com/topic/25441/beat-100-fast-elegant-java-index-based-solution-with-explanation
    public int firstMissingPositive(int[] nums) {

        int i = 0;
        int n = nums.length;
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            if (nums[0] == 1) {
                return 2;
            } else {
                return 1;
            }
        }

        while (i < n) {
            //// If the current value is in the range of (0,length) and it's not at its correct position,
            // swap it to its correct position.
            // Else just continue;
            if (nums[i] >= 0 && nums[i] < n && nums[nums[i]] != nums[i] && nums[i] != i) {
                swap(nums, i, nums[i]);
            } else {
                i++;
            }
        }

        int k = 1;
        // // Check from k=1 to see whether each index and value can be corresponding.
        while (k < n) {
            if (nums[k] != k) {
                return k;
            } else {
                k++;
            }
        }

        // If it breaks because of empty array or reaching the end. K must be the first missing number.

        if (nums[0] == k) {
            return k + 1;
        } else {
            return k;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    public void test(){
        int[] nums = new int[4];
        nums[0] = 3;
        nums[1] = 4;
        nums[2] = -1;
        nums[3] = 1;
        int res = firstMissingPositive(nums);
        System.out.println(res);
    }
}
