import java.util.List;

/*
 * @lc app=leetcode id=101 lang=java
 *
 * [101] Symmetric Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
       
        return way1(root);
    }


    boolean way1(TreeNode root) {
        if(root == null) return false;
        return check(root.left,root.right);
    }

    boolean check(TreeNode l,TreeNode r) {
        if(l == null && r == null) return true;
        if(l == null || r == null) return false;

        if(l.val != r.val) return false;
        return check(l.left,r.right) && check(r.left, l.right);
    }



    //try inorde trave thought tere .not work
    boolean wayBad1(TreeNode root) {
        if(root == null) return false;
        if(root.left != null && root.right != null && root.left.val != root.right.val) return false;
        
        List<Integer> left = new ArrayList();
        List<Integer> right = new ArrayList();
        inorder(root.left, left);
        inorder(root.right, right);
        if(left.size() != right.size()) return false;

        int l = left.size();
        for(int i = 0; i<l; i++){
            if(left.get(i) != right.get(l-1 - i)){
                return false;
            }
        }
        return true;
    }

    void inorder(TreeNode root, List<Integer> list) {
        if(root == null) return;
        if(root.left != null) inorder(root.left, list);
        list.add(root.val);
        if(root.right != null) inorder(root.right, list);
    }
}
// @lc code=end

