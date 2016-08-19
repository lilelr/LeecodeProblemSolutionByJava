package note.greedy.JumpGameII45;

import org.junit.Test;

/**
 * Created by yuxiao on 8/3/16.
 * https://leetcode.com/problems/jump-game-ii/
 */
public class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int reachable = 0;
        int preReachable;
        int count = 1;
//        for (int i = 0; i < nums.length; i++) {
//            if (reachable >= nums.length - 1) break;
//
//            preReachable = reachable;
//            reachable = Math.max(reachable, i + nums[i]);
//            if (reachable != preReachable) {
//                count++;
//
//            }
//        }
        int i = 0;
        int nextRange = nums[0];
        while (i < nums.length) {
            if (reachable >= nums.length - 1) break;
            preReachable = reachable;

            if (nextRange >= nums.length - 1) break;

            for (int j = i + 1; j < nums.length && j <= nextRange; j++) {
                reachable = Math.max(reachable, nums[j] + j);
            }
            if (reachable != preReachable) {
                count++;
            }
            i = nextRange;
            nextRange = reachable;

        }

        return count;
    }

    @Test
    public void test() {

//        int[] nums = new int[]{5,9,3,2,1,0,2,3,3,1,0,0};
//        int[] nums = new int[]{2, 1};
        int[] nums = new int[]{1, 2, 3};
        int[] nums1 = new int[]{2, 2, 3, 1, 1, 1};
        int[] nums2 = new int[]{7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3};
        int[] nums3 = new int[]{2, 3, 1, 1, 4};
//        int[] nums = new int[]{1};

        System.out.println(jump(nums));
        System.out.println(jump(nums1));
        System.out.println(jump(nums2));
        System.out.println(jump(nums3));
    }
}
