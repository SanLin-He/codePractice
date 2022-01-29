import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=93 lang=java
 *
 * [93] Restore IP Addresses
 */

// @lc code=start
class Solution {

    List<List<String>> ans = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();

        if (s.length() < 4 || s.length() > 16)
            return list;
        dfs(s, 0, new ArrayList<>());
        for (List<String> p : ans) {
            StringBuilder sb = new StringBuilder();
            for (String ss : p) {
                sb.append(ss);
            }
            sb.deleteCharAt(sb.length()-1);
            list.add(sb.toString());

        }

        return list;
    }

    void dfs(String s, int startIndex, List<String> path) {
        if (startIndex == s.length() && path.size() == 4) {
                ans.add(new ArrayList<>(path));
            }
        for (int i = startIndex; i < s.length(); i++) {
            String sub = s.substring(startIndex, i + 1);
            if (isValidIpNum(sub) && path.size()< 4) {
                path.add(sub + ".");
                dfs(s, i + 1, path);
                path.remove(path.size() - 1);
            } else
                break;
        }

    }

    boolean isValidIpNum(String s) {
        if (s.startsWith("0") && s.length() > 1)
            return false;
        long num = Long.parseLong(s);
        if (num < 0 || num > 255)//妈蛋，这里多写了个等于号。。。。。。导致调试错误，耗时半天多
            return false;
        return true;
    }
}
// @lc code=end
