package note.heap.SlidingWindowMaximum239;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by yuxiao on 4/27/16.
 * https://leetcode.com/problems/sliding-window-maximum/
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1 || k == 0) return nums;
        List<Integer> res = new ArrayList<>();
        // max heap
        PriorityQueue<Num> pq = new PriorityQueue<>();
        // another method PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            pq.offer(new Num(nums[i], i));
        }

        for (int j = k; j < nums.length; j++) {
            System.out.println(pq.peek().val);
            res.add(pq.peek().val);

            // if the distance between current j and pg.peek().idx is always larger than k,
            // then remove the root.value from the heap. Attention that there may be
            // many numbers in heap need to be removed.
            if ((j - pq.peek().idx) >= k) {
                pq.poll();
                while (j - pq.peek().idx >= k) {
                    pq.poll();
                }
                pq.offer(new Num(nums[j], j));
            } else {
                // than consider two situations.
                // first, nums[j] is the biggest number compared to  the numbers in heap
                if (pq.peek().val <= nums[j]) {
                    pq.peek().val = nums[j];
                    pq.peek().idx = j;
                } else {
                    // second, nums[j] is small
                    pq.offer(new Num(nums[j], j));
                }
            }
        }
        // don't forget to add the last big number
        res.add(pq.peek().val);
        int[] ans = new int[res.size()];
        int pos = 0;
        for (Integer item : res) {
            ans[pos++] = item.intValue();
        }
        return ans;


    }

    private class Num implements Comparable<Num> {
        int val;
        int idx;


        public Num(int val, int idx) {
            this.val = val;
            this.idx = idx;

        }

        @Override
        public int compareTo(Num that) {
            return that.val - this.val;
        }
    }

    //Solution2  4ms
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int max = 0; //maximum of k elements in window

        int len = nums.length;
        int[] result;
        if (len == 1 || k == 0) {
            return nums;
        }
        len = len - k + 1; // loop will execute 'len' times.

        result = new int[len];

        for (int i = 0; i < len; i++) {
            if (i == 0) {
                max = getMax(nums, i, i + k - 1);  //linear search to get maximum of k values
            } else {
                if (max == nums[i - 1]) {   //check whether the last number is max or not
                    max = getMax(nums, i, i + k - 1); // get the new Max number
                } else if (max < nums[i + k - 1]) { // whether previous max is less than the new kth number
                    max = nums[i + k - 1];
                }
            }
            result[i] = max;

        }

        return result;
    }


    private static int getMax(int[] nums, int i, int w) {
        int max = nums[i];

        for (int j = i + 1; j <= w; j++) {
            if (max < nums[j])
                max = nums[j];
        }
        return max;
    }


    @Test
    public void test() {
//        int[] nums = {2,3,5,6,7,8};
        int[] nums = {9, 10, 9, -7, -4, -8, 2, -6};

        int[] ans = maxSlidingWindow(nums, 5);

    }
}
