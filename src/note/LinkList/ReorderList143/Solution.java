package note.LinkList.ReorderList143;

import org.junit.Test;

/**
 * Created by yuxiao on 16/4/12.
 * https://leetcode.com/problems/reorder-list/
 */
public class Solution {
    /**
     * Given {1,2,3,4}, reorder it to {1,4,2,3}.
     */

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode midNode(ListNode head) {
        ListNode p = head, r = head;
        while (p != null && r != null && p.next != null && r.next != null && r.next.next != null) {
            p = p.next;
            r = r.next.next;
        }
        return p;
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;

        ListNode midNode = midNode(head);
        ListNode secondTail = midNode.next;
        midNode.next = null;

        ListNode secondHead = secondTail.next;
        ListNode secondPre = secondTail;
        secondTail.next = null;
        while (secondHead != null) {
            ListNode tmpNode = secondHead.next;
            secondHead.next = secondPre;
            secondPre = secondHead;
            secondHead = tmpNode;
        }
        secondHead = secondPre;

        ListNode headP = head;
        ListNode sp, sr;
        while (headP != null && secondHead != null) {
            sp = headP.next;
            sr = secondHead.next;
            headP.next = secondHead;
            secondHead.next = sp;
            headP = sp;
            secondHead = sr;
        }
    }


    @Test
    public void testReOrderList() {
        ListNode head = new ListNode(1);
        ListNode sec = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode forth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        head.next = sec;
        sec.next = third;
        third.next = forth;
        forth.next = fifth;
        reorderList(head);

    }
}
