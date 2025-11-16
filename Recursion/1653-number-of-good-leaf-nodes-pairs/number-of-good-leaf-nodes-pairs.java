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
    int ans=0;
    public int countPairs(TreeNode root, int distance) {
        postOrderDfs(root,distance); //post order tarversal
        return ans;
    }
    
    public int[] postOrderDfs(TreeNode root,int distance){
        int[] dists=new int[distance+1];
        if(root==null){  // either right or left node is leaf node
            return dists;
        }
        if(root.left==null && root.right==null){ //leaf node
            dists[0]=1;
            return dists;
        }
        int []left=postOrderDfs(root.left,distance); //left traversal
        int []right=postOrderDfs(root.right,distance); //right tarversal

        //calulation on root node with info from left and right node
        for(int i=0;i<distance;i++){
            for(int j=0;j<distance;j++){
                if(i+j+2<=distance){  // +2 because both left and right arrays are 0-index
                    ans+=left[i]*right[j];
                }
            }
        }

        for(int k=0;k<distance;k++){  //array preparation for upper nodes
            dists[k+1]=left[k]+right[k];
        }
        return dists;
    }
}