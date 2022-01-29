import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 */

// @lc code=start
///理解“树层去重”和“树枝去重”非常重要!!!!
class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);//排序非常重要
        dfs(nums, new ArrayList<>(), used, 0);
        return ans;
    }

    void dfs(int[] nums, List<Integer> path, boolean[] used, int startIndex) {

        ans.add(new ArrayList<>(path));
        if (startIndex >= nums.length){
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            // used[i - 1] == true，说明同一树枝candidates[i - 1]使用过
            // used[i - 1] == false，说明同一树层candidates[i - 1]使用过
            // 而我们要对同一树层使用过的元素进行跳过
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;
            used[i] = true;
            path.add(nums[i]);
            dfs(nums, path, used, i + 1);
            path.remove(path.size() - 1);
            used[i] = false;

        }
    }
}
// @lc code=end
