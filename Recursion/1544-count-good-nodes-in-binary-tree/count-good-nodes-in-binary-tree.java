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
    public int goodNodes(TreeNode root) {
        return goodCount(root,root.val);
    }
    public static int goodCount(TreeNode root,int curMax){
        if(root==null)
        return 0;
        int count=0;
        if(root.val>=curMax){
            count++;
            curMax=root.val;
        }
        return count+goodCount(root.left,curMax)+goodCount(root.right,curMax);
    }
}