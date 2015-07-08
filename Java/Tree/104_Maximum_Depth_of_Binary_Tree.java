/*

Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root
node down to the farthest leaf node.

*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// O(n) runtime, O(log n) space – Recursion
public class Solution {
    
    // Max depth of a tree = max (depth of left child, 
    // depth of right child) + 1
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
     
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}