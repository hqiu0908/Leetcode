/*

Given a singly linked list where elements are sorted in ascending order, convert
it to a height balanced BST.

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Top-down recursion: O(n log n) runtime, O(log n)
// Each level of recursive call requires a total of n / 2￼ traversal steps in
// the list (traverse to find the middle element)

// O(n) runtime, O(log n) stack space – Bottom-up recursion
// access the lists in order while creating tree nodes
public class Solution {
    private ListNode current;
    
    private int getLength(ListNode head) {
        int size = 0;
        
        while (head != null) {
            size++;
            head = head.next;
        }
        
        return size;
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        current = head;
        
        int size = getLength(head);
        return buildBST(size);
    }  

    // create tree nodes by the list order
    private TreeNode buildBST(int size) {
        if (size <= 0) {
            return null;
        }
        
        TreeNode left = buildBST(size / 2);
        
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        
        TreeNode right = buildBST(size - 1 - size / 2);
        
        root.left = left;
        root.right = right;
        
        return root;
    }
}
