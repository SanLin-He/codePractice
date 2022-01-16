/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {

        StringBuilder sb = new StringBuilder();
        int pointer = 0;
        char ch = ' ';
        here:
        while (true) {
            if(strs[0].length() <= pointer)break here;
            ch = strs[0].charAt(pointer);
            for (int i = 1; i < strs.length; i++) {
                if(strs[i].length()<= pointer) break here;
                if (ch != strs[i].charAt(pointer)) {
                    ch = ' ';
                    break here;
                }
            }
            if(ch != ' '){
                sb.append(ch);
            }
            pointer++;
        }

        return sb.toString();

    }
}
// @lc code=end
