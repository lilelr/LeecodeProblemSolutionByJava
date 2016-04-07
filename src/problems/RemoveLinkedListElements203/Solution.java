package problems.RemoveLinkedListElements203;

/**
 * Created by yuxiao on 4/7/16.
 */



public class Solution {

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    public ListNode removeElements(ListNode head, int val) {
        if(head==null) return null;
        while (head!=null &&head.val == val){
            ListNode tmphead = head;
            head = head.next;
            tmphead.next=null;
        }
        if(head==null) return null;
        ListNode pre = head;
        while (pre.next!=null){
            if(pre.next.val == val){
                ListNode p = pre.next;
                pre.next = p.next;
            }else {
                pre = pre.next;
            }
        }
        return head;
    }
}