package problems.SortList148;

import org.junit.Test;

import java.util.List;

/**
 * Created by yuxiao on 4/8/16.
 */



public class Solution {
    /**
     *  List Sort by quickSort
     */

      //Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

    // return ListNode[4]
    // ListNode[0] -> start of smaller list, null if none
    // ListNode[1] -> start of pivot list (contains duplicates of pivot values)
    // ListNode[2] -> end of pivot list
    // ListNode[3] -> start of bigger list, null if none
    // Assume the input head must not be null, already check nullness in the caller
    private ListNode[] partition(ListNode head) {
        ListNode[] res = new ListNode[4];

        ListNode pivotLstStart = head;
        ListNode pivotLstEnd = pivotLstStart;

        ListNode smallLstStart = null;
        ListNode smallLstEnd = null;
        ListNode bigLstStart = null;
        ListNode bigLstEnd = null;

        for(ListNode node=head.next; node!=null; node=node.next) {
            if(node.val < pivotLstStart.val) {
                if(smallLstStart==null)
                    smallLstStart = node;
                else
                    smallLstEnd.next = node;
                smallLstEnd = node;
            } else if (node.val > pivotLstStart.val) {
                if(bigLstStart==null)
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
        if(smallLstEnd!=null)
            smallLstEnd.next = null;
        if(bigLstEnd!=null)
            bigLstEnd.next = null;

        res[0] = smallLstStart;
        res[1] = pivotLstStart;
        res[2] = pivotLstEnd;
        res[3] = bigLstStart;

        return res;
    }

    // return ListNode[2]
    // ListNode[0] -> start non-null node of sorted list
    // ListNode[1] -> end non-null node of sorted list
    // Note that if none, both ListNode[0] and ListNode[1] are null
    // if there is only one node, ListNode[0]==ListNode[1]
    private ListNode[] quickSortList(ListNode head) {
        ListNode[] res = new ListNode[2];

        if(head==null)
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
        res[1] = bigRes[1]==null ? pivotTail : bigRes[1];

        if(smallRes[0]==null) {
            res[0] = pivotHead;
        } else {
            res[0] = smallRes[0];
            smallRes[1].next = pivotHead;
        }
        return res;
    }

    public ListNode sortList(ListNode head) {
        return quickSortList(head)[0];
    }

    @Test
    public void testsortList(){
        ListNode head = new ListNode(5);
        ListNode second = new ListNode(4);
        head.next = second;
        ListNode third = new ListNode(3);
        second.next = third;
        ListNode forth = new ListNode(2);
        third.next = forth;
        sortList(head);
    }

}
