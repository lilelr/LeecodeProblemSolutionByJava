package note.bianarysearch;

import org.junit.Test;

import java.util.*;

/**
 * Created by yuxiao on 4/3/16.   Some ordinary operations of binary tree.
 */
public class BinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null) return  res;
        TreeNode[] queue = new TreeNode[10000];
        int front=-1,rear=-1;
        int last=0;
        queue[++rear] = root;

        List<Integer> tempList = new ArrayList<>();
        while (front < rear){
            TreeNode tempNode = queue[++front];
            tempList.add(tempNode.val);
            if(tempNode.left!=null) queue[++rear] = tempNode.left;
            if(tempNode.right!=null) queue[++rear] = tempNode.right;

            if(front == last){
                last = rear;
                List<Integer> saveList = new ArrayList<>();
                saveList.addAll(tempList);
                res.add(saveList);
                tempList.clear();
            }
        }

        return  res;
    }


    public List<List<Integer>> levelOrderBFS(TreeNode root){
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

            res.add(tmp);
        }
        return res;
    }

    public List<List<Integer>> levelOrderDFS(TreeNode root){
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

        list.get(deep).add(node.val);
        dfs(list,node.left,deep+1);
        dfs(list,node.right,deep+1);
    }




    @Test
    public void testlevelOrder(){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> res = levelOrder(root);
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
