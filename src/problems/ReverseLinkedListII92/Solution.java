package problems.ReverseLinkedListII92;

import org.junit.Test;

/**
 * Created by yuxiao on 16/4/18.
 */
public class Solution {

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode pre = head;
        ListNode p = head.next;
        pre.next = null;
        while (p!=null){
            ListNode  s = p.next;
            p.next = pre;
            pre = p;
            p = s;
        }

        return pre;

    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null || head.next==null) return head;

        int tmplen = n-m;
        if(tmplen==0) return head;

        ListNode newHead = new ListNode(0);
        newHead.next = head;
        int i=1;
        ListNode pre = newHead;
        while (pre!=null && i<m){
            i++;
            pre=pre.next;
        }

        if(i==m){
            ListNode p = pre.next;
            ListNode s = p.next;
            ListNode tail = p;
            pre.next = null;
            while (s!=null && tmplen>0){
                ListNode  t = s.next;
                s.next = p;
                p = s;
                s = t;
                tmplen--;
            }

            pre.next = p;
            tail.next = s;
            return newHead.next;
        } else{
            return head;
        }

    }

    @Test
    public void test(){
        ListNode head = new ListNode(1);
        ListNode sec = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode forth = new ListNode(4);
        head.next = sec;
        sec.next = third;
        third.next= forth;
        head = reverseBetween(head,2,4);

    }

}
