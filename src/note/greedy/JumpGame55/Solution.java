package note.greedy.JumpGame55;

import org.junit.Test;

/**
 * Created by yuxiao on 8/3/16.
 * https://leetcode.com/problems/jump-game/
 */
public class Solution {
    private boolean isCanJump;

//    O(n)  https://discuss.leetcode.com/topic/19931/6-line-java-solution-in-o-n
    public boolean canJump(int[] nums) {
//        int lastIndex = nums.length - 1;
//        if(lastIndex <=0) return true;
//        isCanJump = false;
//        dfs(nums,0,lastIndex);
//        return isCanJump;

        int reachable = 0;
        for(int i=0;i<nums.length;i++){
            if(i> reachable) return false;
            reachable  = Math.max(reachable,i+nums[i]);
        }
        return true;
    }

    // Time limited O(n^2)
    public void dfs(int[] nums,int curPos,int lastIndex){
        if(curPos == lastIndex) {
            isCanJump = true;
            return;
        }

        if(curPos > lastIndex){
            return;
        }

        for(int i=1;i<=nums[curPos];i++){
            dfs(nums,curPos+i,lastIndex);
        }

    }

    @Test
    public void test(){
//        int[] nums = new int[]{2,3,1,1,4};
        int[] nums = new int[]{3,2,1,0,4};
        System.out.println(canJump(nums));
    }
}
