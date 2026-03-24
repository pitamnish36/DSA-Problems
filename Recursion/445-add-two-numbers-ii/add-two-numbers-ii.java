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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1=reverse(l1);
        l2=reverse(l2);
        int carry=0;
        ListNode dummy=new ListNode(0);
        ListNode current=dummy;
        while(l1!=null || l2!=null){
            int digit;
            if(l1!=null && l2!=null){
                digit=l1.val+l2.val+carry;
                l1=l1.next;
                l2=l2.next;
            }
            else if(l1!=null){
                digit=l1.val+carry;
                l1=l1.next;
            }
            else{
                digit=l2.val+carry;
                l2=l2.next;
            }
            carry=digit/10;
            digit=digit%10;
            ListNode node=new ListNode(digit);
            current.next=node;
            current=current.next;
        }
        if(carry!=0){
            ListNode node=new ListNode(carry);
            current.next=node;
        }
        // while(dummy.val==0){
        //     dummy=dummy.next;
        // }
        return reverse(dummy.next);
    }
    public static ListNode reverse(ListNode node){
        if(node==null || node.next==null){
            return node;
        }
        ListNode prev=null;
        ListNode current=node;
        ListNode nextE=node.next;
        while(current.next!=null){
            current.next=prev;
            prev=current;
            current=nextE;
            nextE=current.next;
        }
        current.next=prev;
        return current;
    }
}