package note.sort.IntersectionofTwoArrays349;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by yuxiao on 16/6/2.
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> nums1Set = new HashSet<>();
        HashSet<Integer> resSet = new HashSet<>();
        for(int item: nums1){
            nums1Set.add(item);
        }

        for(int item:nums2){
            if(nums1Set.contains(item)){
                resSet.add(item);
            }
        }
        int len = resSet.size();
        Integer[] tmpset = new Integer[len];
        resSet.toArray(tmpset);
        int[] res = new int[len];
        for(int i=0;i<len;i++){
            res[i] = tmpset[i];
        }
        return res;

    }
}
