package problems.BinaryTreeZigzagLevelOrderTraversal103;

import org.junit.Test;

import java.util.*;

/**
 * Created by yuxiao on 4/2/16.
 */
public class Solution {
    //  Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
       List<List<Integer>> res = new ArrayList<>();
        if(root==null)return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level=0;
        while(!q.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            int levelSize = q.size();
            for (int i=0;i<levelSize; i++){
                TreeNode t = q.poll();
                if(t.left !=null){
                    q.offer(t.left);
                }
                if(t.right != null){
                    q.offer(t.right);
                }
                tmp.add(t.val);
            }

            if(level%2!=0){
                reverseList(tmp);
            }
            res.add(tmp);
            level++;
        }
        return res;
    }

    public void reverseList(List<Integer> list){
        int len = list.size();
        for(int i=0;i<len/2;i++){
            int temp = list.get(i);
            list.set(i,list.get(len-i-1));
            list.set(len-i-1,temp);
        }
    }


    @Test
    public void testzigzagLevelOrder(){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> res = zigzagLevelOrder(root);
        Iterator<List<Integer>> iterator = res.iterator();
        while(iterator.hasNext()){
            List<Integer> itemList = iterator.next();
            Iterator<Integer> iteratorInt = itemList.iterator();

            while(iteratorInt.hasNext()){
                System.out.print(iteratorInt.next()+",");
            }
            System.out.println();
        }
    }
}
