/*
 * @lc app=leetcode id=28 lang=java
 *
 * [28] Implement strStr()
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.isEmpty()) return 0;
        if(haystack.length() < needle.length()) return -1;
        char[] h = haystack.toCharArray();
        char[] n = needle.toCharArray();
        for(int i=0;i<h.length - n.length + 1;i++) {
         for(int j = 0; j<n.length;j++){
             if(h[i+j] != n[j]) {
                break;  
             }
             if(j == n.length -1) {
                 return i;
             }
         }

        }
        return -1;


    }
}
// @lc code=end

