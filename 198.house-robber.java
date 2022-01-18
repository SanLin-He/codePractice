/*
 * @lc app=leetcode id=198 lang=java
 *
 * [198] House Robber
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        
        // return way1(nums);
        return way2(nums);
    }


    // 动态规划空间优化
    int way2(int[] nums) {
        int n = nums.length;
        if(n ==1) return nums[0];
        if(2==n) return Math.max(nums[0], nums[1]);

        int cur = Integer.MIN_VALUE;
        int prePre = nums[0];
        int pre = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n; i++) {
            cur = Math.max(pre, prePre + nums[i]);
            prePre = pre;
            pre = cur;
        }

        return cur;

    }

    //动态规划
    int way1(int[] nums) {
        int n = nums.length;
        int[] maxMoney = new int[n];
        maxMoney[0] = nums[0];
        if(n == 1) return maxMoney[0];
        maxMoney[1] =Math.max(nums[1], nums[0]);
        if(n == 2) return maxMoney[1];

        for(int i = 2; i < n; i++){
            maxMoney[i] = Math.max(maxMoney[i-1], maxMoney[i - 2] + nums[i]);
        }
        return maxMoney[n-1];
    }
}
// @lc code=end

