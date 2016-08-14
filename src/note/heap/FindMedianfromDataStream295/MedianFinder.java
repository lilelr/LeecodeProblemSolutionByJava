package note.heap.FindMedianfromDataStream295;

import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by yuxiao on 8/14/16.
 * https://leetcode.com/problems/find-median-from-data-stream/
 */
public class MedianFinder {
    //https://discuss.leetcode.com/topic/52470/java-solution-with-two-heaps
//    https://discuss.leetcode.com/topic/27521/short-simple-java-c-python-o-log-n-o-1
    private PriorityQueue<Integer> min = new PriorityQueue<Integer>();
    private PriorityQueue<Integer> max = new PriorityQueue<Integer>(10, Collections.reverseOrder());
    private Queue<Integer> median = new LinkedList<Integer>();
    // Adds a number into the data structure.
    public void addNum(int num) {
        if (median.isEmpty()) {
            median.offer(num);
        } else {
            if (num < median.peek()) {
                max.offer(num);
            } else {
                min.offer(num);
            }
        }
        while (max.size() != 0 && max.size() + 1 > min.size()) {
            min.offer(median.poll());
            median.offer(max.poll());
        }
        while (min.size() != 0 && max.size() + 1 < min.size()) {
            max.offer(median.poll());
            median.offer(min.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (min.size() == max.size()) {
            return median.peek();
        } else {
            return (median.peek() + min.peek()) / 2.0;
        }
    }


    @Test
    public void test(){
        addNum(3);
        addNum(4);
        System.out.println(findMedian());
        addNum(1);
        System.out.println(findMedian());
        addNum(5);
        System.out.println(findMedian());
    }
}
