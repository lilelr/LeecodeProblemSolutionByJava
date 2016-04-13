package problems.SymmetricTree101;

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

    boolean preOrder (TreeNode p, TreeNode q){
        if(p==null && q==null){
            return true;
        } else if((p==null&&q!=null) || (q==null&&p!=null)){
            return false;
        } else {
            if(p.val!=q.val) {
                return false;
            } else{
                boolean isLeftSame = preOrder(p.left,q.right);
                if(isLeftSame==true){
                    return preOrder(p.right,q.left);
                } else{
                    return false;
                }
            }

        }
    }

    public boolean isSymmetric(TreeNode root) {
        if(root==null || (root.left==null && root.right==null)) return true;
        return preOrder(root.left,root.right);
    }
}
