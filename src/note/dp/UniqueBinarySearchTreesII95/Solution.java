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

//  https://discuss.leetcode.com/topic/2940/java-solution-with-dp
    public  List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] result = new List[n+1];
        result[0] = new ArrayList<TreeNode>();
        result[0].add(null);

        for(int len = 1; len <= n; len++){
            result[len] = new ArrayList<TreeNode>();
            for(int j=0; j<len; j++){
                for(TreeNode nodeL : result[j]){
                    for(TreeNode nodeR : result[len-j-1]){
                        TreeNode node = new TreeNode(j+1);
                        node.left = nodeL;
                        node.right = clone(nodeR, j+1);
                        result[len].add(node);
                    }
                }
            }
        }
        return result[n];
    }

    private TreeNode clone(TreeNode n, int offset){
        if(n == null)
            return null;
        TreeNode node = new TreeNode(n.val + offset);
        node.left = clone(n.left, offset);
        node.right = clone(n.right, offset);
        return node;
    }

    // recursive https://discuss.leetcode.com/topic/35005/java-2ms-solution-beats-92
//    public List<TreeNode> generateTrees(int n) {
//        if(n==0) return new ArrayList<TreeNode>();
//        return generate(1,n);
//
//    }
//
//    public List<TreeNode> generate(int start,int end){
//        if(start > end){
//            List<TreeNode> list = new ArrayList<TreeNode>();
//            list.add(null);
//            return list;
//        }
//        if(start == end){
//            List<TreeNode> list = new ArrayList<TreeNode>();
//            list.add(new TreeNode(start));
//            return list;
//        }
//
//        List<TreeNode> roots = new ArrayList<TreeNode>();
//        for(int i=start;i<=end;i++){
//            List<TreeNode> leftTrees = generate(start,i-1);
//            List<TreeNode> rightTrees = generate(i+1,end);
//            for(int j=0;j<leftTrees.size();j++){
//                for(int k=0;k<rightTrees.size();k++){
//                    TreeNode root = new TreeNode(i);
//                    root.left = leftTrees.get(j);
//                    root.right = rightTrees.get(k);
//                    roots.add(root);
//                }
//            }
//        }
//        return roots;
//    }
}
