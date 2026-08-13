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
       ListNode temp = head;
        ListNode prevnode=null;
        while(temp!=null){
            ListNode kthnode=findKthNode(temp,k);
            if(kthnode == null){
                if(prevnode != null) prevnode.next=temp;
                break;
            }
            ListNode nextnode=kthnode.next;
            kthnode.next=null;
            ListNode newhead=reverse(temp);
            if(temp == head){
                head=newhead;
            }else{
                prevnode.next=newhead;
            }

            prevnode=temp;
            temp=nextnode;
        }
        return head;

    }

    public ListNode findKthNode(ListNode temp, int k) {
        k -= 1;
        while (temp != null && k > 0) {
            temp = temp.next;
            k--;
        }
        return temp;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode temp = head;
        while (temp != null) {
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
}