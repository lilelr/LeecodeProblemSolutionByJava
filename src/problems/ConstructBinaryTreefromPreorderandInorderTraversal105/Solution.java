package problems.ConstructBinaryTreefromPreorderandInorderTraversal105;

/**
 * Created by yuxiao on 16/4/13.
 * Construct Binary Tree from Preorder and Inorder Traversal
 */
public class Solution {
    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode preInCreate(int[] preorder, int[] inorder,int s1,int h1,int s2,int h2){
        TreeNode root = new TreeNode(preorder[s1]);
        int i;
        int llen;
        int rlen;
        for(i=s2;inorder[i]!=root.val;i++);
        llen = i-s2;
        rlen = h2-i;
        if(llen!=0){
            root.left = preInCreate(preorder,inorder,s1+1,s1+llen,s2,s2+llen-1);
        } else{
            root.left = null;
        }

        if(rlen!=0){
            root.right = preInCreate(preorder,inorder,h1-rlen+1,h1,h2-rlen+1,h2);
        }else{
            root.right = null;
        }
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
         int  len=preorder.length;
        if(len==0) return null;
        int s1=0,h1=len-1,s2=0,h2=len-1;
        return preInCreate(preorder,inorder,s1,h1,s2,h2);
    }
}
