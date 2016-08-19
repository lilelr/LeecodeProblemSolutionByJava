package note.binarysearch.ContainsDuplicate220;

import java.util.*;

/**
 * Created by yuxiao on 4/26/16.
 * https://leetcode.com/problems/contains-duplicate-iii/
 */
public class Solution {
    // binary  search tree
    public class TreeNode{
        public long val;
        TreeNode left;
        TreeNode right;
        public TreeNode(long x){
            val = x;
        }
    }


    private TreeNode add(TreeNode root, TreeNode nNode) {
        if(root == null) {
            return nNode;
        }
        else if(root.val < nNode.val) {
            root.right = add(root.right, nNode);
            return root;
        }
        else {
            root.left = add(root.left, nNode);
            return root;
        }
    }

    private TreeNode delete(TreeNode root, TreeNode dNode) {
        if(root == null) {
            return null;
        }
        else if(root.val < dNode.val) {
            root.right = delete(root.right, dNode);
            return root;
        }
        else if(root.val > dNode.val) {
            root.left = delete(root.left, dNode);
            return root;
        }
        else if(root == dNode) {
            if(dNode.left == null && dNode.right == null) return null;
            else if(dNode.left != null && dNode.right == null) return dNode.left;
            else if(dNode.right != null && dNode.left == null) return dNode.right;
            else {
                TreeNode p = dNode.right;
                while(p.left != null) p = p.left;
                dNode.right = delete(dNode.right, p);
                p.left = dNode.left;
                p.right = dNode.right;
                return p;
            }
        }
        else {
            return root;
        }
    }

    private boolean search(TreeNode root, long val, int t) {
        if(root == null) {
            return false;
        }
        else if(Math.abs((root.val - val)) <= t) {
            return true;
        }
        else if((root.val - val) > t) {
            return search(root.left, val, t);
        }
        else {
            return search(root.right, val, t);
        }
    }

    // the key point is to make sure the total number of nodes of BSTree is k
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k < 1 || t < 0 || nums.length <= 1) {
            return false;
        }
        int len = nums.length;
        TreeNode[] map = new TreeNode[len];
        map[0] = new TreeNode((long)nums[0]);
        TreeNode root = null;
        root = add(root, map[0]);
        for(int i = 1; i < len; i++) {
            // because BSTree's total number of nodes is k, so only need to search
            if(search(root, (long)nums[i], t)) {
                return true;
            }
            map[i] = new TreeNode((long)nums[i]);
            if(i - k >= 0) {
                // delete the node whose index is less than i-k
                root = delete(root, map[i-k]);
            }
            root = add(root, map[i]);
        }
        return false;
    }

    //219 hashmap or hashset
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && (i-map.get(nums[i])) <= k)
                return true;
            // avoid TLE in leetcode here
            if (map.size() > k)
                map.remove(nums[i-k]);
            map.put(nums[i], i);
        }
        return false;
    }

    public boolean containsDuplicate(int[] nums) {
            Set<Integer> hashset  = new HashSet<>();
           if(nums.length == 0) return false;
          for(int key:nums){
              if(!hashset.add(key)) return true;
          }
        return false;
    }

}
