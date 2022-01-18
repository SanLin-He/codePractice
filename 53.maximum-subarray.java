/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        // return way1(nums);
        // return way2(nums);
        // return way3(nums);
        return way4(nums);

    }

    // 分治法
    int way5(int[] nums) {
        int max = nums[0];
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            cur = Math.max(nums[i], cur + nums[i]);
            if (cur > max)
                max = cur;
        }

        return Math.max(max, nums[0]);

    }

    // 动态优化空间优化
    int way4(int[] nums) {
        int max = nums[0];
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            cur = Math.max(nums[i], cur + nums[i]);
            if (cur > max)
                max = cur;
        }

        return Math.max(max, nums[0]);

    }

    // 动态优化空间优化
    int way3(int[] nums) {
        int max = Integer.MIN_VALUE;
        int pre = 0;
        int cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(nums[i], pre + nums[i]);
            pre = cur;
            if (cur > max)
                max = cur;
        }

        return Math.max(max, nums[0]);

    }

    // dp[i] 以i结束的最大子序和
    int way2(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] > max)
                max = dp[i];
        }
        return max;

    }

    // BF, Time Limit Exceeded
    int way1(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int[] kMax = new int[n];
        for (int k = 0; k <= n; k++) {
            for (int i = 0; i < n;) {
                for (int kk = 0; kk < k + 1; kk++) {
                    kMax[k] += nums[kk];
                }
                i = i + k;
            }
        }
        for (int i = 0; i < n; i++) {
            if (kMax[i] > max)
                max = kMax[i];
        }

        return 0;
    }
}
// @lc code=end
