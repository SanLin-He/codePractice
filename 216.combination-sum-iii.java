import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=216 lang=java
 *
 * [216] Combination Sum III
 */

// @lc code=start
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    int nums = 9;
    int target = 0;
    int length = 0;
    public List<List<Integer>> combinationSum3(int k, int n) {
        length = k;
        target = n;
        dfs(target, 1, new ArrayList<>());
        return ans;
    }

    void dfs(int target ,int num, List<Integer>path){

        if(path.size() == length){
            if ( target == 0)ans.add(new ArrayList<>(path));

            return;
        }

        //样，for循环的范围也可以剪枝，i <= 9 - (k - path.size()) + 1就可以了,
        //因为长度是有要求的，小于这个长度就不用再穷举了
        for(int i = num; i <=nums-(length - path.size()) + 1; i++){
            if(i>target) return;//有序可以return，break， 无序 continue
            path.add(i);
            dfs(target-i,i+1,path);
            path.remove(path.size()-1);
        }
    }
}
// @lc code=end

