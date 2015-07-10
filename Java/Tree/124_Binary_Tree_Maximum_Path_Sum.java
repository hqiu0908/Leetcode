/*

Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.

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
public class Solution {
    /*
    
    Bottom up approach. At each node, the potential maximum path could be one of these cases:
    i. max(left subtree) + node
    ii. max(right subtree) + node
    iii. max(left subtree) + max(right subtree) + node (Don't forget!!!)
    iv. the node itself
    
    i, ii, iv) the path ends at this node -> max(node.val, node.val + max(node.left, node.right))
    iii) the path goes through this node -> node.val+ node.left + node.right

    Use DFS.
    
    */
    private int maxPassByNode = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        getMaxPathSum(root);
        return maxPassByNode;
    }
    
    private int getMaxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = getMaxPathSum(root.left);
        int right = getMaxPathSum(root.right);
        
        int maxEndByNode = Math.max(root.val, root.val + Math.max(left, right));
        maxPassByNode = Math.max(maxPassByNode, maxEndByNode);
        
        maxPassByNode = Math.max(maxPassByNode, root.val + left + right);

        return maxEndByNode;
    }
}
