package problems.InsertionSortList147;

/**
 * Created by yuxiao on 4/9/16.
 */
public class Solution {

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //O(n^2)   List Sort
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode beginNode = new ListNode(0);
        beginNode.next = head;
        ListNode p = head.next;
        head.next = null;
        ListNode pre;
        while (p != null) {
            ListNode r = p;
            p = p.next;
            r.next = null;
            pre = beginNode;
            while (pre.next != null && pre.next.val <= r.val) {
                pre = pre.next;
            }
            r.next = pre.next;
            pre.next = r;
        }
        return beginNode.next;
    }

}
