/*
 * @lc app=leetcode id=680 lang=java
 *
 * [680] Valid Palindrome II
 */

// @lc code=start
class Solution {
    public boolean validPalindrome(String s) {
        return way1(s);
    }

    boolean way1(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (r > l) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                return isPalindromeHelper(s, l + 1, r) || isPalindromeHelper(s, l, r - 1);
            }

        }
        return true;
    }

    boolean isPalindromeHelper(String s, int l, int r) {
        while (r > l) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    boolean isPalindromeHelper2(String s, int l, int r) {
        for (int i = l, j = r; i < j; ++i, --j)
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }

        return true;
    }

  
}
// @lc code=end
