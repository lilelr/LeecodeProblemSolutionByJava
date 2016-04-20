package problems.MinimumSizeSubarraySum209;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by yuxiao on 16/4/20.
 */
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int l = 0;
        int r = len - 1;
        int largest = len + 1;
        int res = largest;

        /*int temp=nums[0];
        if(temp >=s) return 1;
        int res = largest;
        for(int i=1;i<len;i++){
           if(nums[i] >= s){
               res = 1;
           }
            if(temp+nums[i] >= s) {
                res = Math.min(res,2);
            }
            temp = nums[i];
        }
        if(res <= 2) return res;*/


        res = calculate(nums, l, r, largest, s);
        if (res == largest) return 0;
        return res;
    }

    public int calculate(int[] nums, int l, int r, int largest, int upper) {
        if (l == r) {
            return (nums[l] >= upper) ? 1 : largest;
        }else if(r==l+1){
            if(nums[l]>=upper || nums[r]>=upper) {
                return 1;
            } else{
                return (nums[l]+nums[r] >= upper) ? 2: largest;
            }
        }  else if (l < r) {
            int m = l + (r - l) / 2;
            int sum = 0;
            int tmpmin = largest;
            for (int i = l; i <= r; i++) {
                sum += nums[i];
                if (sum >= upper) {
                    tmpmin = Math.min((i - l) + 1, tmpmin);
                }
            }

            int leftCalculate = calculate(nums, l, m, largest, upper);
            int rightCalculate = calculate(nums, m , r, largest, upper);
            tmpmin = Math.min(leftCalculate, tmpmin);
            tmpmin = Math.min(rightCalculate, tmpmin);
            return tmpmin;

        } else {
            return largest;
        }

    }

    @Test
    public void test(){
//        int[] nums = {2,3,1,2,4,3};
        int[] nums = {10,5,13,4,8,4,5,11,14,9,16,10,20,8};
//        int res = minSubArrayLen(7,nums);
        int res = minSubArrayLen(80,nums);
        System.out.println(res);
    }

}
