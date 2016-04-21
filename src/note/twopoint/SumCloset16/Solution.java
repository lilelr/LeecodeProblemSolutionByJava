package note.twopoint.SumCloset16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yuxiao on 16/4/21.
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len < 3) return 0;

        Arrays.sort(nums);

        int ans = (nums[0] + nums[1] + nums[2]);
        int minabs = Math.abs(target - ans);
        int p1 = 0;
        while (p1 < len - 2) {
            int start = p1 + 1, end = len - 1;
            while (start < end) {
                int sum = nums[start] + nums[end] + nums[p1];
                if (sum == target) {
                    return sum;
                } else if (sum > target) {
                    int tmpabs = sum - target;
                    if (tmpabs < minabs) {
                        minabs = tmpabs;
                        ans = sum;
                    }
                    do {
                        end--;
                    } while (end > start && nums[end] == nums[end + 1]);
                } else {
                    int tmpabs = target - sum;
                    if (tmpabs < minabs) {
                        minabs = tmpabs;
                        ans = sum;
                    }

                    do {
                        start++;
                    } while (start < end && nums[start] == nums[start - 1]);
                }
            }

            do {
                p1++;
            } while (p1 < len - 2 && nums[p1] == nums[p1 - 1]);
        }
        return ans;
    }
}
