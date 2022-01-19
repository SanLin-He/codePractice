/*
 * @lc app=leetcode id=263 lang=java
 *
 * [263] Ugly Number
 */

// @lc code=start
class Solution {
    public boolean isUgly(int n) {
        if(n<= 0) return false;
        int[] factors = new int[]{2,3,5};
        for(int factor : factors){
            while(n %factor == 0){
                n = n/factor;
            }
        }
        return n == 1;
    }


}
// @lc code=end

