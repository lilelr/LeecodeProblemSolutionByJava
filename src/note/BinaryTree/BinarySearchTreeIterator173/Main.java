package note.BinaryTree.BinarySearchTreeIterator173;

import org.junit.Test;

/**
 * Created by yuxiao on 8/5/16.
 * https://discuss.leetcode.com/category/181/binary-search-tree-iterator
 * using Morris method, beats 99%
 */

// Definition for binary tree
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


 class BSTIterator {

    private TreeNode curr;
    private int nextVal;

    public BSTIterator(TreeNode root) {
        curr = root;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        boolean canFindNextVal = false;
        while (curr != null && !canFindNextVal){
            if(curr.left == null){
                canFindNextVal = true;
                this.nextVal = curr.val;
                curr = curr.right;
            }else{
                TreeNode predecessor = curr.left;
                while (predecessor.right!=null && predecessor.right!=curr){
                    predecessor = predecessor.right;
                }

                if(predecessor.right==null){
                    predecessor.right = curr;
                    curr = curr.left;
                }else{
                    predecessor.right = null;
                    canFindNextVal = true;
                    this.nextVal = curr.val;
                    curr = curr.right;
                }
            }
        }
        return canFindNextVal;
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return this.nextVal;
    }


}

public class Main{
    @Test
    public void test(){
        TreeNode root = new TreeNode(4);
        TreeNode firstLeft = new TreeNode(2);
        TreeNode firstRight = new TreeNode(5);
        TreeNode secLeft = new TreeNode(1);
        TreeNode secRight = new TreeNode(3);

        root.left = firstLeft;
        root.right = firstRight;
        firstLeft.left = secLeft;
        firstLeft.right = secRight;
        BSTIterator bstIterator = new BSTIterator(root);
        while (bstIterator.hasNext()){
            System.out.println(bstIterator.next());
        }
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
