package problems.GameofLife289;

/**
 * Created by yuxiao on 4/7/16.
 */
public class Solution {


    // use 1st to represent the present status.
    // use 2nd to represent the next status.
    // For example, "01" shows that the current status is live, but the next status is dead.
    public void gameOfLife(int[][] board) {
        if(board.length>0){

            int rows = board.length;
            int cols = board[0].length;

            for(int i=0;i<rows;i++){
                for(int j=0;j<cols;j++){
                    int neightbors;
                    if(board[i][j] == 1){//live
                         neightbors = findNeighbors(board,rows,cols,i,j);
                        if(neightbors ==2 || neightbors ==3){
                            board[i][j] = 3;
                        }
                    } else{
                        neightbors = findNeighbors(board,rows,cols,i,j);
                        if(neightbors == 3){
                            board[i][j] = 2;
                        }
                    }
                }
            }

            for (int i=0;i<rows;i++){
                for(int j=0;j<cols;j++){
                    board[i][j] >>= 1;
                }
            }
        }



    }

    // The snnipet code can be used as template for visiting the numbers around the current item.
    public int findNeighbors(int[][] board,int rows,int cols, int x,int y){
        int cnt=0;
        for(int i=x-1;i<=x+1;i++){
            for(int j=y-1;j<=y+1;j++){
                if(i>=0 && i<rows && j>=0 && j<cols){
                  cnt += board[i][j]&1;
                }
            }
        }

        cnt -= board[x][y]&1;
        return cnt;
    }
}
