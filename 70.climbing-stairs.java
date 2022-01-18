/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {


        // return way1(n);
        // return way2(n);
         return way3(n);

    }

    //动态规划
    int way1(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        if (n >= 2) {
            dp[1] = 2;
        }
        if (n >= 3) {
            for (int i = 2; i < n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }

        }
        return dp[n - 1];
    }
    //动态规划空间优化
    int way2(int n) {
        int r = 0;
        int qq = 1;
        int q = 2;
        if (n == 1)
            return qq;
        if (n == 2)
            return q;

        for (int k = 2; k < n; k++) {
            r = qq + q;

            qq = q;
            q = r;

        }

        return r;
    }

    //数学递推
    int way3(int n) {
        int r = 1;
        int qq = 0;
        int q = 0;

        for (int k = 0; k < n; k++) {
            qq = q;
            q = r;
            r = qq + q;

        }

        return r;
    }

}
// @lc code=end

