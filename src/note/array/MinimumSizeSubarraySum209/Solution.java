package note.array.MinimumSizeSubarraySum209;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by yuxiao on 16/4/20.
 */
public class Solution {

    // divide and merger O(n*logn*logn) Time limited
    public int minSubArrayLenBad(int s, int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int l = 0;
        int r = len - 1;
        int largest = len + 1;
        int res = largest;

        /*int temp=nums[0];
        if(temp >=s) return 1;
        int res = largest;
        for(int i=1;i<len;i++){
           if(nums[i] >= s){
               res = 1;
           }
            if(temp+nums[i] >= s) {
                res = Math.min(res,2);
            }
            temp = nums[i];
        }
        if(res <= 2) return res;*/


        res = calculate(nums, l, r, largest, s);
        if (res == largest) return 0;
        return res;
    }

    public int calculate(int[] nums, int l, int r, int largest, int upper) {
        if (l == r) {
            return (nums[l] >= upper) ? 1 : largest;
        } else if (r == l + 1) {
            if (nums[l] >= upper || nums[r] >= upper) {
                return 1;
            } else {
                return (nums[l] + nums[r] >= upper) ? 2 : largest;
            }
        } else if (l < r) {
            int m = l + (r - l) / 2;
            long[] prefixOfSecondArray = new long[r - m];
            long sum = 0;
            int tempmin = largest;
            for (int i = m + 1; i <= r; i++) {
                sum += nums[i];
                if (sum >= upper) {
                    tempmin = Math.min(tempmin, i - m);
                }
                prefixOfSecondArray[i - m - 1] = sum;
            }


            sum = 0;
            int count = 0;
            for (int i = m; i >= l; i--) {
                sum += nums[i];
                int tempupper = bStree(prefixOfSecondArray, upper - sum);
                //no answer
                if (tempupper == prefixOfSecondArray.length) continue;
                count = (tempupper + 1) + (m - i + 1);
                tempmin = Math.min(count, tempmin);
//                if(tempupper == prefixOfSecondArray.length && templower==-1){
//                    count--;
//                }

            }
            int leftCalculate = calculate(nums, l, m, largest, upper);
            int rightCalculate = calculate(nums, m + 1, r, largest, upper);
            tempmin = Math.min(leftCalculate, tempmin);
            tempmin = Math.min(rightCalculate, tempmin);
            return tempmin;

        } else {
            return largest;
        }

    }

    public int bStree(long[] nums, double val) {
        int left = 0, right = nums.length - 1;
        int middle = 0;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (nums[middle] == val) return middle;
            if (nums[middle] < val) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return left;
    }

    //Solution2 two pointers O(n)
    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int sum = 0;
        int start = 0;
        int min = len + 1;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            if (sum >= s) {
                min = Math.min(min, i - start + 1);
            }
            while (sum - nums[start] >= s && start < len) {
                sum -= nums[start];
                start++;
                min = Math.min(min, i - start + 1);
            }
        }

        return min == len + 1 ? 0 : min;
    }


    //    Solution3 Binary Search O(nlogn) using cumulative sum
//    https://leetcode.com/discuss/85018/share-my-15-line-o-nlgn-java-code-using-cumulative-sum
    public int minSubArrayLen3(int s, int[] nums) {
        int[] cs = new int[nums.length];  // cumulative sum
        for (int i = 0, sum = 0; i < nums.length; ++i) {
            sum += nums[i];
            cs[i] = sum;
        }
        int minLength = nums.length * 2;
        for (int from = -1; from < nums.length - 1; ++from) {
            int cumuSum = (from == -1 ? 0 : cs[from]) + s;
            int result = Arrays.binarySearch(cs, cumuSum);  // actual index or should-be index
            int to = result < 0 ? -result - 1 : result;
            if (to < cs.length) {
                minLength = Math.min(minLength, to - from);
            }
        }
        return minLength == nums.length * 2 ? 0 : minLength;
    }


    @Test
    public void test() {
//        int[] nums = {2,3,1,2,4,3};
        int[] nums = {1, 2, 3, 4, 5};
//        int[] nums = {2,3,1};
//        int[] nums = {10,5,13,4,8,4,5,11,14,9,16,10,20,8};
        int res = minSubArrayLen3(11, nums);
//        int res = minSubArrayLen(4,nums);
        System.out.println(res);
    }

}
