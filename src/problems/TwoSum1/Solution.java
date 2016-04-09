package problems.TwoSum1;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuxiao on 4/9/16.
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int[] res = new int[2];
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((nums[i] + nums[j]) == target) {
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }

    //HashMap
    public int[] twoSumHashMap(int[] nums, int target){
        int len = nums.length;
        int[] res = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<len;i++){
            if(map.containsKey(target-nums[i])){
                res[1] = i;
                res[0] = map.get(target-nums[i]);
                break;
            }
            map.put(nums[i],i);
        }
        return res;
    }

}
