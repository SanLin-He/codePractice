/*
 * @lc app=leetcode id=344 lang=java
 *
 * [344] Reverse String
 */

// @lc code=start
class Solution {
    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length -1;
        char t = ' ';
        while(r>l){
            t = s[l];
            s[l] = s[r];
            s[r] = t;
            l++;
            r--; 
        }
        
    }
}
// @lc code=end

