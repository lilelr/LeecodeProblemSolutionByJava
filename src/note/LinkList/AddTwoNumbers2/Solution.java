package note.LinkList.AddTwoNumbers2;

import org.junit.Test;

/**
 * Created by yuxiao on 8/9/16.
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;

        if (l2 == null) {
            return l1;
        } else if (l1 == null) {
            return l2;
        }


        ListNode firstNode = new ListNode(0);
        int firstVal = l1.val + l2.val;
        int preVal = firstVal / 10;
        int curVal = firstVal % 10;
        firstNode.val = curVal;
        ListNode p = firstNode;
        l1 = l1.next;
        l2 = l2.next;
        int val;
        while (l1 != null && l2 != null) {
            val = preVal + l1.val + l2.val;
            preVal = val / 10;
            curVal = val % 10;
            ListNode newNode = new ListNode(curVal);
            p.next = newNode;
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 != null) {
            while (l1 != null) {
                val = preVal + l1.val;
                preVal = val / 10;
                curVal = val % 10;
                ListNode newNode = new ListNode(curVal);
                p.next = newNode;
                p = p.next;
                l1 = l1.next;
            }
        }

        if (l2 != null) {
            while (l2 != null) {
                val = preVal + l2.val;
                preVal = val / 10;
                curVal = val % 10;
                ListNode newNode = new ListNode(curVal);
                p.next = newNode;
                p = p.next;
                l2 = l2.next;
            }
        }
        if (preVal != 0) {
            ListNode newNode = new ListNode(preVal);
            newNode.next = null;
            p.next = newNode;

        } else {
            p.next = null;
        }
        return firstNode;
    }

    @Test
    public void test() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
//        l1.next.next = new LinkList(3);
        l1.next.next = new ListNode(9);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
//        l2.next.next = new LinkList(4);

        ListNode head = addTwoNumbers(l1, l2);

    }
}
