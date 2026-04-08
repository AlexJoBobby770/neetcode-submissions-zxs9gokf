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
        ListNode temp=head;
        int count=0;
        while(temp!=null)
        {
            temp=temp.next;
            count++;
        }
        temp=head;
        int m=count-n;
        if (n == count) {
            return head.next;
        }
        while(temp.next!=null)
        {
            ListNode prev=temp;
            temp=temp.next;
            if(--m==0)
            {
                prev.next=temp.next;
            }
        }
    return head;
    }
}
