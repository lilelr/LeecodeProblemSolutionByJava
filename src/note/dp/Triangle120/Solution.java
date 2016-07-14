package note.dp.Triangle120;

import java.util.List;

/**
 * Created by yuxiao on 7/14/16.
 */
public class Solution {
    //https://discuss.leetcode.com/topic/49520/java-top-down-4ms-bottom-up-6ms-solution
    //Bottom-Up 6ms
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] nums = new int[triangle.size()];

        for(int i=0;i<triangle.size();i++){
            nums[i] = triangle.get(triangle.size() -1).get(i);
        }

        for(int i=triangle.size()-2;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                nums[j]=triangle.get(i).get(j) + Math.min(nums[j],nums[j+1]);
            }
        }
        return nums[0];
    }



}
