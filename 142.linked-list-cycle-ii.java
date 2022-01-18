import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=142 lang=java
 *
 * [142] Linked List Cycle II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
    //  return way1(head);
     //return way2(head);//better
     return way3(head);


    }

    public ListNode way3(ListNode head) {
        ListNode cur = head;
        Set<ListNode> visited = new HashSet<>();    
        while(cur != null){
          if(visited.contains(cur)){
              return cur;
          }
          visited.add(cur);
          cur = cur.next;
        }

        return null;

    }

    public ListNode way2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;     
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) {
                slow =head;
                fast = fast;
                while(slow != fast){
                    slow =slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        return null;

    }

    public ListNode way1(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle =false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) {
                hasCycle =true;
                break;
            }
        }

        if(hasCycle) {
            slow = head;
            while(slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }

        return null;
    }
}
// @lc code=end

