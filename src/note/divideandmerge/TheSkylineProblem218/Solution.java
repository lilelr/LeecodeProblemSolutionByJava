package note.divideandmerge.TheSkylineProblem218;

import java.util.*;

/**
 * Created by yuxiao on 7/29/16.
 */
public class Solution {


    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for (int[] b : buildings) {
            // start point has negative height value
            height.add(new int[]{b[0], -b[2]});
            // end point has normal height value
            height.add(new int[]{b[1], b[2]});
        }

        // sort $height, based on the first value, if necessary, use the second to
        // break ties
        Collections.sort(height, (a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            return a[1] - b[1];
        });

        // Use a maxHeap to store possible heights
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));

        // Provide a initial value to make it more consistent
        pq.offer(0);

        // Before starting, the previous max height is 0;
        int prev = 0;

        // visit all points in order
        for (int[] h : height) {
            if (h[1] < 0) { // a start point, add height
                pq.offer(-h[1]);
            } else {  // a end point, remove height
                pq.remove(h[1]);
            }
            int cur = pq.peek(); // current max height;

            // compare current max height with previous max height, update result and
            // previous max height if necessary
            if (prev != cur) {
                result.add(new int[]{h[0], cur});
                prev = cur;
            }
        }
        return result;
    }

    public List<int[]> getSkyline2(int[][] buildings) {
        List<int[]> result = new ArrayList<int[]>();
        int n = buildings.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
        int pos = -1, curHeight = -1;
        while (pos + 1 < n) {
            do {
                pos++;
                minHeap.add(buildings[pos][1]);
                treeMap.put(buildings[pos][2], buildings[pos][1]);
            } while (pos + 1 < n && buildings[pos + 1][0] == buildings[pos][0]);
            int curMax = treeMap.lastKey();
            if (curMax != curHeight) {
                result.add(new int[]{buildings[pos][0], curHeight = curMax});
            }
            while (minHeap.size() != 0 && (pos == n - 1 || minHeap.peek() < buildings[pos + 1][0])) {
                int curpos = minHeap.poll();
                treeMap.values().remove(curpos);
                curMax = treeMap.size() == 0 ? 0 : treeMap.lastKey();
                if (curHeight != curMax) {
                    result.add(new int[]{curpos, curHeight = curMax});
                }
            }
        }
        return result;
    }
}
