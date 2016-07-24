package note.dp.UniquePaths62;

import org.junit.Test;

/**
 * Created by yuxiao on 6/28/16.
 * https://leetcode.com/problems/unique-paths/
 */
public class Solution {

    public int uniquePaths(int m, int n) {
       int[] layer = new int[n];
        layer[0] =1;
        for(int i=0;i<m;i++){
            for(int j=1;j<n;j++){
                layer[j] = layer[j] + layer[j-1];
            }
        }
        return layer[n-1];
    }

    // https://discuss.leetcode.com/topic/44204/well-explained-java-dynamic-programming-approach-o-mn-time-and-o-mn-space
    public int uniquePathsSimple(int m, int n) {
    /*
    Dynamic programming
    Bottom-up approach
    Let Num[i][j] represent the number of different paths to a given point [i, j] in the graph.
    Since any point [i, j] in the graph can only accessed by the point [i, j-1] or [i-1, j], so Num[i][j] = Num[i-1,j] + Num[i, j-1].
    Since Array indexes in java starts at 0, and we must have at least 1 point in the graph normally, as initialization we can let the values of all the points with i = 0 or j = 0 to be 0 and let Num[i][j] = 1. In this way we bypass the boundary condition where the robot is on the [1, j] or [i, 1] points, in which we have to judge the index of points to avoid array index out of boundary condition.
    This algorithm need O(n^2) time and O(n^2) space
    */

        if (m == 1 || n == 1){
            return 1;
        }

        int[][] Num = new int[m+1][n+1];
        for (int i = 0; i <= m; i ++){
            for (int j = 0; j <= n; j ++){
                if (i == 0 || j == 0){
                    Num[i][j] = 0;
                }

                else if (i == 1 && j == 1){
                    Num[i][j] = 1;
                }

                else {
                    Num[i][j] = Num[i-1][j] + Num[i][j-1];
                }
            }
        }

        return Num[m][n];
    }



    @Test
    public void test(){
//        System.out.println(uniquePaths(2,2));
//        System.out.println(uniquePaths(1,2));
        System.out.println(uniquePaths(3,7));
    }
}
