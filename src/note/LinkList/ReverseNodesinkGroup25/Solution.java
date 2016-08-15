package note.LinkList.ReverseNodesinkGroup25;

import org.junit.Test;

/**
 * Created by yuxiao on 8/15/16.
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 */

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 0) return head;
        if (head==null) return null;
        if(head.next==null) return head;

        ListNode dumb = new ListNode(0);
        dumb.next = head;
        ListNode p = dumb;
        int len = 0;
        while (p.next != null) {
            len++;
            p = p.next;
        }


        int rounds = len / k;
        ListNode pre = dumb;
        p = dumb;
        if(k==1){
            p = head;
            while (p!=null){
                ListNode r = p.next;
                p.next = pre ;
                pre = p;
                p = r;
            }
            head.next = null;
            return pre;
        }

        ListNode newHead = head;
        for (int i = 0; i < rounds; i++) {
            int j = 0;
            ListNode saveP = p;
            ListNode saveHead = p.next;
            ListNode r = null;
            while (j < k) {
                if (j == 0) {
                    p = p.next;
                } else if (j == 1) {
                    p = p.next;
                    pre = pre.next;
                } else {
                    r = p.next;
                    p.next = pre ;
                    pre = p;
                    p = r;
                }
                j++;
            }
            if (j == k) {
                r = p.next;
                p.next = pre ;
                if (i == 0) {
                    newHead = p;
                }else {
                    int b=4;
                    saveP.next = p;
                }
                saveHead.next = r;
                p = saveHead;
                pre = p;
            }
        }
        return newHead;
    }

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        ListNode sec = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode forth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(6);
        ListNode seventh = new ListNode(7);
        head.next = sec;
        sec.next = third;
        third.next = forth;
        forth.next = fifth;
        fifth.next = sixth;
        sixth.next =seventh;

//        ListNode newHead = reverseKGroup(head, 2);
        ListNode newHead = reverseKGroup(head,  1);
        while (newHead!=null){
            System.out.println(newHead.val);
            newHead = newHead.next;
        }

    }
}