/*

Merge k sorted linked lists and return it as one sorted list. Analyze and
describe its complexity.

*/

/*

1. Merge two sorted list, O(nk^2)
If make use of this -> Time Limit Exceeded -> O(n(2 + 3 + ... k)) = O(nk^2)

2. Use a PriorityQueue -> O(nklogk) The elements of the priority queue are
ordered according to their natural ordering,  or by a Comparator provided at
queue construction time (in this case).

Keep a heap(PriorityQueue) of size k. Initialize the heap with the head of the k
linked list. Everytime choose the smallest node from the queue and insert into
the result linked list,  and put the next node of this smallest node into the
queue. When the queue is empty, all the nodes have been inserted into the queue.

3. Divide and conquer -> O(nklog k) runtime, O(1) space

*/

// Method 1: Use Priority Queue

// Method 2: Divide and Conquer

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// O(nklog k) runtime, O(1) space
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        return divideAndConquer(lists, 0, lists.length - 1);
    }
    
    private ListNode divideAndConquer(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        
        int mid = start + (end - start) / 2;
        ListNode left = divideAndConquer(lists, start, mid);
        ListNode right = divideAndConquer(lists, mid + 1, end);
        
        return mergeTwoSortedLists(left, right);
    }
    
    private ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        
        if (l2 == null) {
            return l1;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            
            head = head.next;
        }
        
        if (l1 != null) {
            head.next = l1;
        }
        
        if (l2 != null) {
            head.next = l2;
        }
        
        return dummy.next;
    }
}
