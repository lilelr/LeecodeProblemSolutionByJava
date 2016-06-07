package note.backtracking.CombinationSum39;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuxiao on 16/6/7.
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = candidates.length;
        if(len ==0) return res;
        int sum =0;
        List<Integer> tempAns  = new ArrayList<>();
        int curPos = 0;
        backTracking(curPos,res,candidates,sum,target,len,tempAns);
        return res;

    }


    /**
     *
     * @param curPos
     * @param res
     * @param candidates
     * @param sum
     * @param target
     * @param len
     * @param tempAns
     */
    void backTracking(int curPos,List<List<Integer>> res,int[] candidates,int sum,int target,int len,List<Integer> tempAns){
       if(curPos == len) return;

        backTracking(curPos+1,res,candidates,sum,target,len,tempAns);
        int sumCopy = sum;
        sum+=candidates[curPos];
        if(sum == target){
            tempAns.add(candidates[curPos]);
            res.add(tempAns);
        } else if(sum > target){
            backTracking(++curPos,res,candidates,sumCopy,target,len,tempAns);
        } else{
            tempAns.add(candidates[curPos]);
            backTracking(++curPos,res,candidates,sum,target,len,tempAns);
        }
    }

    @Test
    public void test(){
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> res = combinationSum(candidates,target);
        for(List<Integer> itemList:res){
            for(Integer item: itemList){
                System.out.println(item);
            }
        }
    }
}
