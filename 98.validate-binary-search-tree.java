import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
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
    public boolean isValidBST(TreeNode root) {
        // return way1(root);
        return way2(root);

    }

    long pre = Long.MIN_VALUE; // 记录上一个节点的值，初始值为Long的最小值
    boolean way2(TreeNode root) {
        return inorder2(root);
    }

    // 中序遍历
    private boolean inorder2(TreeNode node) {
        if (node == null)
            return true;
        boolean l = inorder2(node.left);
        if (node.val <= pre)
            return false;
        pre = node.val;
        boolean r = inorder2(node.right);
        return l && r;
    }

    boolean way1(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        inorder(root, nodes);

        for (int i = 0; i < nodes.size() - 1; i++) {
            if (nodes.get(i).val >= nodes.get(i + 1).val) {
                return false;
            }
        }
        return true;

    }

    void inorder(TreeNode root, List<TreeNode> nodes) {
        if (root == null)
            return;

        if (root.left != null)
            inorder(root.left, nodes);
        nodes.add(root);
        if (root.right != null)
            inorder(root.right, nodes);

    }
}
// @lc code=end
