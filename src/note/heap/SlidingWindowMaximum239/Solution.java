package note.heap.SlidingWindowMaximum239;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by yuxiao on 4/27/16.
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k == 1 || k==0) return nums;
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Num> pq = new PriorityQueue<>();
        for(int i=0;i<k;i++){
            pq.offer(new Num(nums[i],i));
        }

        for(int j=k;j<nums.length;j++){
            System.out.println(pq.peek().val);
            res.add(pq.peek().val);
            if((j-pq.peek().idx) >=k){
                pq.poll();
                while (j-pq.peek().idx >=k){
                    pq.poll();
                }
                pq.offer(new Num(nums[j],j));
            } else{
                if(pq.peek().val <= nums[j]){
                    pq.peek().val = nums[j];
                    pq.peek().idx = j;
                } else{
                    pq.offer(new Num(nums[j],j));
                }
            }
        }
        res.add(pq.peek().val);
        int[] ans = new int[res.size()];
        int pos=0;
        for(Integer item:res){
            ans[pos++] = item.intValue();
        }
        return ans;


    }

    private class Num implements Comparable<Num> {
        int val;
        int idx;


        public Num(int val,int idx){
            this.val = val;
            this.idx = idx;

        }

        @Override
        public int compareTo(Num that) {
            return that.val - this.val;
        }
    }


    @Test
    public void test(){
//        int[] nums = {2,3,5,6,7,8};
        int[] nums = {9,10,9,-7,-4,-8,2,-6};

        int[] ans = maxSlidingWindow(nums,5);

    }
}
