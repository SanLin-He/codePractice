import java.util.Stack;

/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    // [7,1,5,3,6,4]
    public int maxProfit(int[] prices) {
        // return way1(prices);
        // return way2(prices);
        //  return way3(prices);
         return way4(prices);

    }
    //最大自序和
    int way4(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int ans = 0;
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            sum += prices[i] - prices[i - 1];
            ans = Math.max(ans, sum);
            if (sum < 0)
                sum = 0;
        }
        return ans;
    }

    int way3(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int n = prices.length;
        int maxProfit = 0;
        int minVale = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            if (prices[i] < minVale) {
                minVale = prices[i];
            }
            if (prices[i + 1] - minVale > maxProfit) {
                maxProfit = prices[i + 1] - minVale;
            }

        }
        return maxProfit;
    }

    int way1(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int n = prices.length;
        int maxProfit = 0;
        for (int i = 0; i < n - 1; i++) {
            int temp = max(prices, i + 1) - prices[i];
            if (temp > maxProfit) {
                maxProfit = temp;
            }
        }
        return maxProfit;
    }

    int max(int[] prices, int start) {
        int max = 0;
        for (int i = start; i < prices.length; i++) {
            if (prices[i] > max) {
                max = prices[i];
            }

        }
        return max;
    }

    int way2(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int n = prices.length;
        int maxProfit = 0;
        int leftMax = max(prices, 0);
        for (int i = 0; i < n; i++) {
            if (prices[i] >= leftMax) {
                leftMax = max(prices, i + 1);
            }
            int profit = leftMax - prices[i];
            if (profit > maxProfit) {
                maxProfit = profit;
            }

        }

        return maxProfit;
    }
}
// @lc code=end
