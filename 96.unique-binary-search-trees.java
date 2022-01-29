/*
 * @lc app=leetcode id=96 lang=java
 *
 * [96] Unique Binary Search Trees
 */

// @lc code=start


// 假设 n 个节点存在二叉排序树的个数是 G (n)，令 f(i) 为以 i 为根的二叉搜索树的个数，则
// G(n)=f(1)+f(2)+f(3)+f(4)+...+f(n)
// 当 i 为根节点时，其左子树节点个数为 i-1 个，右子树节点为 n-i，则
// f(i)=G(i−1)∗G(n−i)

// 综合两个公式可以得到 卡特兰数 公式
// G(n)=G(0)∗G(n−1)+G(1)∗(n−2)+...+G(n−1)∗G(0)




//递归公式：dp[i] += dp[j - 1] * dp[i - j]
class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            //选一个数作为root，BST 中序遍历的思想
            //那么左边有m-1个数，有dp[m-1]钟BST,
            //右边有i-m个数，有dp[i-m]种BST
            for(int m = 1; m <= i;m++){
                dp[i] += dp[m-1]*dp[i-m];
            }
        }
        
        return dp[n];
    }

}


class Solution1 {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){//节点个数
            //选一个数作为root，BST 中序遍历的思想
            //那么左边有m-1个数，有dp[m-1]种BST,
            //右边有i-m个数，有dp[i-m]种BST
            for(int m = 1; m <= i;m++){//顶点节点
                dp[i] += dp[m-1]*dp[i-m];
            }
        }
        
        return dp[n];
    }

}
// @lc code=end

