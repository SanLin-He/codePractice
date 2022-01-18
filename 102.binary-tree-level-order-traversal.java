import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null)
            return ans;
        Queue<TreeNode> que = new LinkedList<>();

        que.offer(root);
        int levelSize = 0;
        while (!que.isEmpty()) {
            levelSize = que.size();
            List<Integer> levelList = new LinkedList<>();
            ans.add(levelList);
            while (levelSize > 0) {
                TreeNode node = que.poll();
                levelList.add(node.val);
                levelSize--;
                if (node.left != null)
                    que.offer(node.left);
                if (node.right != null)
                    que.offer(node.right);

            }
        }

        return ans;

    }
}
// @lc code=end
