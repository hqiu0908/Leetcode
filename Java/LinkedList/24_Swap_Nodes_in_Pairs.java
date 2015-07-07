/*

Given a linked list, swap every two adjacent nodes and return its head.

For example, Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in
the list, only nodes itself can be changed.

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prev = dummy;
        ListNode curt = head;
        while (curt != null && curt.next != null) {
            ListNode next = curt.next;
            prev.next = curt.next;
            curt.next = next.next;
            next.next = curt;
            prev = curt;
            curt = curt.next;
        }
        
        return dummy.next;
    }
}

// Simplified:

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        
        while (head != null && head.next != null) {
            ListNode next = head.next.next;
            prev.next = head.next;
            head.next.next = head;
            head.next = next;
            prev = head;
            head = next;
        }
        
        return dummy.next;
    }
}


