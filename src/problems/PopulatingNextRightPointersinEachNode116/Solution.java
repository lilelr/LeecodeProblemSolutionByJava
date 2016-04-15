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
          TreeLinkNode(int x) { val = x; }
      }

    // level traversal
    public TreeLinkNode connect(TreeLinkNode root) {

        if(root == null) return null;
        int last=0;
        LinkedList<TreeLinkNode> queue = new LinkedList<>();
        queue.push(root);
        int front=0,rear=0;
        rear++;
        last=1;
        boolean flag=false;
        TreeLinkNode preNode = new TreeLinkNode(0);
        while (front<rear){
            front++;
            TreeLinkNode frontNode = queue.pop();


            if(frontNode.left != null){
                queue.offer(frontNode.left);
                rear++;
            }

            if(frontNode.right != null){
                queue.offer(frontNode.right);
                rear++;
            }

            if(last == front ){
                preNode.next = frontNode;
                frontNode.next = null;
                flag = true;
                last = rear;
            } else{
                if(!flag){
                    preNode.next = frontNode;
                }
                preNode = frontNode;
                flag=false;
            }
        }

        return root;
    }

    @Test
    public void test(){
        TreeLinkNode root = new TreeLinkNode(0);
        TreeLinkNode first = new TreeLinkNode(1);
        TreeLinkNode sec = new TreeLinkNode(2);
        TreeLinkNode third = new TreeLinkNode(3);
        TreeLinkNode forth = new TreeLinkNode(4);
        root.left = first;
        root.right = sec;
        first.left =third;
        first.right = forth;
        root = connect(root);
    }

}
