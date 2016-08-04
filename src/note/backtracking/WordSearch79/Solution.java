package note.backtracking.WordSearch79;

import org.junit.Test;


/**
 * Created by yuxiao on 8/4/16.
 * https://leetcode.com/problems/word-search/
 */
public class Solution {
    // https://discuss.leetcode.com/topic/47611/8ms-beats-96-13-java-solution-easy-to-understand
    public boolean exist(char[][] board, String words) {
        char[] word = words.toCharArray();
        for(int i = 0; i<board.length;i++){
            for(int j = 0; j<board[0].length;j++){
                if(board[i][j] == word[0]){
                    if(helper(board, i, j, word,0)){return true;}
                }
            }//for j
        }//for i
        return false;
    }//exist

    // check if board[i][j] is equal to word[index] first inside the function
    // then decide the next direction to go head
    public boolean helper(char[][] board, int i, int j, char[] word,int index){
        if(index == word.length)return true;
        if(i<0 || j<0 || i == board.length || j == board[i].length) return false;
        if(board[i][j] != word[index])return false;

        // in order not to go back , for example 'a'(94) ^ 256 = 353 ,next visit 353 will not
        // equal to any letter of word
        board[i][j] ^= 256;

        // code trick using "||" ,it is absolutely cool
        boolean exist = helper(board, i, j+1, word, index+1)
                || helper(board, i-1, j, word, index+1)
                || helper(board, i, j-1, word, index+1)
                || helper(board, i+1, j, word, index+1);

        board[i][j] ^= 256;
        return exist;

    }//helper
    @Test
    public void test() {
        char[][] board = new char[1][2];
        board[0][0] = 'a';
        board[0][1] = 'a';
        boolean res = exist(board, "aaa");
        System.out.println(res);
    }
}
