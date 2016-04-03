package problems.LongestIncreasingSubsequence300;

import org.junit.Test;

/**
 * Created by yuxiao on 4/3/16. Longest Increasing Subsequence
 */
public class Solution {

    // O(n2) complexity
    public int lengthOfLIS(int[] nums) {

        if(nums == null || nums.length==0){
            return 0;
        }

        int len= nums.length;
        int[] res=new int[len];
        int[] sub=new int[len];
        res[0]=1;
        sub[0]=nums[0];


        int maxlen=1;
        for(int j=1;j<len;j++){
            int tmpRes=0;
            for(int i=0;i<j;i++){
                if(nums[j] > nums[i]){
                    if(tmpRes<res[i]){
                        tmpRes=res[i];
                    }
                }
            }
            res[j] = Math.max(1,tmpRes+1);
            maxlen = Math.max(maxlen,res[j]);
        }

        return maxlen;
    }

    @Test
    public void testLIS(){
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums));
    }
}
