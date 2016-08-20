package note.sort.InsertInterval57;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuxiao on 16/6/3.
 * https://leetcode.com/problems/insert-interval/
 */
public class Solution {
    // Definition for an interval.
    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        if (intervals.size() == 0) {
            res.add(newInterval);
            return res;
        }
        boolean flag = false;
        for (int i = 0; i < intervals.size(); i++) {
            if (intervals.get(i).start >= newInterval.start) {
                intervals.add(i, newInterval);
                flag = true;
                break;
            }
        }
        if (!flag) {
            intervals.add(newInterval);
        }


        Interval preInterval = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval curInterval = intervals.get(i);
            if (curInterval.start > preInterval.end) {
                res.add(preInterval);
                preInterval = curInterval;
            } else if (curInterval.start <= preInterval.end && preInterval.end <= curInterval.end) {
                preInterval.end = curInterval.end;
            } else {
                continue;
            }
        }
        res.add(preInterval);
        return res;

    }

    @Test
    public void test() {
        Interval newInterval = new Interval(4, 9);

        Interval interval0 = new Interval(1, 2);
        Interval interval1 = new Interval(3, 5);
        Interval interval2 = new Interval(6, 7);
        Interval interval3 = new Interval(8, 10);
        Interval interval4 = new Interval(12, 16);
        List<Interval> testIntervals = new ArrayList<>();
        testIntervals.add(interval0);
        testIntervals.add(interval1);
        testIntervals.add(interval2);
        testIntervals.add(interval3);
        testIntervals.add(interval4);
        List<Interval> res = insert(testIntervals, newInterval);
        for (Interval interval : res) {
            System.out.println(interval.start + "->" + interval.end);
        }
    }

}
