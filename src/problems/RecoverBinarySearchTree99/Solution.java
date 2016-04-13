package problems.RecoverBinarySearchTree99;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yuxiao on 16/4/13.
 */
public class Solution {


    //Definition for a binary tree node.
      public class TreeNode {
          int val;
         TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    void inOrder(TreeNode root,List<TreeNode> res){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode preNode = null;
        while (root!=null || !stack.isEmpty()){
            if(root!=null){
                stack.push(root);
                root=root.left;
            } else{
                root = stack.pop();
                if(preNode == null){
                    preNode = root;
                } else {
                    if (preNode.val > root.val){
                        res.add(preNode);
                        res.add(root);
                    }
                    preNode = root;
                }
                root = root.right;
            }
        }
    }

    public void swap(TreeNode first,TreeNode second ){
        int tmpval = first.val;
        first.val = second.val;
        second.val = tmpval;
    }

    public void recoverTree(TreeNode root) {
        List<TreeNode> res=new ArrayList<>();
        if(root==null || (root.left==null && root.right==null)){
            return;
        }

        inOrder(root,res);
        int resSize = res.size();
        if(resSize==2){
            swap(res.get(0),res.get(1));
        } else {
            int max,min,maxpos,minpos;
            max = res.get(0).val;
            min = res.get(0).val;
            maxpos=minpos=0;
            for(int i=1;i<resSize;i++){
                if(res.get(i).val>max){
                    max=res.get(i).val;
                    maxpos = i;
                }
                if(res.get(i).val<min){
                    min=res.get(i).val;
                    minpos = i;
                }

            }
            swap(res.get(maxpos),res.get(minpos));
        }
    }

    @Test
    public void testRecover(){
//        TreeNode root = new TreeNode(3);
//        TreeNode first = new TreeNode(1);
//        TreeNode second = new TreeNode(2);
        TreeNode root = new TreeNode(5);
        TreeNode first = new TreeNode(4);
        TreeNode second = new TreeNode(3);
        TreeNode third = new TreeNode(10);
        TreeNode forth = new TreeNode(9);


        root.left = first;
        root.right = second;
        first.left = third;
        second.left = forth;
        recoverTree(root);
    }


}
