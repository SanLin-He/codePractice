import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 */

// @lc code=start
//每次从集合中选取元素，可选择的范围随着选择的进行而收缩，调整可选择的范围，就是要靠startIndex。
//求取子集问题，不需要任何剪枝！因为子集就是要遍历整棵树。!!!
///那么组合问题和分割问题都是收集树的叶子节点，而子集问题是找树的所有节点！!!
//那么既然是无序，取过的元素不会重复取，写回溯算法的时候，for就要从startIndex开始，而不是从0开始！
class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    // public List<List<Integer>> subsets(int[] nums) {

    //     dfs(nums, new ArrayList<>(), 0);
    //     return ans;
    // }

    // void dfs(int[] nums, List<Integer> path, int startIndex) {
    //     ans.add(new ArrayList<>(path));
    //     for (int i = startIndex; i < nums.length; i++) {
    //         path.add(nums[i]);
    //         dfs(nums, path, i + 1);
    //         path.remove(path.size() - 1);

    //     }
    // }

    public List<List<Integer>> subsets(int[] nums) {

        dfs(nums, new ArrayList<>(), 0);
        return ans;
    }

    void dfs(int[] nums, List<Integer> path, int startIndex) {
        ans.add(new ArrayList<>(path));
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, path, i + 1);
            path.remove(path.size() - 1);

        }
    }
}
// @lc code=end
