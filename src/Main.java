//import note.BinaryTree.BinarySearchTreeIterator173.BSTIterator;
//import problems.RangeSumQuery303.NumArray;
//
//
//
//
//public class Main {
//    static class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//
//        TreeNode(int x) {
//            val = x;
//        }
//    }
//
//    public static void main(String[] args) {
//        NumArray numArray = new NumArray(new int[]{-2,0,3,-5,2,-1});
//
//        System.out.println(numArray.sumRange(2,5));
//        System.out.println(numArray.sumRange(0,2));
//        System.out.println(numArray.sumRange(0,5));
//
//        TreeNode root = new TreeNode(4);
//        TreeNode firstLeft = new TreeNode(2);
//        TreeNode firstRight = new TreeNode(5);
//        TreeNode secLeft = new TreeNode(1);
//        TreeNode secRight = new TreeNode(3);
//
//        root.left = firstLeft;
//        root.right = firstRight;
//        firstLeft.left = secLeft;
//        firstLeft.right = secRight;
//        BSTIterator bstIterator = new BSTIterator(root);
//        while (bstIterator.hasNext()){
//            System.out.println(bstIterator.next());
//        }
//
//
//    }
//
//
//}
