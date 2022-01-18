import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=104 lang=java
 *
 * [104] Maximum Depth of Binary Tree
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
    public int maxDepth(TreeNode root) {
        // return way1(root);//better;
        return way2(root);
    }

    int way1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.right == null && root.left == null)
            return 1;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    int way2(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        int size = 0;
        while (!queue.isEmpty()) {
            size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                size--;
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            level++;

        }
        return level;
    }
}
// @lc code=end
