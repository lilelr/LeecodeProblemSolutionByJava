package note.binarysearch.ContainsDuplicate220;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by yuxiao on 4/26/16.
 */
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
//        Map<Integer,Integer> map =new HashMap<>();
//        for(int i=0;i<nums.length;i++){
//            if(map.containsKey(nums[i]) && i-map.get([i])<=k){
//                return true;
//            }
//
//            if(map.size() > k){
//                map.remove(nums[i-k]);
//            }
//            map.put(nums[i],i);
//        }
    }

    //219 hashmap or hashset
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && (i-map.get(nums[i])) <= k)
                return true;
            // avoid TLE in leetcode here
            if (map.size() > k)
                map.remove(nums[i-k]);
            map.put(nums[i], i);
        }
        return false;
    }

    public boolean containsDuplicate(int[] nums) {
            Set<Integer> hashset  = new HashSet<>();
           if(nums.length == 0) return false;
          for(int key:nums){
              if(!hashset.add(key)) return true;
          }
        return false;
    }

}
