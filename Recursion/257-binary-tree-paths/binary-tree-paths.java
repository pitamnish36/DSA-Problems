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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result=new ArrayList<>();
        helper(root,result,"");
        return result;
    }
    public static void helper(TreeNode root,List<String> result,String path){
        if(root.left==null && root.right==null){
            path=path+String.valueOf(root.val);
            result.add(new String(path));
            return;
        }
        path=path+String.valueOf(root.val)+"->";
        if(root.left!=null)
        helper(root.left,result,path);
        //path.substring(0,path.length()-3);
        //path=path+String.valueOf(root.)
        if(root.right!=null)
        helper(root.right,result,path);
    }
}