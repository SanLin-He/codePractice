import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        // 关键步骤
        Arrays.sort(candidates);
        dfs(ans, new ArrayList<>(), candidates, target, new boolean[candidates.length],0);
        return ans;
    }

    void dfs(List<List<Integer>> ans, List<Integer>combine, int[]candidates,int target, boolean[]used, int index){
        if(target == 0 ){
            ans.add(new ArrayList<>(combine));
            return;
        }
        if(target < 0){
            return;
        }

        for(int i = index; i < candidates.length;i++){
            if(candidates[i] > target) break;
            
            //used[i-1]=true,同一支使用过
            //used[i-1]= false,  同一层使用过？？？？？？？？
            if(i > 0 && candidates[i] == candidates[i - 1]&& !used[i-1]) continue;
            used[i] = true;
            combine.add(candidates[i]);
            dfs(ans, combine, candidates, target - candidates[i], used, i+1);
            combine.remove(combine.size()-1);
            used[i] = false;
        }

    }
}
// @lc code=end

