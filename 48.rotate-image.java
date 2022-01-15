/*
 * @lc app=leetcode id=48 lang=java
 *
 * [48] Rotate Image
 */

// @lc code=start
class Solution {
    public void rotate(int[][] matrix) {
        int temp = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < r; c++) {
                temp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = temp;

            }
        }

        for (int r = 0; r < matrix.length; r++) {
            reverse(matrix[r]);
        }

    }

    void reverse(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int temp = 0;
        while (r > l) {
            temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}
// @lc code=end
