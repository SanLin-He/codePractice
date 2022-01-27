import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 */

// @lc code=start
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(n,k,1,new ArrayList<>());
        return ans;
        
    }

    void dfs(int n, int k, int num, List<Integer> path){

        if(path.size() == k){
            ans.add(new ArrayList<Integer>(path));
            return;
        }


        //如果for循环选择的起始位置之后的元素个数 已经不足 我们需要的元素个数了，那么就没有必要搜索了
        for(int i = num; i <= n - (k - path.size()) + 1; i++) {
          
        // for(int i = num; i <= n; i++) {
            path.add(i);
            dfs(n,k,i+1, path);
            path.remove(path.size()-1);
        }
    }
}
// @lc code=end

