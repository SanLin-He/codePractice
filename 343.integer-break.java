/*
 * @lc app=leetcode id=343 lang=java
 *
 * [343] Integer Break
 */

// @lc code=start
class Solution {
    //dp[i]：分拆数字i，可以得到的最大乘积为dp[i]。
    //递推公式：dp[i] = max(dp[i], max((i - j) * j, dp[i - j] * j));
    //j * (i - j) 是单纯的把整数拆分为两个数相乘，而j * dp[i - j]是拆分成两个以及两个以上的个数相乘。
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[2] = 1;
        for(int i = 3; i <= n; i++){
            for(int j = 1; j < i; j++){
                dp[i] =Math.max(dp[i], Math.max(j*(i-j),dp[i-j] * j));
            }
        }

        return dp[n];
        
    }

    //次拆成n个3，如果剩下是4，则保留4，然后相乘，但是这个结论需要数学证明其合理性！
    // public int integerBreak(int n) {
    //     if (n == 2) return 1;
    //     if (n == 3) return 2;
    //     if (n == 4) return 4;
    //     int result = 1;
    //     while (n > 4) {
    //         result *= 3;
    //         n -= 3;
    //     }
    //     result *= n;
    //     return result;
    // }
}
// @lc code=end

