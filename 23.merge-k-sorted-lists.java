/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
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
    // public ListNode mergeKLists(ListNode[] lists) {
    //     if (lists.length == 0)
    //         return null;
    //     ListNode dummy = new ListNode(-1);
    //     ListNode minHead = getMinHead(lists);
    //     if (minHead.val < Integer.MAX_VALUE)
    //         dummy.next = minHead;
    //     while (minHead.val < Integer.MAX_VALUE) {
    //         ListNode node = getMinHead(lists);
    //         if (node.val < Integer.MAX_VALUE)
    //             minHead.next = node;
    //         minHead = node;
    //     }
    //     return dummy.next;

    // }

    // ListNode getMinHead(ListNode[] lists) {
    //     ListNode minHead = new ListNode(Integer.MAX_VALUE);
    //     int k = 0;
    //     for (int i = 0; i < lists.length; i++) {
    //         if (lists[i] == null)
    //             continue;
    //         if (lists[i].val < minHead.val) {
    //             minHead = lists[i];
    //             k = i;
    //         }
    //     }
    //     if (lists[k] != null)
    //         lists[k] = lists[k].next;
    //     return minHead;
    // }

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPtr);
        return head.next;
    }

}
// @lc code=end
