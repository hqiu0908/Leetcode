/*

You are given two linked lists representing two non-negative numbers. The digits
are stored in reverse order and each of their nodes contain a single digit. Add
the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) 

Output: 7 -> 0 -> 8

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        
        if (l2 == null) {
            return l1;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        int carry = 0;
        
        while (l1 != null || l2 != null || carry != 0) {
            int val = carry;
            
            if (l1 != null) {
                val += l1.val;
                l1 = l1.next;
            }
            
            if (l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }
            
            head.next = new ListNode(val % 10);
            carry = val / 10;
            head = head.next;
        }
        
        return dummy.next;
    }
}
