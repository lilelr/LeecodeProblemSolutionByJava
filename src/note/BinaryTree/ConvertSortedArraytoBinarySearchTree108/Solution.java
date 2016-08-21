package note.BinaryTree.ConvertSortedArraytoBinarySearchTree108;

import org.junit.Test;

/**
 * Created by yuxiao on 16/4/13.
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
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


    public TreeNode insert(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode t;
        if (mid >= 0 && mid < nums.length) {
            t = new TreeNode(nums[mid]);
            t.left = insert(nums, start, mid - 1);
            t.right = insert(nums, mid + 1, end);
        } else {
            t = null;
        }
        return t;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length - 1;
        TreeNode root = null;
        if (len == -1) return null;
        else if (len == 0) return new TreeNode(nums[0]);
        else if (len == 1) {
            root = new TreeNode(nums[0]);
            root.right = new TreeNode(nums[1]);
            return root;
        } else {
            int mid = len / 2;
            root = new TreeNode(nums[mid]);
            root.left = insert(nums, 0, mid - 1);
            root.right = insert(nums, mid + 1, len);
        }
        return root;
    }

    @Test
    public void testsortedArrayToBST() {
        int[] nums = {1,2,3,4,5,6,7,8};
//        int[] nums = {1, 2, 3};
        TreeNode root = sortedArrayToBST(nums);
    }

}
