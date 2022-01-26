/*
 * @lc app=leetcode id=268 lang=java
 *
 * [268] Missing Number
 */

// @lc code=start
class Solution {
    public int missingNumber(int[] nums) {
        // return way1(nums);
        return way2(nums);
    }

    public int way1(int[] nums) {
        int n = nums.length;
        int total = (n * (n + 1)) >> 1;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        return total - sum;

    }

    public int way2(int[] nums) {
        int n = nums.length;
        int total = (n * (n + 1)) >> 1;
        for (int i = 0; i < n; i++) {
            total -= nums[i];
        }
        return total;

    }

    //位运算。 还可以
    public int way3(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = ans ^nums[i] ^i;
        }
        return ans;

    }
}
// @lc code=end
