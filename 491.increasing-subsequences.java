import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=491 lang=java
 *
 * [491] Increasing Subsequences
 */

// @lc code=start
class Solution {
    List<List<Integer>> ans = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(nums, new LinkedList<>(), 0);
        return ans;
    }

    void dfs(int[] nums, LinkedList<Integer> path, int startIndex) {

        if (path.size() > 1)
            ans.add(new LinkedList<>(path));

        int[] used = new int[201];// -100 <= nums[i] <= 100
        for (int i = startIndex; i < nums.length; i++) {
            if (used[nums[i] + 100] == 1)
                continue;// 树层
            if (!path.isEmpty()&&nums[i] < path.getLast())
                continue;// 树枝
            used[nums[i] + 100] = 1;
            path.add(nums[i]);
            dfs(nums, path, i + 1);
            path.removeLast();

        }
    }
}
// @lc code=end
