import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=118 lang=java
 *
 * [118] Pascal's Triangle
 */

// @lc code=start
class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        return way1(numRows);
    }

    //错位相加
    public List<List<Integer>> way1(int numRows) {
        if(numRows < 1 || numRows > 30) return null;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        ans.add(row1);
        for(int i = 2; i <=numRows; i++){
            List<Integer> preRow = ans.get(i -2);
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for(int j = 0; j < i-2; j++){
                row.add(preRow.get(j) + preRow.get(j+1));
            }
            row.add(1);
            ans.add(row);

        }


        return ans;
        
    }
}
// @lc code=end

