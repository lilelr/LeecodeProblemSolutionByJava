package note.backtracking.SimilaritySubset.Subsets78;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yuxiao on 16/6/7.
 */
public class Solution {
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
            tempList.add(nums[i]);
            backtracking(nums,i+1,res,tempList);
            tempList.remove(tempList.size()-1);
        }
    }

    @Test
    public void test(){
        int[] nums = {1,2,3};
        List<List<Integer>> res = subsets(nums);
        for(List<Integer> itemList:res){
            for(Integer item: itemList){
                System.out.print(item+",");
            }
            System.out.println();
        }
    }
}
