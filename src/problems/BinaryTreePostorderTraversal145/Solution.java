package problems.BinaryTreePostorderTraversal145;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yuxiao on 16/4/12.
 */
public class Solution {
    /**
     * The PostOrderTraversal of Binary Tree using stack.
     */

     // Definition for a binary tree node.
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        if (root==null) return ans;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p,r;
        r=null;
        p = root;
        while(p!=null || !stack.isEmpty()){
                if(p!=null){
                    stack.push(p);
                    p = p.left;
                } else{
                    p = stack.peek();
                    if(p.right!=null && p.right!=r){
                        p = p.right;
                        stack.push(p);
                        p=p.left;
                    } else{
                        p = stack.pop();
                        ans.add(p.val);
                        r=p;
                        p=null;
                    }
                }
        }
        return ans;
    }

    @Test
    public void testPostOrder(){
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> ans=postorderTraversal(root);
        for(Integer item:ans){
            System.out.println(item);
        }

    }

}
