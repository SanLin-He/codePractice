import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, candidates, new ArrayList<>(), target,0);
        return ans;
    }

    void dfs(List<List<Integer>> ans,int[] candidates, List<Integer> choosed,int target,int begin) {
     
        if( target == 0){
            ans.add(new ArrayList<>(choosed));
            return;
        }
        else if(target < 0){
            return;
        }

        for(int i = begin;i < candidates.length;i++) {
            choosed.add(candidates[i]);
            dfs(ans,candidates, choosed,target - candidates[i],i);
            choosed.remove(choosed.size() -1);
        }
    }



    // public List<List<Integer>> combinationSum(int[] candidates, int target) {
    //     List<List<Integer>> ans = new ArrayList<List<Integer>>();
    //     List<Integer> combine = new ArrayList<Integer>();
    //     dfs(candidates, target, ans, combine, 0);
    //     return ans;
    // }

    // public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
    //     if (idx == candidates.length) {
    //         return;
    //     }
    //     if (target == 0) {
    //         ans.add(new ArrayList<Integer>(combine));
    //         return;
    //     }
    //     // 直接跳过
    //     dfs(candidates, target, ans, combine, idx + 1);
    //     // 选择当前数
    //     if (target - candidates[idx] >= 0) {
    //         combine.add(candidates[idx]);
    //         dfs(candidates, target - candidates[idx], ans, combine, idx);
    //         combine.remove(combine.size() - 1);
    //     }
    // }


}
// @lc code=end

