package note.backtracking.SudokuSolver37;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuxiao on 16/4/29.
 */
public class Solution {
    private boolean[][] vis1;
    private boolean[][] vis2;
    private boolean[][] vis3;
    private boolean isFound;

    // 8ms
    public void solveSudoku(char[][] board) {
        vis1 = new boolean[9][9];
        vis2 = new boolean[9][9];
        vis3 = new boolean[9][9];
        isFound = false;
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0' - 1;
                    int k = calculateIndex(i,j);
                    vis1[i][num] = true;
                    vis2[j][num] = true;
                    vis3[k][num] = true;
                }
            }
        }

        bt(board, 0, 0);

    }


    // problem 36
    public boolean isValidSudoku(char[][] board) {
        vis1 = new boolean[9][9];
        vis2 = new boolean[9][9];
        vis3 = new boolean[9][9];
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0' - 1;
                    int k = calculateIndex(i,j);
                    if(vis1[i][num]==true || vis2[j][num] == true || vis3[k][num] == true){
                        return false;
                    }
                    vis1[i][num] = true;
                    vis2[j][num] = true;
                    vis3[k][num] = true;
                }
            }
        }
        return true;
    }



    private void bt(char[][] board, int i, int j) {
        if (i == 9) {
            isFound = true;
            return;
        }

        int index =calculateIndex(i,j);
        if (board[i][j] == '.') {
            for (int k = 1; k <= 9; k++) {
                int num = k - 1;
                if (!vis1[i][num] && !vis2[j][num] && !vis3[index][num]) {
                    char ch = (char) (k + '0');
                    board[i][j] = ch;
                    vis1[i][num] = true;
                    vis2[j][num] = true;
                    vis3[index][num] = true;
                    if (j == 8) {
                        bt(board, i + 1, 0);
                    } else {
                        bt(board, i, j + 1);
                    }

                    if (isFound) break;

                    board[i][j] = '.';
                    vis1[i][num] = false;
                    vis2[j][num] = false;
                    vis3[index][num] = false;
                }
            }
        } else {
            int num = board[i][j] - '0' - 1;
            vis1[i][num] = true;
            vis2[j][num] = true;
            vis3[index][num] = true;
            if (j == 8) {
                bt(board, i + 1, 0);
            } else {
                bt(board, i, j + 1);
            }
        }
    }


    private int calculateIndex(int i, int j) {
        int t = i / 3;
        switch (t) {
            case 0:
                return j / 3;
            case 1:
                return 3 + j / 3;
            case 2:
                return 6 + j / 3;
            default:
                return -1;
        }
    }


    @Test
    public void test() {

    }
}
