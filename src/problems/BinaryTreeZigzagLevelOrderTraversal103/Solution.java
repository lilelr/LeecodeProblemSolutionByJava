package problems.BinaryTreeZigzagLevelOrderTraversal103;

import org.junit.Test;

import java.util.*;

/**
 * Created by yuxiao on 4/2/16.
 * Zigzag-level-order of binary tree.
 */
public class Solution {
    //  Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    ///BFS 3ms
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

    ///DFS 2ms
    public List<List<Integer>> zigzagLevelOrderDFS(TreeNode root){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null){
            return res;
        }

        dfs(res,root,0);
        return res;
    }

    public void dfs(List<List<Integer>> list, TreeNode node, int deep){
        if(node==null) return;
        if(list.size()==deep)
            list.add(new ArrayList<Integer>());
        if(deep%2!=0){
            list.get(deep).add(0,node.val);
        }else{
            list.get(deep).add(node.val);
        }

        dfs(list,node.left,deep+1);
        dfs(list,node.right,deep+1);
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
