package note.backtracking.SimilaritySubset.PermutaionsII47;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yuxiao on 16/6/7.
 */
public class Solution {

    // input [1,1,2]
    // output [[1,1,2],[1,2,1],[2,1,1]]
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(nums, res, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }

    void backtracking(int[] nums,  List<List<Integer>> res, List<Integer> tempList, boolean[] visited) {
        if (tempList.size() == nums.length) {
            res.add(new ArrayList<>(tempList));
        }else{
            for (int i = 0; i < nums.length; i++) {
                if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) continue;
                // 确保 [1,1,2] 先访问下标为0的1,再访问下标为1的1. 若先访问[1] ,再访问【0】 则continue
                tempList.add(nums[i]);
                visited[i] = true;
                backtracking(nums, res, tempList, visited);
                tempList.remove(tempList.size() - 1);
                visited[i] = false;
            }
        }

    }

    @Test
    public void test() {
        int[] nums = {1, 1, 2};
        List<List<Integer>> res = permuteUnique(nums);
        for (List<Integer> itemList : res) {
            for (Integer item : itemList) {
                System.out.print(item + ",");
            }
            System.out.println();
        }
    }
}
