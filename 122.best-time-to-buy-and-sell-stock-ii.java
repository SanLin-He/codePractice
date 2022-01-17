/*
 * @lc app=leetcode id=122 lang=java
 *
 * [122] Best Time to Buy and Sell Stock II
 */

// @lc code=start
//[7,1,5,3,6,4] [1,2,3,4,5] [7,6,4,3,1]
class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <2) return 0;
        
        int maxProfit = 0;
        int slow = 0;
        int fast = 0;
        
        while (fast < prices.length -1){
            if(prices[fast] < prices[fast + 1] ){
                fast++;
                maxProfit += Math.max(prices[fast] - prices[fast-1],0);
            } else {
                slow = fast;
                fast = slow +1;
            }
            
        }
        


        return maxProfit;

    }
}
// @lc code=end

