package note.other.MajorityElement169;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by yuxiao on 7/26/16.
 * https://leetcode.com/problems/majority-element/
 */
public class Solution {

    // sort n O(nlogn) 2ms
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    //hashmap   39ms
    public int majorityElementByHashMap(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = nums[0];
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.replace(num, map.get(num) + 1);
                if (map.get(num) > nums.length / 2) {
                    ans = num;
                    break;
                }
            }
        }
        return ans;
    }

    public int majorityElementByMooreVoteAlgorithm(int[] nums) {
        int count = 0, ans = 0;
        for (int num : nums) {
            if (count == 0) {
                ans = num;
                count = 1;
            } else if (ans == num) {
                count++;
            } else {
                count--;
            }
        }
        return ans;
    }


}
