package note.BinaryTree.BinaryTreeLevelOrderTraversalII107;

import org.junit.Test;

import java.util.*;

/**
 * Created by yuxiao on 4/2/16.
 */
public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /// BFS 4ms
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null){
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            int size = q.size();
            for (int i=0;i<size; i++){
                TreeNode t = q.poll();
                if(t.left !=null){
                    q.offer(t.left);
                }
                if(t.right != null){
                    q.offer(t.right);
                }
                tmp.add(t.val);
            }

            res.add(0,tmp);
        }
//        reverseList(res);
        return res;
    }

    public void reverseList(List<List<Integer>> list){
        int len = list.size();
        for(int i=0;i<len/2;i++){
            List<Integer> temp = list.get(i);
            list.set(i,list.get(len-i-1));
            list.set(len-i-1,temp);
        }
    }

    @Test
    public void testlevelOrderBottom(){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> res = levelOrderBottom(root);
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
