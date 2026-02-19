/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null || head.next==null)
        return null;
        int cnt=countNode(head);
        //System.out.println(cnt);
        if(cnt+1==n){
            return head.next;
        }
        int l=cnt-n;
        ListNode curr=head;
        for(int i=0;i<l;i++){
            curr=curr.next;
        }
        if(n==1){
            curr.next=null;
            return head;
        }
        else{
            curr.next=curr.next.next;
        }
        return head;
    }
    public int countNode(ListNode head){
        int count=0;
        while(head.next!=null){
            count++;
            head=head.next;
        }
        return count;
    }
}