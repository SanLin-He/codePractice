package _test;

import java.util.ArrayList;
import java.util.List;

class Test {

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
            list.add(sb.toString());

        }

        return list;
    }

    void dfs(String s, int startIndex, List<String> path) {

            if (path.size() == 4) {
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
        if (s.startsWith("0"))
            return false;
        long num = Long.parseLong(s);
        if (num < 0 || num >= 255)
            return false;
        return true;
    }

    public static void main(String[] args) {
        new Test().restoreIpAddresses("25525511135");
    }

}