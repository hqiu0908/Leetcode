/*

A linked list is given such that each node contains an additional random pointer
which could point to any node in the list or null.

Return a deep copy of the list.

*/

// Method 1: Modify original structure

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
// 1) copy every node and insert it in between two orig nodes
// 2) copy random pointers for all newly created nodes
// 3) split the list, the orig shouldn't be changed
// O(n) runtime, O(1) space
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        
        copyListNode(head);
        copyRandomPtr(head);
        return deleteOrigNode(head);
    }
    
    private void copyListNode(RandomListNode head) {
        // Since head doesn't change, no need to use dummy node
        while (head != null) {
            RandomListNode node = new RandomListNode(head.label);
            node.next = head.next;
            head.next = node;
            head = node.next;
        }
    }
    
    private void copyRandomPtr(RandomListNode head) {
        while (head != null) {
            // random ptr could be null
            if (head.random != null) {
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
    }
    
    private RandomListNode deleteOrigNode(RandomListNode head) {
        RandomListNode dummy = new RandomListNode(0);
        dummy.next = head.next;  
        
        // next pointer of the original list shouldn't be modified
        while (head != null) {
            RandomListNode temp = head.next;
            head.next = head.next.next;
            head = head.next;
            // should check if temp.next is null
            if (temp.next != null) {
                temp.next = temp.next.next;
            }
        }
        
        return dummy.next;
    }
}


// Method 2: Use HashMap
