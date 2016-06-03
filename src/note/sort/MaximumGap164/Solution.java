package note.sort.MaximumGap164;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by yuxiao on 16/6/3.
 */
public class Solution {
    // bucket sort http://baike.baidu.com/view/1784217.htm
    // https://leetcode.com/discuss/80334/java-easy-version-to-understand
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length <= 1)
            return 0;
        int len = nums.length, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            min = Integer.min(min, nums[i]);
            max = Integer.max(max, nums[i]);
        }
        if (max == min)
            return 0;
        int bucketSize = (max - min) / (len - 1);
        if (bucketSize == 0)
            bucketSize = 1;
        int bucketCount = (max - min) / bucketSize + 1;
        int[] left = new int[bucketCount];
        int[] right = new int[bucketCount];
        Arrays.fill(left, -1);
        Arrays.fill(right, -1);
        for (int i = 0; i < len; i++) {
            int position = (nums[i] - min) / bucketSize;
            if (left[position] == -1) {
                left[position] = nums[i];
                right[position] = nums[i];
            } else {
                left[position] = Integer.min(nums[i], left[position]);
                right[position] = Integer.max(nums[i], right[position]);
            }
        }
        int maxGap = Integer.MIN_VALUE, leftNumber = -1, rightNumber;
        for (int i = 0; i < bucketCount; i++) {
            if (left[i] != -1 && leftNumber == -1)
                leftNumber = right[i];
            else if (left[i] != -1 && leftNumber != -1) {
                rightNumber = left[i];
                maxGap = Integer.max(maxGap, rightNumber - leftNumber);
                leftNumber = right[i];
            }
        }
        return maxGap;
    }

    @Test
    public void test(){
        int[] nums = {105,7,5};
        int res = maximumGap(nums);
        System.out.println(res);
    }

}
