package note.dp.UniquePaths62;

import org.junit.Test;

/**
 * Created by yuxiao on 6/28/16.
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



    @Test
    public void test(){
//        System.out.println(uniquePaths(2,2));
//        System.out.println(uniquePaths(1,2));
        System.out.println(uniquePaths(3,7));
    }
}
