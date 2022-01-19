/*
 * @lc app=leetcode id=461 lang=java
 *
 * [461] Hamming Distance
 */

// @lc code=start
class Solution {
    public int hammingDistance(int x, int y) {
        int s = x^y;
        int ans = 0;
        while(s!= 0){
            ans += s&1;
            s = s>>1;
        }

        return ans;
    }
}
// @lc code=end

