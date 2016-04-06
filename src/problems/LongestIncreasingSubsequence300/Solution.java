package problems.LongestIncreasingSubsequence300;

import org.junit.Test;

/**
 * Created by yuxiao on 4/3/16. Longest Increasing Subsequence
 */
public class Solution {

    // O(n2) complexity
    public int lengthOfLIS(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int[] res = new int[len];
        res[0] = 1;

        int maxlen = 1;
        for (int j = 1; j < len; j++) {
            int tmpRes = 0;
            for (int i = 0; i < j; i++) {
                if (nums[j] > nums[i]) {
                    if (tmpRes < res[i]) {
                        tmpRes = res[i];
                    }
                }
            }
            res[j] = Math.max(1, tmpRes + 1);
            maxlen = Math.max(maxlen, res[j]);
        }

        return maxlen;
    }

    // DP + BST O(nlogn)
    public int lengthOfLISByDP(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length, len = 1;
        int[] result = new int[n];
        result[0] = nums[0];
        for (int i = 1; i < n; i++) {
            int currentElement = nums[i];
            if (currentElement <= result[0]) {
                result[0] = currentElement;
            } else if (currentElement > result[len - 1]) {
                result[len++] = currentElement;
            } else {
                int position = binarySearch(result, currentElement, 0, len - 1);
                result[position] = currentElement;
            }
        }
        return len;
    }

    public int binarySearch(int[] arr, int target, int start, int end) {
        int leftIndex = start, rightIndex = end;

        while (rightIndex - leftIndex > 1) {
            int middleIndex = (leftIndex + rightIndex) / 2, middleElement = arr[middleIndex];
            if (middleElement == target) {
                return middleIndex;
            } else if (middleElement < target) {
                leftIndex = middleIndex;
            } else {
                rightIndex = middleIndex;
            }
        }
        return rightIndex;
    }

    @Test
    public void testLIS() {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLISByDP(nums));
        System.out.println(lengthOfLIS(nums));

    }
}
