package note.binarysearch.CountOfSmallerNumbersAfterSelf315;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by yuxiao on 4/26/16.
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 */
public class Solution {

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length == 0 || nums == null) return res;
        if (nums.length == 1) {
            res.add(0);
            return res;
        }
        int len = nums.length;
        int[] b = new int[len];
        for (int i = 0; i < len; i++) {
            b[i] = nums[i];
        }

        Arrays.sort(b);
        int curLenOfb = b.length;
        for (int i = 0; i < len - 1; i++) {
            int curItem = nums[i];
            int bsPos = binarySearch(b, curItem, curLenOfb);
            res.add(bsPos);

            for (int j = bsPos; j < curLenOfb - 1; j++) {
                b[j] = b[j + 1];
            }
            curLenOfb--;

        }
        res.add(0);
        return res;


    }

    public int binarySearch(int[] nums, int val, int len) {
        int left = 0, right = len - 1;
        int middle;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (nums[middle] == val) {
                if (middle > left && nums[middle - 1] == val) {
                    right = middle - 1;
                } else {
                    return middle;
                }
            } else if (nums[middle] < val) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return left;
    }


    // Solution2 Using rank  46ms  O(nlogn)
//    https://leetcode.com/discuss/87132/bst-in-java-using-rank
    public List<Integer> countSmaller2(int[] nums) {
        BST<Integer> bst = new BST();
        List<Integer> counts = new ArrayList<Integer>(nums.length);

        // when constructing the binary search tree, we can count the rank in the BST backward.
        for (int i = nums.length - 1; i >= 0; i--) {
            bst.put(nums[i]);
            counts.add(bst.rank(nums[i]));
        }

        Collections.reverse(counts);
        return counts;
    }


    private class BST<Key extends Comparable<Key>> {
        private class Node {
            private Key key;
            private int n;
            private Node left;
            private Node right;
            private int count;

            public Node(Key key, int n, int count) {
                this.n = n;
                this.key = key;
                this.count = count;
            }
        }

        private Node root;

        public BST() {

        }

        public int size(Node node) {
            if (node == null) return 0;
            return node.n;
        }

        public void put(Key key) {
            root = put(root, key);
        }

        private Node put(Node node, Key key) {
            if (node == null) {
                return new Node(key, 1, 1);
            }
            int cmp = key.compareTo(node.key);
            if (cmp < 0) {
                node.left = put(node.left, key);

            } else if (cmp > 0) {
                node.right = put(node.right, key);
            } else {
                node.count = node.count + 1;     // do not replace key, increase count
            }
            node.n = size(node.left) + node.count + size(node.right);
            return node;
        }

        public int rank(Key key) {
            return rank(root, key);
        }


        // calculate the total number of nodes whose values are less than the key.
        private int rank(Node node, Key key) {
            if (node == null) return 0;
            int cmp = key.compareTo(node.key);
            if (cmp < 0) return rank(node.left, key);
            else if (cmp > 0) return size(node.left) + node.count + rank(node.right, key);
            else return size(node.left);
        }
    }
}
