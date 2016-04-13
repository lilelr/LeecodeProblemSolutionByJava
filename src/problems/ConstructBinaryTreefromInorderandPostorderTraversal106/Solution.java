package problems.ConstructBinaryTreefromInorderandPostorderTraversal106;

/**
 * Created by yuxiao on 16/4/13.
 * Construct Binary Tree from InOrder and PostOrder Traversal.
 */
public class Solution {
    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode inPostCreate(int[] postorder, int[] inorder,int s1,int h1,int s2,int h2){
        TreeNode root = new TreeNode(postorder[h1]);
        int i;
        int llen;
        int rlen;
        for(i=s2;inorder[i]!=root.val;i++);
        llen = i-s2;
        rlen = h2-i;
        if(llen!=0){
            root.left = inPostCreate(postorder, inorder, s1, s1 + llen-1, s2, s2 + llen - 1);
        } else{
            root.left = null;
        }

        if(rlen!=0){
            root.right = inPostCreate(postorder, inorder, h1 - rlen, h1 - 1, h2 - rlen + 1, h2);
        }else{
            root.right = null;
        }
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int  len=postorder.length;
        if(len==0) return null;
        int s1=0,h1=len-1,s2=0,h2=len-1;
        return inPostCreate(postorder,inorder,s1,h1,s2,h2);
    }
}
