/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        
        int leftHeight = getHeight(root, true);
        int rightHeight = getHeight(root, false);
        
        if (leftHeight == rightHeight) {
            // Perfect binary tree
            return (1 << leftHeight) - 1;
        } else {
            // Not perfect, so recurse
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
    
    private int getHeight(TreeNode node, boolean left) {
        int height = 0;
        while (node != null) {
            height++;
            node = left ? node.left : node.right;
        }
        return height;
    }
}