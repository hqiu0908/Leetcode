/*

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's
key. The right subtree of a node contains only nodes with keys greater than the
node's key. Both the left and right subtrees must also be binary search trees.

OJ's Binary Tree Serialization: 

The serialization of a binary tree follows a level order traversal, where '#'
signifies a path terminator where no node exists below.

Here's an example:
   1
  / \
 2   3
    /
   4
    \
     5
The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".

*/

// Method 1: Top-down recursion

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// O(n) runtime, O(n) space
public class Solution {
    public boolean isValidBST(TreeNode root) {
        // corner case: tree contains Integer.MIN_VALUE or Integer.MAX_VALUE
        // return validateBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE); --> wrong
        // fix: use null to represent the infinity!!

        return validateBST(root, null, null);
    }
    
    // Use Integer instead of int!!
    private boolean validateBST(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        
        // Use null to represent the infinity!!
        return (min == null || root.val > min) && (max == null || root.val < max)
            && validateBST(root.left, min, root.val) 
            && validateBST(root.right, root.val, max); 
    }
}

// Method 2: In-order traversal:

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// O(n) runtime, O(n) space
public class Solution {
    private TreeNode prev = null;
    
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        if (!isValidBST(root.left)) {
            return false;
        }
        
        if (prev != null && root.val <= prev.val) {
            return false;
        }
        prev = root;
        
        if (!isValidBST(root.right)) {
            return false;
        }
        
        return true;
    }
}
