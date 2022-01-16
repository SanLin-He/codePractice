import java.util.LinkedList;
import java.util.Stack;

/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
     
        return way1(head, n);
    }

    ListNode way1(ListNode head, int n){
        ListNode fast = head;
        ListNode ans = new ListNode();
        ans.next = head;
        ListNode slow = ans;
        for(int i = 0; i < n; i++){
            fast = fast.next;
        }
        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

     
        return ans.next;
    }

    ListNode way2(ListNode head, int n){

        Stack<ListNode> stack = new Stack<>();
        ListNode dummy = new ListNode();
        ListNode node = new ListNode();
        dummy.next = head;
        node = dummy;
        while(node != null){
            stack.push(node);
            node = node.next;
        }
        for(int i =0;i <=n; i++){
            node = stack.pop();
        }
        node.next = node.next.next;


     
        return dummy.next;
    }
}
// @lc code=end

