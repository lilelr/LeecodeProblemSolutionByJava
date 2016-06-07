package note.backtracking.SimilaritySubset.CombinationSum39;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yuxiao on 16/6/7.
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
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
                tempList.add(nums[i]);
                backtracking(remain-nums[i],nums,i,res,tempList);
                tempList.remove(tempList.size()-1);
            }
        }


    }

    @Test
    public void test(){
        int[] nums = {2,3,6,7};
        List<List<Integer>> res = combinationSum(nums,7);
        for(List<Integer> itemList:res){
            for(Integer item: itemList){
                System.out.print(item+",");
            }
            System.out.println();
        }
    }
}
