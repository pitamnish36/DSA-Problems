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
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null)
        return true;
        ListNode mid=getMid(head);
        ListNode firstHalf=head;
        ListNode secondHalf=mid.next;
        mid.next=null;
        secondHalf=(secondHalf.next!=null?reverse(secondHalf):secondHalf);
        //System.out.println(secondHalf.val);
        //ListNode reverseHead=reverse(head);
        //System.out.println("Head"+reverseHead.val);
        while(secondHalf!=null){
            if(firstHalf.val!=secondHalf.val){
                return false;
            }
            firstHalf=firstHalf.next;
            secondHalf=secondHalf.next;
        }
        return true;
    }
    public ListNode getMid(ListNode head){
        ListNode fast=head;
        ListNode slow=head;
        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        ListNode nxt=head.next;
        while(curr!=null){
            curr.next=prev;
            prev=curr;
            curr=nxt;
            nxt=nxt!=null?nxt.next:null;
        }
        ListNode temp=curr;
        return prev;
    }
}