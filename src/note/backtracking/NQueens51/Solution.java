package note.backtracking.NQueens51;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by yuxiao on 7/20/16.
 */
public class Solution {
    public List<List<String>> solveNQueens(int n) {
       char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<List<String>>();
        dfs(board, 0, res);
        return res;
    }

    private void dfs(char[][] board, int colIndex,List<List<String>> res){
        if(colIndex == board.length){
            res.add(contruct(board));
            return;
        }
        if(colIndex == 1){
            System.out.println("fr3");
        }
        for(int i=0;i<board.length;i++){
            if(validate(board,i,colIndex)){
                board[i][colIndex] = 'Q';
                dfs(board,colIndex+1,res);
                // backtracking
                board[i][colIndex] = '.';
            }
        }
    }

    private boolean validate(char[][] board,int x,int y){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<y;j++){
                // x+y == i+j 135度角的对角线
                // x+j==y+i   45度角的对角线
                // 由于是根据colIndex 顺序放入Q,故 y != j 一定成立
                if(board[i][j]=='Q' && (x+y == i+j || x+j == y+i || x==i) ){
                    return false;
                }
            }
        }
        return true;
    }

    private List<String> contruct(char[][] board){
        List<String> res = new LinkedList<>();
        for(int i=0;i<board.length;i++){
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }


    @Test
    public void test(){
        char[][] board = new char[2][2];
        List<List<String>> res = solveNQueens(4);

    }
}