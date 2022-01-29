import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=47 lang=java
 *
 * [47] Permutations II
 */

// @lc code=start
class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        dfs(nums, new ArrayList<>(), new int[nums.length]);
        return ans;
    }

    void dfs(int[] nums, List<Integer> path, int[] branchUsed) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        int[] levelUsed = new int[21];
        for (int i = 0; i < nums.length; i++) {
            if (levelUsed[nums[i] + 10] == 1)//层
                continue;
            if (branchUsed[i] == 1)//树枝
                continue;

            levelUsed[nums[i] + 10] = 1;
            path.add(nums[i]);
            branchUsed[i] = 1;
            dfs(nums, path, branchUsed);
            branchUsed[i] = 0;
            path.remove(path.size() - 1);
        }
    }
}
// @lc code=end
