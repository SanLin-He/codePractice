/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        int sum = 0;
        ListNode head = new ListNode();
        ListNode ans = new ListNode();
        head.next = ans;
        while(l1 != null || l2 != null|| carry > 0) {
            ans.next = new ListNode();
            int a = l1 == null ? 0:l1.val;
            int b = l2 == null ? 0:l2.val;
            sum = a + b + carry;
            ans.next.val = sum%10;
            carry = sum /10;
            l1 = l1 == null ? null:l1.next;
            l2 = l2 == null ? null:l2.next;
            ans = ans.next;
            
        }
        return head.next.next;
    }
}
// @lc code=end

