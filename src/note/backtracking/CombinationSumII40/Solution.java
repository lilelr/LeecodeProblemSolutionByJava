package note.backtracking.CombinationSumII40;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yuxiao on 16/6/7.
 */
public class Solution {
    // input [10,1,2,7,6,1,5]
    // output [[1,1,6],[1,2,5],[1,7],[2,6]]
    // after sorting , [10,1,2,7,6,1,5] -> [1,1,2,5,6,7,10] avoid duplicating, only start from [0]-1, don't start from [1]->1

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int a;
        Arrays.sort(candidates);
        int start =0;
        backtracking(target,candidates,start,res,new ArrayList<>());
        return res;

    }

    public void backtracking(int remain,int[] nums,int start,List<List<Integer>> res,List<Integer> tempList){
        if(remain ==0){
            if (tempList.size()==0 || tempList==null) return;
            res.add(new ArrayList<>(tempList));
        } else if(remain<0){
            return;
        } else {
            for(int i=start;i<nums.length;i++){
                if(i> start && nums[i]==nums[i-1]) continue; //avoid duplicating
                tempList.add(nums[i]);
                backtracking(remain-nums[i],nums,i+1,res,tempList);
                tempList.remove(tempList.size()-1);
            }
        }


    }

    @Test
    public void test(){
        int[] nums = {2,3,6,7};
        List<List<Integer>> res = combinationSum2(nums,7);
        for(List<Integer> itemList:res){
            for(Integer item: itemList){
                System.out.print(item+",");
            }
            System.out.println();
        }
    }
}
