package note.twopoint.RotateList61;

import org.junit.Test;

/**
 * Created by yuxiao on 16/4/21.
 * https://leetcode.com/problems/rotate-list/
 */

public class Solution {

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) return head;

        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode pre = null;
        ListNode p = head;

        int len = 0;
        ListNode iterator = head;
        while (iterator != null) {
            iterator = iterator.next;
            len++;
        }
        k = k % len;
        if (k == 0) return head;
        k--;
        boolean flag = true;
        while (k > 0 && p != null) {
            p = p.next;
            if (flag) {
                pre = preHead;
                flag = false;
            } else {
                pre = pre.next;
            }

            k--;
        }
        if (p == null) {
            pre.next.next = head;

            head = pre.next;
            pre.next = null;
            return head;
        }
        if (p.next == null) return head;


        while (p.next != null) {
            preHead = preHead.next;
            p = p.next;
        }
        p.next = head;
        head = preHead.next;
        preHead.next = null;
        return head;
    }

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        ListNode sec = new ListNode(2);
        head.next = sec;
        head = rotateRight(head, 3);
    }
}