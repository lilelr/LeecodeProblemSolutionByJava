package note.segment_tree.falling_squares_699;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeMap;

class Solution {
    public static List<Integer> fallingSquares(int[][] positions) {
        List<Integer> res = new ArrayList<>();
        TreeMap<Integer, Integer> startHeight = new TreeMap<>();
        startHeight.put(0, 0);
        int max = 0;
        for (int[] pos : positions) {
            int start = pos[0], end = start + pos[1];
            Integer from = startHeight.floorKey(start);
            int height = startHeight.subMap(from, end).values().stream().max(Integer::compare).get() + pos[1];
            max = Math.max(height, max);
            res.add(max);
            // remove interval within [start, end)
            int lastHeight = startHeight.floorEntry(end).getValue();
            startHeight.put(start, height);
            startHeight.put(end, lastHeight);
            startHeight.keySet().removeAll(new HashSet<>(startHeight.subMap(start, false, end, false).keySet()));
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] positons = new int[3][2];
        positons[0][0] = 1;
        positons[0][1] = 2;
        positons[1][0] = 2;
        positons[1][1] = 3;

        positons[2][0] = 6;
        positons[2][1] = 1;
        List<Integer> res = fallingSquares(positons);
        for (int a : res) {
            System.out.println(a);
        }
    }
}