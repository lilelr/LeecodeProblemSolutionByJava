package note.divideandmerge.MajorityElement;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by yuxiao on 7/26/16.
 */
public class Solution {

    // sort n O(nlogn) 2ms
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    //hashmap   39ms
    public int majorityElementByHashMap(int[] nums){
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans=nums[0];
        for(int num:nums){
            if(!map.containsKey(num)){
                map.put(num,1);
            } else {
                map.replace(num,map.get(num)+1);
                if(map.get(num) > nums.length/2){
                    ans = num;
                    break;
                }
            }
        }
        return ans;
    }


}