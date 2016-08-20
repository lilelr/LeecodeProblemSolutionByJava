package note.twopoint.Sum15;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yuxiao on 16/4/21.
 * https://leetcode.com/problems/3sum/
 */
public class Solution {
    // O(n^2) two points   It is also an good example using do{}while(*); compared with while(*);
    //[1,2,3,-1,0,-2,-3,-3]
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len < 3) return res;

        Arrays.sort(nums);
        int p1 = 0;
        while (p1 < len - 2) {
            int start = p1 + 1, end = len - 1;
            while (start < end) {
                int sum = nums[start] + nums[end] + nums[p1];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[p1], nums[start], nums[end]));

                    do {
                        end--;
                    } while (end > start && nums[end] == nums[end + 1]);

                    do {
                        start++;
                    } while (start < end && nums[start] == nums[start - 1]);

                } else if (sum > 0) {
                    do {
                        end--;
                    } while (end > start && nums[end] == nums[end + 1]);
                } else {

                    do {
                        start++;
                    } while (start < end && nums[start] == nums[start - 1]);
                }
            }

            do {
                p1++;
            } while (p1 < len - 2 && nums[p1] == nums[p1 - 1]);
        }
        return res;

    }

    public List<Integer> sort(int a, int b, int c) {
        int t;
        if (a > b) {
            t = a;
            a = b;
            b = t;
        }
        if (a > c) {
            t = a;
            a = c;
            c = t;
        }

        if (b > c) {
            t = c;
            c = b;
            b = t;
        }

        List<Integer> res = new ArrayList<>();
        res.add(a);
        res.add(b);
        res.add(c);
        return res;
    }


    @Test
    public void test() {
//        int[] nums = {-1, 0, 1,-1,4,0};
        int[] nums = {1, 2, -3, -1, 0};
        List<List<Integer>> res = threeSum(nums);
    }

}
