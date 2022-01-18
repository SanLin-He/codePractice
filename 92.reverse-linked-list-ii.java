/*
 * @lc app=leetcode id=92 lang=java
 *
 * [92] Reverse Linked List II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        return way1(head, left, right);
    }

    ListNode way1(ListNode head, int left, int right) {
        if (left == right)
            return head;

        ListNode cur = head;
        ListNode pre = null;
        ListNode end = null;
        int pos = 1;
        while (cur != null) {
            if (left == pos + 1)
                pre = cur;
            if (right == pos) {
                end = cur;
                break;
            }

            cur = cur.next;
            pos++;
        }

        ListNode prStart = pre;
        ListNode start = prStart == null ? head : prStart.next;
        ListNode succ = end.next;

        // start -> end
        cur = start;
        ListNode next = null;
        while (cur != succ) {
            next = cur.next;

            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = succ;
        if (prStart != null)
            prStart.next = pre;
        else
            head = pre;

        return head;
    }

    ListNode way2(ListNode head, int left, int right) {
        if (left == right)
            return head;

        ListNode cur = head;
        ListNode pre = null;
        ListNode end = null;
        int pos = 1;
        while (cur != null) {
            if (left == pos + 1)
                pre = cur;
            if (right == pos) {
                end = cur;
                break;
            }

            cur = cur.next;
            pos++;
        }

        ListNode prStart = pre;
        ListNode start = prStart == null ? head : prStart.next;
        ListNode succ = end.next;

        // start -> end
        cur = start;
        ListNode next = null;
        while (cur != succ) {
            next = cur.next;

            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = succ;
        if (prStart != null)
            prStart.next = pre;
        else
            head = pre;

        return head;
    }


}
// @lc code=end
