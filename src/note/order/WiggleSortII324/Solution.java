package note.order.WiggleSortII324;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by yuxiao on 16/4/19.
 * https://leetcode.com/problems/wiggle-sort-ii/
 */
public class Solution {

    private static final Random random = new Random();

    //    Java 9 ms wiggled and randomized quickselect
    // https://leetcode.com/discuss/83704/java-9-ms-wiggled-and-randomized-quickselect
    public void wiggleSort(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        final int n = nums.length, d = n | 1; // now (1 + 2 * i) % d will go like 1, 3,... wrap-around, 0, 2,...
        int left = 0, right = nums.length - 1, k = n / 2; // note: 0-based k
        // Do quickselect for kth LARGEST element. Use wiggle-indexing to get the answer right away.
        while (true) {
            assert left <= right;
            int p = nums[(1 + 2 * (left + random.nextInt(right - left + 1))) % d];
            int l = left, m = l;
            for (int r = right, lw = (1 + 2 * l) % d, mw = lw, rw = (1 + 2 * r) % d; m <= r; ) {
                if (nums[mw] > p) {
                    int tmp = nums[mw];
                    nums[mw] = nums[lw];
                    nums[lw] = tmp;
                    ++l;
                    lw = (lw + 2) % d;
                    ++m;
                    mw = (mw + 2) % d;
                } else if (nums[mw] < p) {
                    int tmp = nums[mw];
                    nums[mw] = nums[rw];
                    nums[rw] = tmp;
                    --r;
                    rw = (rw - 2 + d) % d;
                } else { // ==
                    ++m;
                    mw = (mw + 2) % d;
                }
            }
            if (k < l - left) {
                right = l - 1;
            } else if (k >= m - left) {
                k -= m - left;
                left = m;
            } else {
                // else we got lucky - p is the median
                return;
            }
        }
    }

    //    Clear Java O(n) avg time & O(n) space solution using 3-way-partition
//    https://leetcode.com/discuss/88403/clear-java-o-n-avg-time-o-space-solution-using-3-way-partition
    public void wiggleSort2(int[] nums) {
        // median record the index of median
        int median = selectKth(nums, 0, nums.length - 1, nums.length % 2 == 0 ? nums.length / 2 : nums.length / 2 + 1);
        List<Integer> leftArr = new ArrayList<Integer>();

        for (int i = 0; i <= median; i++)
            leftArr.add(nums[i]);
        List<Integer> rightArr = new ArrayList<Integer>();
        for (int i = median + 1; i < nums.length; i++)
            rightArr.add(nums[i]);

        for (int li = leftArr.size() - 1, ri = rightArr.size() - 1, i = 0; ri >= 0; li--, ri--, i += 2) { // right is same or shorter than left
            nums[i] = leftArr.get(li);
            nums[i + 1] = rightArr.get(ri);
        }
        if (nums.length % 2 != 0)
            nums[nums.length - 1] = leftArr.get(0);
    }

    private int selectKth(int[] nums, int start, int end, int k) {
        int[] res = partition(nums, start, end);
        int lb = res[0];
        int hb = res[1];
        if (k - 1 < lb)
            return selectKth(nums, start, lb - 1, k);
        else if (k - 1 > hb)
            return selectKth(nums, hb + 1, end, k);
        else
            return k - 1;
    }

    private int[] partition(int[] nums, int lb, int hb) {
        int pVal = nums[lb]; // use random genarater is better in performance
        int i = lb;
        while (i <= hb) {
            if (nums[i] == pVal)
                i++;
            else if (nums[i] < pVal)
                swap(nums, i++, lb++);
            else
                swap(nums, i, hb--);
        }
        int[] res = new int[2];
        res[0] = lb;
        res[1] = hb;
        return res;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    @Test
    public void test(){
        int[] numbs = {5,8,6,4,3}; //partition(numbs,0,4) 返回 {lb:2,rb:2}
        wiggleSort2(numbs);
    }

}
