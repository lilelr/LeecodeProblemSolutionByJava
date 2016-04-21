package note.twopoint.RotateArray189;

import org.junit.Test;

/**
 * Created by yuxiao on 16/4/21.
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k%len;
        if(k == 0) return;
        reverse(nums,0,len-1);
        reverse(nums,0,k-1);
        reverse(nums,k,len-1);


    }

    public void reverse(int[] nums,int s,int e){
        int mid = (e-s)/2;
        for(int i=0;i<=mid;i++){
            int t = nums[s+i];
            nums[s+i] = nums[e-i];
            nums[e-i] = t;
        }
    }

    @Test
    public void test(){
        int[] nums = {1,2,3,4,5};
        rotate(nums,2);
        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
    }
}
