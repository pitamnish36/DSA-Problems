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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || k==1){
            return head;
        }

        ListNode dummy=new ListNode(0);
        ListNode curr=head;
        ListNode prevGroupEnd=dummy;
        dummy.next=head;

        int cnt=0;
        ListNode temp=head;
        while(head!=null){
            head=head.next;
            cnt++;
        }
        
        while(cnt>=k){
            ListNode prev=null;
            ListNode groupStart=curr;

            for(int i=0;i<k;i++){
                ListNode next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }

            prevGroupEnd.next=prev;
            groupStart.next=curr;
            prevGroupEnd=groupStart;
            cnt-=k;
        }

        return dummy.next;
    }
}