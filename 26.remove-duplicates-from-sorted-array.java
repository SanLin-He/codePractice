/*
 * @lc app=leetcode id=26 lang=java
 *
 * [26] Remove Duplicates from Sorted Array
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {

        int n = nums.length;
        if (n == 0)
            return 0;
        int k = 1,q=1;

        while (q < n) {
            if (nums[q] > nums[q - 1]) {
                nums[k] = nums[q];
                k++;
            }
            q++;
        }

        return k;
    }
}
// @lc code=end
