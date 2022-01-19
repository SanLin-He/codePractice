/*
 * @lc app=leetcode id=326 lang=java
 *
 * [326] Power of Three
 */

// @lc code=start
class Solution {
    public boolean isPowerOfThree(int n) {
        

        return way1(n);
    }

    boolean way1(int n) {
        if(n <= 0) return false;

        while(n%3 ==0) {
            n = n/3;
        }
        if(n == 1) return true;
        return false;
    }
}
// @lc code=end

