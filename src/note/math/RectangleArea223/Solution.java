package note.math.RectangleArea223;

import org.junit.Test;

/**
 * Created by yuxiao on 8/4/16.
 * https://leetcode.com/problems/rectangle-area/
 */
public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        long reA = (D - B) * (C - A);
        long reB = (H - F) * (G - E);
        System.out.println(Math.min(C, G));
        System.out.println(Math.max(A, E));
        double longSide = (double) Math.min(C, G) - (double) Math.max(A, E);
        double shortSide = (double) Math.min(D, H) - (double) Math.max(B, F);
        if (longSide < 0 || shortSide < 0) {
            return (int) (reA + reB);
        }
        return (int) (reA + reB - longSide * shortSide);
    }

    @Test
    public void test() {
        System.out.println(computeArea(-1500000001, 0, -1500000000, 1, 1500000000, 0, 1500000001, 1));
    }
}
