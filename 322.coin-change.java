import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 */

// @lc code=start
class Solution {
    List<List<Integer>> ways = new ArrayList<>();

    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;


            

        return 0;
    }



    /*
    ******not work******
    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;

        Arrays.sort(coins);
        dfs(amount, coins, new ArrayList<>(), coins.length - 1);
        if (ways.size() == 0)
            return -1;

        List<Integer> out = ways.get(0);
        return out.size();
    }
    void dfs(int amount, int[] choice, List<Integer> out, int len) {

        if (ways.size() == 1)
            return;
        if (amount == 0) {
            ways.add(new ArrayList<>(out));
            return;
        }

        for (int i = len; i >= 0; i--) {// 每个节点，即每层分支个数
            if (ways.size() == 1)
                return;

            if (choice[i] > amount)
                continue;
            out.add(choice[i]);
            dfs(amount - choice[i], choice, out, i);
            out.remove(out.size() - 1);

        }

    }
    */
}
// @lc code=end
