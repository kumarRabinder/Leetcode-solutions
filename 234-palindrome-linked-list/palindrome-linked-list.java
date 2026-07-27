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
    public ListNode reverse(ListNode head ){
        if(head == null || head.next == null){
            return head;
        }

        ListNode newhead = reverse(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;

        return newhead;
    }

    public boolean isPalindrome(ListNode head) {

        if(head == null || head.next == null)return true;
        //Step 1:
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //Step 2:
        ListNode newhead = reverse(slow.next);
        
        //Step 3:

        ListNode first = head;
        ListNode second = newhead;
        while(second != null){
            if(first.val != second.val){
                reverse(newhead);
                return false;
            }
            first=first.next;
            second=second.next;
        }
        reverse(newhead);
        return true;
    }
}