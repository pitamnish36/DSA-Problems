/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node newHead=null;
        Node current=head;
        Node newCurrent=null;
        HashMap<Node,Node> map=new HashMap<>();
        while(current!=null){
            Node newNode=new Node(current.val);
            map.put(current,newNode);
            if(newHead==null){
                newHead=newNode;
                newCurrent=newHead;
            }
            else{
                newCurrent.next=newNode;
                newCurrent=newCurrent.next;
            }
            current=current.next;
        }
        newCurrent=newHead;
        current=head;
        while(newCurrent!=null){
            if(current.random!=null)
            newCurrent.random=map.get(current.random);
            else
            newCurrent.random=null;
            newCurrent=newCurrent.next;
            current=current.next;
        }
        return newHead;
    }
}