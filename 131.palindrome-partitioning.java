import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=131 lang=java
 *
 * [131] Palindrome Partitioning
 */

// @lc code=start
class Solution {
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> partition(String s) {
        dfs(s, 0, new ArrayList<>());
        return ans;
    }

    void dfs(String s, int startIndex, List<String> path) {
        if (startIndex == s.length()) {//注意是到长度，而不是长度-1
            ans.add(new ArrayList<>(path));
            return;

        }

        for (int i = startIndex; i < s.length(); i++) {

            if (isPalindrome(s, startIndex, i)) {
                path.add(s.substring(startIndex, i + 1));
                dfs(s, i + 1, path);
                path.remove(path.size() - 1);
            }

        }
    }

    boolean isPalindrome(String s, int l, int r) {
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }

        return true;

    }
}
// @lc code=end
