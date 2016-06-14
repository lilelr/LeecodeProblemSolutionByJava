package note.BinaryTree.BinaryTreeRightSideView199;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by yuxiao on 16/4/18.
 *  Level order
 */
public class Solution {


     //Definition for a binary tree node.
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if (root == null) return res;


        int last;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        int front = 0, rear = 0;
        rear++;
        last = 1;
        boolean flag = false;
        while (front < rear) {
            front++;
            TreeNode frontNode = queue.pop();


            if (frontNode.left != null) {
                queue.offer(frontNode.left);
                rear++;
            }

            if (frontNode.right != null) {
                queue.offer(frontNode.right);
                rear++;
            }



            if (last == front) {
                res.add(frontNode.val);

                flag = true;
                last = rear;
            } else {


                flag = false;
            }
        }

        return res;
    }
}
