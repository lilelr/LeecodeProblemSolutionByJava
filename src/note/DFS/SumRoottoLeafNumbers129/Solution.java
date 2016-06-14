package note.DFS.SumRoottoLeafNumbers129;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuxiao on 6/14/16.
 */
public class Solution {

      //Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
         TreeNode(int x) { val = x; }
     }

    public int sumNumbers(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        getPaths(root,"",res);
        int sum=0;
        for (Integer item:res){
            sum += item;
        }
        return sum;

    }

    public void getPaths(TreeNode root, String str, List<Integer> res){
        if(root == null) return;
        if (str.equals("")){
            str += root.val;
        }
        else {
            str += root.val;
        }
        if (root.left == null && root.right == null){
            res.add (Integer.valueOf(str));
            return;
        }
        if (root.left != null){
            getPaths (root.left, str, res);
        }
        if (root.right != null){
            getPaths (root.right, str, res);
        }
    }


}
