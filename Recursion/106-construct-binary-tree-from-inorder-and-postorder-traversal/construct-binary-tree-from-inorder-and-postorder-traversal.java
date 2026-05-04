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
    Map<Integer,Integer> map=new HashMap<Integer,Integer>();
    int postIdx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        postIdx=postorder.length-1;
        return build(postorder,0,inorder.length-1);
    }
    public TreeNode build(int[] postorder,int start,int end){
        if(start>end || postIdx<0){
            return null;
        }
        int root=postorder[postIdx--];
        int mid=map.get(root);
        TreeNode node=new TreeNode(root);
        node.right=build(postorder,mid+1,end);
        node.left=build(postorder,start,mid-1);
        return node;
    }
}