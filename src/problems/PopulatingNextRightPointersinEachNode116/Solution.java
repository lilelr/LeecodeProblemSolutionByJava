package problems.PopulatingNextRightPointersinEachNode116;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yuxiao on 16/4/15.
 */
public class Solution {

    //* Definition for binary tree with next pointer.
    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    // level traversal
    public TreeLinkNode connect(TreeLinkNode root) {

        if (root == null) return null;
        int last;
        LinkedList<TreeLinkNode> queue = new LinkedList<>();
        queue.push(root);
        int front = 0, rear = 0;
        rear++;
        last = 1;
        boolean flag = false;
        TreeLinkNode preNode = new TreeLinkNode(0);
        while (front < rear) {
            front++;
            TreeLinkNode frontNode = queue.pop();


            if (frontNode.left != null) {
                queue.offer(frontNode.left);
                rear++;
            }

            if (frontNode.right != null) {
                queue.offer(frontNode.right);
                rear++;
            }

            if (frontNode.val == 4) {
                System.out.println("ff");
                int yy;
            }
            if (!flag) {
                preNode.next = frontNode;
            }

            if (last == front) {

                frontNode.next = null;
                flag = true;
                last = rear;
            } else {

                preNode = frontNode;
                flag = false;
            }
        }

        return root;
    }

    @Test
    public void test() {
        TreeLinkNode root = new TreeLinkNode(1);
        TreeLinkNode first = new TreeLinkNode(2);
        TreeLinkNode sec = new TreeLinkNode(3);
        TreeLinkNode third = new TreeLinkNode(4);
        TreeLinkNode forth = new TreeLinkNode(5);
        TreeLinkNode fifth = new TreeLinkNode(6);
        root.left = first;
        root.right = sec;
        first.left = third;
//        first.right = forth;
//        sec.right = fifth;

        sec.right = forth;
        forth.right = fifth;
        root = connect(root);
    }

}
