/*
 * @lc app=leetcode id=746 lang=java
 *
 * [746] Min Cost Climbing Stairs
 */

// @lc code=start
class Solution {

    // //到达第i个台阶所花费的最少体力为dp[i]
    // //dp[i] = min(dp[i - 1], dp[i - 2]) + cost[i];
    // //每当你爬上一个阶梯你都要花费对应的体力值
    // public int minCostClimbingStairs(int[] cost) {

    //     int[] dp  = new int[cost.length];
    //     dp[0] = cost[0];
    //     dp[1] = cost[1];

    //     for(int i = 2; i < dp.length ; i++) {
    //         dp[i] = Math.min(dp[i-1], dp[i-2]) + cost[i];
    //     }

    //     // 注意最后一步可以理解为不用花费，所以取倒数第一步，第二步的最少值
    //     return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
        
    // }


      //到达第i个台阶所花费的最少体力为dp[i]
    //dp[i] = min(dp[i - 1], dp[i - 2]) + cost[i];
    //每当你爬上一个阶梯你都要花费对应的体力值
    public int minCostClimbingStairs(int[] cost) {
        int pre = cost[0];
        int cur = cost[1];

        for(int i = 2; i < cost.length ; i++) {
            int next =  Math.min(pre, cur) + cost[i];
            pre = cur;
            cur = next;
        }

        // 注意最后一步可以理解为不用花费，所以取倒数第一步，第二步的最少值
        return Math.min(pre, cur);
        
    }
}
// @lc code=end

