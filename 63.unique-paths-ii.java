/*
 * @lc app=leetcode id=63 lang=java
 *
 * [63] Unique Paths II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rLen = obstacleGrid.length;
        int cLen = obstacleGrid[0].length;
        int[][] dp = new int[rLen][cLen];

        // int ob = -1;
        // for (int r = 0; r < rLen; r++) {
        // if (obstacleGrid[r][0] == 1) {
        // ob = r;
        // break;
        // }
        // }

        // for (int r = 0; r < rLen; r++) {
        // dp[r][0] = 1;
        // if (ob != -1 && r >= ob) {
        // dp[r][0] = 0;
        // }
        // }

        // ob = -1;
        // for (int c = 0; c < cLen; c++) {
        // if (obstacleGrid[0][c] == 1) {
        // ob = c;
        // break;
        // }
        // }

        // for (int c = 0; c < cLen; c++) {
        // dp[0][c] = 1;
        // if (ob != -1 && c >= ob) {
        // dp[0][c] = 0;
        // }
        // }

        for (int i = 0; i < rLen && obstacleGrid[i][0] == 0; i++)
            dp[i][0] = 1;
        for (int j = 0; j < cLen && obstacleGrid[0][j] == 0; j++)
            dp[0][j] = 1;
        for (int r = 1; r < rLen; r++) {
            for (int c = 1; c < cLen; c++) {
                if (obstacleGrid[r][c] == 1) {
                    dp[r][c] = 0;
                } else {
                    dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
                }
            }
        }

        return dp[rLen - 1][cLen - 1];

    }
}
// @lc code=end
