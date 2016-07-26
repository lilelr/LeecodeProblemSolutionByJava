package note.PriorityQueue.MergekSortedLists23;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by yuxiao on 7/26/16.
 */
public class Solution {

     //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0){
            return null;
        }

        // ascending
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if(o1.val < o2.val){
                    return -1;
                } else if(o1.val == o2.val){
                    return 0;
                }else{
                    return 1;
                }
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for(ListNode node:lists){
            if(node !=null){
                queue.add(node);
            }
        }

        while (!queue.isEmpty()){
            tail.next = queue.poll();
            tail = tail.next;

            if(tail.next!=null){
                queue.add(tail.next);
            }
        }
        return dummy.next;
    }
    // 93% Java solution with merge sort algorithm at O(nlogK)
    //https://discuss.leetcode.com/topic/38083/93-java-solution-with-merge-sort-algorithm-at-o-nlogk
    public ListNode mergeKListsByMersort(ListNode[] lists) {
        if(lists.length == 0)
            return null;

        return mergeK(lists, 0, lists.length-1);
    }

    private ListNode mergeK(ListNode[] lists, int low, int high) {
        if(low == high)
            return lists[low];
        if(low + 1 == high)
            return mergeTwo(lists[low], lists[high]);

        int mid = low + (high - low) / 2;
        return mergeTwo(mergeK(lists, low, mid), mergeK(lists, mid+1, high));
    }

    private ListNode mergeTwo(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;

        ListNode head, it;
        if(l1.val <= l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }

        it = head;

        while(l1 != null || l2 != null) {
            if(l1 != null && l2 != null) {
                if(l1.val <= l2.val) {
                    it.next = l1;
                    l1 = l1.next;
                } else {
                    it.next = l2;
                    l2 = l2.next;
                }
            } else if(l1 != null) {
                it.next = l1;
                l1 = l1.next;
            } else {
                it.next = l2;
                l2 = l2.next;
            }
            it = it.next;
        }
        return head;
    }

    @Test
    public void test(){
        ListNode head1 = new ListNode(2);
        ListNode one2 = new ListNode(10);
        ListNode one3 = new ListNode(100);
        head1.next = one2;
        one2.next = one3;

        ListNode head2 = new ListNode(3);
        ListNode two2 = new ListNode(99);
        head2.next = two2;

        ListNode[] nodes = new ListNode[2];
        nodes[0] = head1;
        nodes[1] = head2;

        ListNode res = mergeKLists(nodes);
    }


}
