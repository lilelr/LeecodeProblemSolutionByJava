package note.divideandmerge.CountofRangeSum327;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by yuxiao on 3/27/16.
 * https://leetcode.com/problems/count-of-range-sum/
 * https://leetcode.com/discuss/79907/summary-divide-conquer-based-binary-indexed-based-solutions
 */
public class Solution {
    // O(n*logn*logn)
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0 || lower > upper) {
            return 0;
        }

        return countRangeSumSub(nums, 0, nums.length - 1, lower, upper);
    }

    private int countRangeSumSub(int[] nums, int l, int r, int lower, int upper) {
        if (l == r) {
            return nums[l] >= lower && nums[r] <= upper ? 1 : 0;  // base case
        }

        int m = l + (r - l) / 2;
        long[] arr = new long[r - m];  // prefix array for the second subarray
        long sum = 0;
        int count = 0;

        for (int i = m + 1; i <= r; i++) {
            sum += nums[i];
            arr[i - (m + 1)] = sum;	// compute the prefix array
        }

        Arrays.sort(arr);  // sort the prefix array

        // Here we can compute the suffix array element by element.
        // For each element in the suffix array, we compute the corresponding
        // "insertion" indices of the modified bounds in the sorted prefix array
        // then the number of valid ranges sums will be given by the indices difference.
        // I modified the bounds to be "double" to avoid duplicate elements.
        sum = 0;
        for (int i = m; i >= l; i--) {
            sum += nums[i];
            count += findIndex(arr, upper - sum + 0.5) - findIndex(arr, lower - sum - 0.5);
        }

        return countRangeSumSub(nums, l, m, lower, upper) + countRangeSumSub(nums, m + 1, r, lower, upper) + count;
    }

    // binary search function
    private int findIndex(long[] arr, double val) {
        int l = 0, r = arr.length - 1, m = 0;

        while (l <= r) {
            m = l + (r - l) / 2;

            if (arr[m] <= val) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return l;
    }

    @Test
    public void main() {

//        int[] arrtest = {-2, 5, -1};
//        int[] arrtest = {-2};
        int[] arrtest = {-3, 1, 2, -2, 2, -1};


        long[] arr = {-2, 5, -1};
//        System.out.println(binarySearch(arr,-2));
//                System.out.println(binarySearch(arr,1000));
//        System.out.println(countRangeSum(arr,-2,2));
//        System.out.println(bStree(arr,10));
//        System.out.println(calculate(arrtest, 0, arrtest.length - 1, -3, -1));
    }
}
