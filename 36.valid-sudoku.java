import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=36 lang=java
 *
 * [36] Valid Sudoku
 */

// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> checkSet = new HashSet<>();
        // check col
        for (int i = 0; i < 9; i++) {
            checkSet.clear();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!checkSet.add(board[i][j]))
                        return false;

                }
            }
        }

        // check row
        for (int i = 0; i < 9; i++) {
            checkSet.clear();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    if (!checkSet.add(board[j][i])) {
                        return false;
                    }
                }
            }
        }

        // check block 3*3
        for (int bc = 0; bc < 3; bc++) {
            for (int br = 0; br < 3; br++) {
                checkSet.clear();
                for (int r = 0; r < 3; r++) {
                    for (int c = 0; c < 3; c++) {
                        if (board[r + 3 * br][c + 3 * bc] != '.') {
                            if (!checkSet.add(board[r + 3 * br][c + 3 * bc])) {
                                return false;
                            }
                        }
                    }
                }
            }
        }

        return true;

    }
}
// @lc code=end
