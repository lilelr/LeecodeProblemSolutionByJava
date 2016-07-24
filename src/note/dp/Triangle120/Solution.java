package note.dp.Triangle120;

import java.util.List;

/**
 * Created by yuxiao on 7/14/16.
 * https://leetcode.com/problems/triangle/
 */
public class Solution {
    //https://discuss.leetcode.com/topic/49520/java-top-down-4ms-bottom-up-6ms-solution
    //Bottom-Up 6ms
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] nums = new int[triangle.size()];

        for (int i = 0; i < triangle.size(); i++) {
            nums[i] = triangle.get(triangle.size() - 1).get(i);
        }

        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                nums[j] = triangle.get(i).get(j) + Math.min(nums[j], nums[j + 1]);
            }
        }
        return nums[0];
    }

    // Top-Down
    public int minimumTotalTop_Down(List<List<Integer>> triangle) {
        if (triangle.size() == 0) return 0;
        long[][] cache = new long[triangle.size()][triangle.size()];
        for (int i = 0; i < cache.length; i++)
            for (int j = 0; j < cache.length; j++)
                cache[i][j] = Long.MIN_VALUE;
        return dfs(triangle, 0, 0, 0, cache);
    }

    private int dfs(List<List<Integer>> triangle, int iCur, int jCur, int total, long[][] cache) {
        int min = Integer.MAX_VALUE;
        if (cache[iCur][jCur] != Long.MIN_VALUE) {
            min = (int) cache[iCur][jCur];
        } else if (iCur == triangle.size() - 1) {
            min = triangle.get(iCur).get(jCur);
        } else {
            min = dfs(triangle, iCur + 1, jCur, triangle.get(iCur).get(jCur), cache);
            min = Math.min(min, dfs(triangle, iCur + 1, jCur + 1, triangle.get(iCur).get(jCur), cache));
        }
        cache[iCur][jCur] = min;
        return min + total;
    }


}
