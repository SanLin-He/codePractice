/*
 * @lc app=leetcode id=237 lang=java
 *
 * [237] Delete Node in a Linked List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {

        //自己伪装成儿子，再抛弃儿子，指向孙子
        node.val = node.next.val;
        node.next = node.next.next;

    }
}
// @lc code=end
