package note.BinaryTree.ConvertSortedListtoBinarySearchTree109;

import org.junit.Test;

/**
 * Created by yuxiao on 16/4/14.
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 * Convert Sorted List to Binary Search Tree
 * 2ms
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


    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        if (head.next.next == null) {
            TreeNode root = new TreeNode(head.val);
            root.right = new TreeNode(head.next.val);
            return root;
        }

        int mid = 1, len;
        ListNode pre = head;
        ListNode p = head.next.next;
        // scan once to point at the middle node
        while (p != null && p.next != null) {
            p = p.next.next;
            pre = pre.next;
            mid++;
        }
        len = mid * 2;
        if (p != null) {
            mid++;
            pre = pre.next;
            len = mid * 2 - 1;
        }
        mid--;
        TreeNode root = new TreeNode(pre.val);
        root.left = insertNode(head, 0, mid - 1);
        root.right = insertNode(pre.next, mid + 1, len - 1);
        return root;

    }

    public TreeNode insertNode(ListNode startNode, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        int increment = (end - start) / 2;
        ListNode newHead = startNode;
        for (int i = 0; i < increment; i++) {
            newHead = newHead.next;
        }
        TreeNode t = new TreeNode(newHead.val);
        t.left = insertNode(startNode, start, mid - 1);
        t.right = insertNode(newHead.next, mid + 1, end);
        return t;
    }


    @Test
    public void testsortedArrayToBST() {
        ListNode head = new ListNode(1);
        ListNode sec = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode forth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        head.next = sec;
        sec.next = third;
        third.next = forth;
        forth.next = fifth;
        TreeNode root = sortedListToBST(head);
    }

}
