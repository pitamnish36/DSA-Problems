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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        List<List<Integer>> result=new ArrayList<>();
        queue.offer(root);
        if(root==null){
            return result;
        }
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> sublist=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode temp=queue.poll();
                if(temp.left!=null)
                queue.offer(temp.left);
                if(temp.right!=null)
                queue.offer(temp.right);
                sublist.add(temp.val);
            }
            result.add(sublist);
        }
        return result;
    }
}