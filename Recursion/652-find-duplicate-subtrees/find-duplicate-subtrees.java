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
    private HashMap<String,Integer> freq;
    private List<TreeNode> result;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        freq=new HashMap<>();
        result=new ArrayList<>();
        serialize(root);
        return result;
    }
    public String serialize(TreeNode root){
        if(root==null){
            return "#";
        }
        String left=serialize(root.left);
        String right=serialize(root.right);
        String key=root.val+","+left+","+right;
        int count=freq.getOrDefault(key,0);
        if(count==1){
            result.add(root);
        }
        freq.put(key,count+1);
        return key;
    }
}