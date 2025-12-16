/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        StringBuilder s=new StringBuilder();
        if(root==null){
            return "";
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node =queue.poll();
            if(node!=null){
                s.append(node.val+",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
            else{
                s.append("null,");
            }
        }
        return s.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //System.out.println(data);
        if(data.equals("")){
            return null;
        }
        String[] tree=data.split(",");
        TreeNode root=new TreeNode(Integer.parseInt(tree[0]));
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int i=1;
        //return node;
        while(!queue.isEmpty() && i<tree.length){
            TreeNode node=queue.poll();
            if(!tree[i].equals("null")){
                node.left=new TreeNode(Integer.parseInt(tree[i]));
                queue.offer(node.left);
            }
            i++;
            if(i<tree.length && !tree[i].equals("null")){
                node.right=new TreeNode(Integer.parseInt(tree[i]));
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));