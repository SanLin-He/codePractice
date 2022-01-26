import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        doPermute(ans, nums, used, new ArrayList<Integer>());
        return ans;
    }

    void doPermute(List<List<Integer>> ans, int[] nums, boolean[] used, List<Integer> oneP) {
        if (oneP.size() == nums.length) {
            ans.add(new ArrayList<Integer>(oneP));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;
            used[i] = true;
            oneP.add(nums[i]);
            doPermute(ans, nums, used, oneP);
            oneP.remove(oneP.size() - 1);
            used[i] = false;
        }

    }
}
// @lc code=end
