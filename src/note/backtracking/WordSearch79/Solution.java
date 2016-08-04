package note.backtracking.WordSearch79;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yuxiao on 8/4/16.
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                Set<String> path = new HashSet<>();
                if(board[i][j] == word.charAt(0)){
                    path.add(i+","+j);
                    if(dfs(m,n,board,i,j,word,0,word.length(),path)){
                        return true;
                    }
                }
            }
        }

        return  false;
    }

    public boolean dfs(int m,int n,char[][] board,int i,int j,String word,int pos,int len,Set<String> path){
        if(pos == len-1){
            return true;
        }
        String up,down,left,right;
        if(i>=1){
             up = (i-1) + ","+j;
        }else{
            up= null;
        }
        if(i<=m-2){
             down = (i+1)+","+j;
        }else{
            down = null;
        }
        if(j>=1){
             left = i+","+ (j-1);
        }else{
            left = null;
        }
        if(j<=n-2){
             right = i+","+(j+1);
        }else{
            right = null;
        }

        if(!path.contains(up) && up!=null){
            if(board[i-1][j] == word.charAt(pos+1)){
                path.add(up);
                if(dfs(m,n,board,i-1,j,word,pos+1,len,path)){
                    return true;
                }
            }
        }

        if(!path.contains(down) && down!=null){
            if(board[i+1][j] == word.charAt(pos+1)){
                path.add(down);
                if(dfs(m,n,board,i+1,j,word,pos+1,len,path)){
                    return true;
                }
            }
        }

        if(!path.contains(left) && left!=null){
            if(board[i][j-1] == word.charAt(pos+1)){
                path.add(left);
                if(dfs(m,n,board,i,j-1,word,pos+1,len,path)){
                    return true;
                }
            }
        }

        if(!path.contains(right) && right!=null){
            if(board[i][j+1] == word.charAt(pos+1)){
                path.add(right);
                if(dfs(m,n,board,i,j+1,word,pos+1,len,path)){
                    return true;
                }
            }
        }

        return false;


    }
    @Test
    public void test(){
        char[][] board = new char[1][2];
        board[0][0]= 'a';
        board[0][1]= 'a';
        boolean res = exist(board,"aaa");
        System.out.println(res);
    }
}
