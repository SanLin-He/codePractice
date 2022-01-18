/*
 * @lc app=leetcode id=206 lang=java
 *
 * [206] Reverse Linked List
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
    public ListNode reverseList(ListNode head) {
        
    
        return way1(head);
    }
    ListNode way2(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;

        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur=next;
            
        }
        return pre;  
    }

    ListNode revser(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;

        revser(head.next)
        return pre;  
    }

    ListNode way1(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;

        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur=next;
            
        }
        return pre;  
    }
}
// @lc code=end

