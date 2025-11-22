/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> result =new ArrayList<>();
        if(root==null){
            return result;
        }
        while(!queue.isEmpty()){
            int n=queue.size();
            List<Integer> subList=new ArrayList<>();
            for(int i=0;i<n;i++){
                Node node=queue.poll();
                subList.add(node.val);
                queue.addAll(node.children);
            }
            result.add(subList);
        }
        return result;
    }
}