package note.backtracking.SimilaritySubset.Subset90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yuxiao on 16/6/7.
 */
public class Solution {
    // input [1,2,2]
    // output  [[],[1],[1,2],[1,2,2],[2],[2,2]]   skip duplicates [1,2]
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int start =0;
        backtracking(nums,start,res,new ArrayList<>());
        return res;

    }

    void backtracking(int[] nums,int start,List<List<Integer>> res,List<Integer> tempList){
        res.add(new ArrayList<>(tempList));
        for(int i=start;i<nums.length;i++){
            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
            tempList.add(nums[i]);
            backtracking(nums,i+1,res,tempList);
            tempList.remove(tempList.size()-1);
        }
    }
}
