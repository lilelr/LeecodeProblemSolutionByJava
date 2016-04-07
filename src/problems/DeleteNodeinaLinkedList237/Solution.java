package problems.DeleteNodeinaLinkedList237;

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


    public void deleteNode(ListNode node) {
            ListNode nextNode = node.next;
            node.val = nextNode.val;
           node.next = nextNode.next;

    }
}