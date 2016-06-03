package note.sort.MergeIntervals56;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by yuxiao on 16/6/3.
 */
public class Solution {

     // Definition for an interval.
      public class Interval {
         int start;
          int end;
         Interval() { start = 0; end = 0; }
         Interval(int s, int e) { start = s; end = e; }
     }


    public class IntervalComparator implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            Interval interval1 = (Interval)o1;
            Interval interval2 = (Interval)o2;
            if (interval1.start > interval2.start){
                return 1;
            } else if(interval1.start == interval2.start){
                return 0;
            } else{
                return -1;
            }
        }
    }

    public List<Interval> merge(List<Interval> intervals) {

        List<Interval> res = new ArrayList<>();
        if(intervals ==null ||intervals.size() ==0) return res;
        Collections.sort(intervals,new IntervalComparator());

        Interval preInterval = intervals.get(0);
        for(int i=1;i<intervals.size();i++){
            Interval curInterval = intervals.get(i);
            if(curInterval.start > preInterval.end){
                res.add(preInterval);
                preInterval = curInterval;
            } else if(curInterval.start <= preInterval.end && preInterval.end<= curInterval.end){
                preInterval.end = curInterval.end;
            } else {
                continue;
            }
        }
        res.add(preInterval);
        return res;
    }

    @Test
    public void test(){
        Interval interval0 = new Interval(2,6);
        Interval interval1 = new Interval(1,3);
        Interval interval2 = new Interval(8,15);
        Interval interval3 = new Interval(9,10);
        Interval interval4 = new Interval(-4,2);
        List<Interval> testIntervals = new ArrayList<>();
        testIntervals.add(interval0);
        testIntervals.add(interval1);
        testIntervals.add(interval2);
        testIntervals.add(interval3);
        testIntervals.add(interval4);
        List<Interval> res = merge(testIntervals);
        for(Interval interval:res){
            System.out.println(interval.start+"->"+interval.end);
        }
    }
}
