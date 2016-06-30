package note.dp.EditDistance72;

/**
 * Created by yuxiao on 6/30/16.
 */
public class Solution {
    public int minDistance(String word1, String word2) {
       int m = word1.length();
        int n = word2.length();
        int[][] distance = new int[m+1][n+1];
        for(int i=0;i<=n;i++){
            distance[0][i] = i;
        }
        for(int i=0;i<=m;i++){
            distance[i][0] = i;
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int cost = word1.charAt(i) == word2.charAt(j) ? 0 :1;
                int minValue = Math.min(distance[i+1][j],distance[i][j+1]);
                if(distance[i][j] <=minValue){
                    distance[i+1][j+1] = distance[i][j] + cost;
                } else{
                    distance[i+1][j+1] = minValue+1;
                }
            }
        }

        return distance[m][n];
    }
}
