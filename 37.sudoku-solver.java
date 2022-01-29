/*
 * @lc app=leetcode id=37 lang=java
 *
 * [37] Sudoku Solver
 */

// @lc code=start
class Solution {
    public void solveSudoku(char[][] board) {

        backTracking(board);
    }

    boolean backTracking(char[][] board) {

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.')// 跳过原始数字
                    continue;
                for (char num = '1'; num <= '9'; num++) {
                    if (!isNumValid(r, c, num, board))
                        continue;
                    board[r][c] = num;
                    if (backTracking(board)) // 如果找到合适一组立刻返回*********
                        return true;
                    board[r][c] = '.';

                }
                // 9个数都试完了，都不行，那么就返回false
                return false;
            }
        }

        return true;
    }

    boolean isNumValid(int r, int c, char num, char[][] board) {

        // 同行是否重复
        for (int i = 0; i < 9; i++) {
            if (board[r][i] == num) {
                return false;
            }
        }
        // 同列是否重复
        for (int j = 0; j < 9; j++) {
            if (board[j][c] == num) {
                return false;
            }
        }
        // 9宫格里是否重复
        int startRow = (r / 3) * 3;
        int startCol = (c / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

}
// @lc code=end
