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
    private  TreeNode first = null;
    private  TreeNode last = null;
    private  TreeNode prev = null;
    private  TreeNode next = null;

    public void change(){
         if(prev.val > next.val)
        {
            if(first == null)  first = prev;
            last = next;
        }
    }

    public  void traversalHelper(TreeNode root){
        if(root == null) return;
        
        while(root != null){
            next = root;
            if(root.left != null){
                TreeNode curr = root.left;
                while(curr.right != null  && curr.right != root) curr = curr.right;

                if(curr.right == null){
                    curr.right = root;
                    root = root.left;
                }else{
                    curr.right = null;
                    change();
                    root = root.right;
                    prev = next;
                }
            }else{

                if(prev == null) prev = root;
                else change();
                root = root.right;
                prev = next;
            }
        }
    }

    public void swapped(){
        if(first == null || last == null) return;
        int temp = first.val;
        first.val = last.val;
        last.val = temp;
    }

    public void recoverTree(TreeNode root) {
        traversalHelper(root);
        swapped();
    }
}
