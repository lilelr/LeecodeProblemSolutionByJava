package note.sort.HIndex274;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by yuxiao on 16/6/4.
 * https://leetcode.com/problems/h-index/
 */
public class Solution {
    // bucket sort
    public int hIndex(int[] citations) {
        int len = citations.length;
        int[] buckets = new int[len + 1];
        for (int i = 0; i < len; i++) {
            if (citations[i] >= len) {
                buckets[len]++;
            } else {
                buckets[citations[i]]++;
            }
        }

        int count = 0;
        int res = 0;
        for (int i = 0; i <= len; i++) {
            count += buckets[i];
            int moreThanCur = len - count + buckets[i];
            if (moreThanCur >= i) {
                res = Math.max(res, i);
            }
        }
//        for(int val:buckets){
//            System.out.println(val);
//        }
//        System.out.println(res);
        return res;
    }

    @Test
    public void test() {
        int[] citations = {1, 6, 6, 6, 6, 3, 4};
        hIndex(citations);
    }
}
