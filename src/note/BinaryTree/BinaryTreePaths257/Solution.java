package note.BinaryTree.BinaryTreePaths257;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yuxiao on 6/14/16.
 * https://leetcode.com/problems/binary-tree-paths/
 * Given a binary tree, return all root-to-leaf paths.
 */
public class Solution {

     // Definition for a binary tree node.
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    public List<String> binaryTreePaths(TreeNode root) {

        return postorderTraversal(root);
    }

    public List<String> postorderTraversal(TreeNode root) {

        List<String> ans = new ArrayList<>();
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
                    if(p.left == null && p.right == null){
                        TreeNode[] tempPath = new TreeNode[stack.size()];
                        stack.copyInto(tempPath);
                        StringBuffer sb = new StringBuffer();
                        for (TreeNode item:tempPath){
                            sb.append(item.val+"->");
                        }
                        sb.append(p.val);
                        ans.add(sb.toString());
                    }
                    r=p;
                    p=null;
                }
            }
        }
        return ans;
    }



}
