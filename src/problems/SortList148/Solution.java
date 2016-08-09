package problems.SortList148;

import org.junit.Test;

import java.util.List;

/**
 * Created by yuxiao on 4/8/16.
 */


public class Solution {
    /**
     * List Sort by quickSort
     */

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // return LinkList[4]
    // LinkList[0] -> start of smaller list, null if none
    // LinkList[1] -> start of pivot list (contains duplicates of pivot values)
    // LinkList[2] -> end of pivot list
    // LinkList[3] -> start of bigger list, null if none
    // Assume the input head must not be null, already check nullness in the caller
    private ListNode[] partition(ListNode head) {
        ListNode[] res = new ListNode[4];

        ListNode pivotLstStart = head;
        ListNode pivotLstEnd = pivotLstStart;

        ListNode smallLstStart = null;
        ListNode smallLstEnd = null;
        ListNode bigLstStart = null;
        ListNode bigLstEnd = null;

        for (ListNode node = head.next; node != null; node = node.next) {
            if (node.val < pivotLstStart.val) {
                if (smallLstStart == null)
                    smallLstStart = node;
                else
                    smallLstEnd.next = node;
                smallLstEnd = node;
            } else if (node.val > pivotLstStart.val) {
                if (bigLstStart == null)
                    bigLstStart = node;
                else
                    bigLstEnd.next = node;
                bigLstEnd = node;
            } else {
                pivotLstEnd.next = node;
                pivotLstEnd = node;
            }
        }

        // must terminate the smallLst and bigLst with null
        if (smallLstEnd != null)
            smallLstEnd.next = null;
        if (bigLstEnd != null)
            bigLstEnd.next = null;

        res[0] = smallLstStart;
        res[1] = pivotLstStart;
        res[2] = pivotLstEnd;
        res[3] = bigLstStart;

        return res;
    }

    // return LinkList[2]
    // LinkList[0] -> start non-null node of sorted list
    // LinkList[1] -> end non-null node of sorted list
    // Note that if none, both LinkList[0] and LinkList[1] are null
    // if there is only one node, LinkList[0]==LinkList[1]
    private ListNode[] quickSortList(ListNode head) {
        ListNode[] res = new ListNode[2];

        if (head == null)
            return res;

        ListNode[] partitionRes = partition(head);
        ListNode smallHead = partitionRes[0];
        ListNode pivotHead = partitionRes[1]; // pivotHead and pivotTail must exist
        ListNode pivotTail = partitionRes[2];
        ListNode bigHead = partitionRes[3];

        ListNode[] smallRes = quickSortList(smallHead);
        ListNode[] bigRes = quickSortList(bigHead);

        // Below code links the sorted smaller list, pivot list and sorted bigger list
        pivotTail.next = bigRes[0];
        res[1] = bigRes[1] == null ? pivotTail : bigRes[1];

        if (smallRes[0] == null) {
            res[0] = pivotHead;
        } else {
            res[0] = smallRes[0];
            smallRes[1].next = pivotHead;
        }
        return res;
    }

//    public LinkList sortList(LinkList head) {
//        return quickSortList(head)[0];
//    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode lh = new ListNode(0);
        ListNode rh = new ListNode(0);
        ListNode mh = new ListNode(0);
        ListNode lt = lh, rt = rh, mt = mh;
        int val = head.val;
        while (head != null) {
            if (val == head.val) {
                mt.next = head;
                mt = head;
            } else if (val > head.val) {
                lt.next = head;
                lt = head;
            } else {
                rt.next = head;
                rt = head;
            }
            head = head.next;
        }

        lt.next = null;
        rt.next = null;
        lh.next = sortList(lh.next);
        rh.next = sortList(rh.next);
        lt = lh;
        while (lt.next != null) {
            lt = lt.next;
        }
        lt.next = mh.next;
        mt.next = rh.next;
        return lh.next;
    }


    @Test
    public void testsortList() {
        ListNode head = new ListNode(4);
        ListNode second = new ListNode(19);
        head.next = second;
        ListNode third = new ListNode(14);
        second.next = third;
        ListNode forth = new ListNode(-3);
        third.next = forth;
        head = sortList(head);
    }

}
