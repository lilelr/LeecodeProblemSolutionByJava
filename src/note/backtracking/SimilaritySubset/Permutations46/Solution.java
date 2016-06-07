package note.backtracking.SimilaritySubset.Permutations46;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yuxiao on 16/6/7.
 */
public class Solution {
    // input [1,2,3]
    // output [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int start =0;
        backtracking(nums,0,res,new ArrayList<>());
        return res;
    }

    void backtracking(int[] nums,int start,List<List<Integer>> res,List<Integer> tempList){
        if(tempList.size() == nums.length){
            res.add(new ArrayList<>(tempList));
        }
        for(int i=start;i<nums.length;i++){
            if(!tempList.contains(nums[i])){
                tempList.add(nums[i]);
                backtracking(nums,0,res,tempList);
                tempList.remove(tempList.size()-1);
            }

        }
    }

    @Test
    public void test(){
        int[] nums = {1,2,3};
        List<List<Integer>> res = permute(nums);
        for(List<Integer> itemList:res){
            for(Integer item: itemList){
                System.out.print(item+",");
            }
            System.out.println();
        }
    }
}
