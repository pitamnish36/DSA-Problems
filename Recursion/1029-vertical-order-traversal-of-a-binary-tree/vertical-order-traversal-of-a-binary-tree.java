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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> positions=new ArrayList<>();
        collectNode(root,positions,0,0);
        positions.sort((a,b)->{
            if(a[0]!=b[0]) return Integer.compare(a[0],b[0]);
            if(a[1]!=b[1]) return Integer.compare(a[1],b[1]);
            return Integer.compare(a[2],b[2]);
        });

        List<List<Integer>> result=new ArrayList<>();
        int prevCol=Integer.MIN_VALUE;

        for(int[] position:positions){
            int col=position[0],val=position[1];
            if(col!=prevCol){
                result.add(new ArrayList<>());
                prevCol=col;
            }
            result.get(result.size()-1).add(position[2]);
        }
        return result;
    }
    public void collectNode(TreeNode root,List<int[]> positions,int row,int col){
        if(root==null){
            return;
        }
        positions.add(new int[]{col,row,root.val});
        collectNode(root.left,positions,row+1,col-1);
        collectNode(root.right,positions,row+1,col+1);
    }
}