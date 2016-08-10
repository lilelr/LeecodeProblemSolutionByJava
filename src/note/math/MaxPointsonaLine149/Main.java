package note.math.MaxPointsonaLine149;

import org.junit.Test;

import java.util.HashMap;

/**
 * Created by yuxiao on 8/10/16.
 * https://leetcode.com/problems/max-points-on-a-line/
 */

//  Definition for a point.
class Point {
    int x;
    int y;

    Point() {
        x = 0;
        y = 0;
    }

    Point(int a, int b) {
        x = a;
        y = b;
    }
}

class Solution {
    // O(n^2)
    public int maxPoints(Point[] points) {
        HashMap<Double, Integer> map = new HashMap<>();
        int res = 1;
        if (points.length == 0) return 0;

        for (int i = 0; i < points.length; i++) {
            map.clear();
            map.put(Double.MAX_VALUE, 1);
            int samePoints = 0;
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    samePoints++;
                } else if (points[i].x == points[j].x) {
                    map.replace(Double.MAX_VALUE, map.get(Double.MAX_VALUE) + 1);
                } else {
                    double slope = 0;
                    double disy = (double) points[j].y -(double)  points[i].y;
                    double disx= (double) points[j].x - (double) points[i].x;
                    if(disy==0.0){
                        slope = 0;
                    }else{
                        slope = disy /  disx;
                    }
                    if (map.containsKey(slope)) {
                        map.put(slope, map.get(slope) + 1);
                    } else {
                        map.put(slope, 2);
                    }
                }
            }
            res = Integer.max(res, samePoints + 1);
            for (Double itemKey : map.keySet()) {
                res = Integer.max(res, map.get(itemKey) + samePoints );
            }
        }
        return res;
    }

}

public class Main {

    @Test
    public void test() {
        Point[] points = new Point[3];
//        points[0] = new Point(2, 3);
//        points[1] = new Point(3, 3);
//        points[2] = new Point(-5,3);
//        points[0] = new Point(0, 0);
//        points[1] = new Point(1, 1);
//        points[2] = new Point(1,-1);
        points[0] = new Point(0, 0);
        points[1] = new Point(1, 0);
        points[2] = new Point(-1,0);
        Solution solution = new Solution();
        int res = solution.maxPoints(points);
        System.out.println(res);
    }
}
