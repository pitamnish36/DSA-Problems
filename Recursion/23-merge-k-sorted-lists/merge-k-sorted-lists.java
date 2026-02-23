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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0 || (lists.length==1 && lists[0]==null))
        return null;
        ListNode merged=new ListNode(0);
        ListNode result=merged;
        while(true){
            boolean nullCheck=true;
            int idx=0;
            int temp=10001;
            for(int i=0;i<lists.length;i++){
                if(lists[i]!=null && lists[i].val<temp){
                    idx=i;
                    temp=lists[i].val;
                    nullCheck=false;
                }
            }
            merged.next=lists[idx];
            merged=merged.next;
            if(nullCheck)
            break;
            lists[idx]=lists[idx].next;
        }
        return result.next;
    }
}