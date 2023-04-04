package com.leetcode.easy;

public class MaxDeptTree {

    private static int answer = 0;
    private static void maximumDeptTopDown(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            answer = Math.max(answer, depth);
        }
        maximumDeptTopDown(root.left, depth + 1);
        maximumDeptTopDown(root.right, depth + 1);
    }


    public static int maximumDeptBottomUp(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maximumDeptBottomUp(root.left);
        int rightDepth = maximumDeptBottomUp(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }


}
