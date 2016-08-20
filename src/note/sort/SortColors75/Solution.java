package note.sort.SortColors75;

import org.junit.Test;

/**
 * Created by yuxiao on 16/6/3.
 * https://leetcode.com/problems/sort-colors/
 */
public class Solution {
    // two points
    // for example, the list that we should sort is [0,1,1,0,2,0,1,2]. i=0,start=0,end=7
    // if i=3, because start=0,then nums[0] = nums[3]. the key is that i doesn't increase at that time.
    // after the exchange, i still equals 3,but start++(start=1). the exchange end until nums[start] !=0
    public void sortColors(int[] nums) {

        int start = 0;
        int end = nums.length - 1;
        int temp;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == 0 && i != start) {
                temp = nums[start];
                nums[start] = nums[i];
                nums[i] = temp;
                start++;
            } else if (nums[i] == 2 && i < end) {
                temp = nums[end];
                nums[end] = nums[i];
                nums[i] = temp;
                end--;
            } else {
                i++;
            }
        }
        for (int val : nums) {
            System.out.println(val);
        }
    }

    @Test
    public void test() {
        int[] nums = {0, 1, 1, 0, 2, 0, 1, 2};
        sortColors(nums);
    }
}
