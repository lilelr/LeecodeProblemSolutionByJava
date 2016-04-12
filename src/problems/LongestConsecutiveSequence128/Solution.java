package problems.LongestConsecutiveSequence128;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yuxiao on 16/4/12.
 */
public class Solution {
    // O(n) 19ms
    public int longestConsecutive(int[] nums) {
       int len = nums.length;
        if (len ==0) return 0;
        if(len == 1) return 1;

        HashSet<Integer> set = new HashSet<>();
        for(int item:nums){
            set.add(item);
        }
        Integer[] array = (Integer[]) set.toArray(new Integer[0]);
        int maxlen =0;
        for(Integer item:array){
            int count=0;
            if(set.contains(item+1)){
                continue;
            } else{
                while (set.remove(item--)){
                    count++;
                }
                maxlen = Math.max(maxlen,count);
            }
        }

        return maxlen;

    }



    @Test
   public void testlongestConsecutivei(){
       int[] nums = {100, 4, 200, 1, 3, 2};
       int ans = longestConsecutive(nums);
        System.out.println(ans);
        System.out.println(new Integer[0]);
   }

}
