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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)
        return false;
        return checkPathSum(root,targetSum,0);
    }
    public boolean checkPathSum(TreeNode root,int targetSum,int currentSum){
        currentSum+=root.val;
        if(root.left==null && root.right==null){
            if(targetSum==currentSum)
            return true;
        }
        boolean leftcheck=false;
        boolean rightcheck=false;
        if(root.left!=null)
            leftcheck=checkPathSum(root.left,targetSum,currentSum);
        if(root.right!=null)
            rightcheck=checkPathSum(root.right,targetSum,currentSum);
        return (leftcheck || rightcheck);
    }
}