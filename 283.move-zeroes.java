/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int not0Index = 0;
        for (int i = 0; i < n; i++) {
            while (not0Index < n && nums[not0Index] == 0 ) {
                not0Index++;
            }
             if (not0Index < n) {
                nums[i] = nums[not0Index];
                not0Index++;
             }else{
                 nums[i] = 0;
             }

        }

    }
}
// @lc code=end
