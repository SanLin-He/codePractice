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
        // return way4(nums);
        // return way5(nums);
        return way6(nums);


    }
//----- 分治
    public class Status {
        public int lSum, rSum, mSum, iSum;

        public Status(int lSum, int rSum, int mSum, int iSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }
    }

    public Status getInfo(int[] a, int l, int r) {
        if (l == r) {
            return new Status(a[l], a[l], a[l], a[l]);
        }
        int m = l + ((r-l) >> 1);
        Status lSub = getInfo(a, l, m);
        Status rSub = getInfo(a, m + 1, r);
        return pushUp(lSub, rSub);
    }

    public Status pushUp(Status l, Status r) {
        int iSum = l.iSum + r.iSum;
        int lSum = Math.max(l.lSum, l.iSum + r.lSum);
        int rSum = Math.max(r.rSum, r.iSum + l.rSum);
        int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
        return new Status(lSum, rSum, mSum, iSum);
    }

    // 分治法
    int way6(int[] nums) {
        return getInfo(nums, 0, nums.length - 1).mSum;

    }
//----分治
    // 前n数和，小于0则放弃,贪心
    int way5(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > max) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
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

    // // BF, Time Limit Exceeded
    // int way1(int[] nums) {
    // int n = nums.length;
    // int max = Integer.MIN_VALUE;
    // int[] kMax = new int[n];
    // for (int k = 0; k <= n; k++) {
    // for (int i = 0; i < n;) {
    // for (int kk = 0; kk < k + 1; kk++) {
    // kMax[k] += nums[kk];
    // }
    // i = i + k;
    // }
    // }
    // for (int i = 0; i < n; i++) {
    // if (kMax[i] > max)
    // max = kMax[i];
    // }

    // return 0;
    // }
}
// @lc code=end
