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
    int preIndex=0;
    Map<Integer,Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int idx=0;
        for(int x:inorder){
            map.put(x,idx++);
        }
        return build(preorder,0,inorder.length-1);
    }
    public TreeNode build(int[] preorder,int start,int end){
        if(start>end){
            return null;
        }
        int rootval=preorder[preIndex++];
        int mid=map.get(rootval);
        TreeNode node=new TreeNode(rootval);
        node.left=build(preorder,start,mid-1);
        node.right=build(preorder,mid+1,end);

        return node;
    }
}