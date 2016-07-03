package note.dp.UniqueBinarySearchTreesII95;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuxiao on 7/3/16.
 */
public class Solution {

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


//    TreeNode deepCopy(TreeNode root) {
//        if (root == null) return null;
//        TreeNode tmp = new TreeNode(1);
//        tmp.left = deepCopy(root.left);
//        tmp.right = deepCopy(root.right);
//        return tmp;
//    }
//
//    int cur = 0;
//
//    void setValue(TreeNode root) {
//        if (root.left != null) {
//            setValue(root.left);
//        }
//        root.val = cur++;
//        if (root.right != null) {
//            setValue(root.right);
//        }
//
//    }
//
//    public List<TreeNode> generateTrees(int n) {
//        if (n <= 0) {
//            List<TreeNode> res = new ArrayList<TreeNode>();
//            res.add(null);
//            return res;
//        }
//
//        List<TreeNode>[] dp = new ArrayList[n + 1];
//        for (int i = 0; i < n + 1; ++i) {
//            dp[i] = new ArrayList<TreeNode>();
//        }
//
//        dp[0].add(null);
//
//        for (int i = 1; i <= n; ++i) {
//            for (int j = 0; j < i; ++j) {
//                for (int k = 0; k < dp[j].size(); ++k) {
//                    for (int l = 0; l < dp[i - 1 - j].size(); ++l) {
//                        TreeNode tmp = new TreeNode(1);
//                        tmp.left = deepCopy(dp[j].get(k));
//                        tmp.right = deepCopy(dp[i - 1 - j].get(l));
//                        dp[i].add(tmp);
//                    }
//                }
//            }
//        }
//
//        for (int i = 0; i < dp[n].size(); ++i) {
//            cur = 1;
//            setValue(dp[n].get(i));
//        }
//        return dp[n];
//    }

    // recursive https://discuss.leetcode.com/topic/35005/java-2ms-solution-beats-92
    public List<TreeNode> generateTrees(int n) {
        if(n==0) return new ArrayList<TreeNode>();
        return generate(1,n);

    }

    public List<TreeNode> generate(int start,int end){
        if(start > end){
            List<TreeNode> list = new ArrayList<TreeNode>();
            list.add(null);
            return list;
        }
        if(start == end){
            List<TreeNode> list = new ArrayList<TreeNode>();
            list.add(new TreeNode(start));
            return list;
        }

        List<TreeNode> roots = new ArrayList<TreeNode>();
        for(int i=start;i<=end;i++){
            List<TreeNode> leftTrees = generate(start,i-1);
            List<TreeNode> rightTrees = generate(i+1,end);
            for(int j=0;j<leftTrees.size();j++){
                for(int k=0;k<rightTrees.size();k++){
                    TreeNode root = new TreeNode(i);
                    root.left = leftTrees.get(j);
                    root.right = rightTrees.get(k);
                    roots.add(root);
                }
            }
        }
        return roots;
    }
}
