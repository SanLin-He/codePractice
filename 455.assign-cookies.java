import java.util.Arrays;

/*
 * @lc app=leetcode id=455 lang=java
 *
 * [455] Assign Cookies
 */

// @lc code=start
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int count = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int Si = s.length - 1;
        for (int Gi = g.length - 1; Gi >= 0; Gi--) {
            if (Si >= 0 && s[Si] >= g[Gi]) {
                count++;
                Si--;
            }
        }

        return count;
    }
}
// @lc code=end
