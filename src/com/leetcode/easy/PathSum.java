package com.leetcode.easy;

import java.util.LinkedList;

public class PathSum {

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        targetSum -= root.val;
        if(root.left == null && root.right == null)
            return (targetSum == 0);
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }

    public boolean hasPathSumIter(TreeNode root, int sum) {
        if (root == null)
            return false;

        LinkedList<TreeNode> nodeStack = new LinkedList();
        LinkedList<Integer> sumStack = new LinkedList();
        nodeStack.add(root);
        sumStack.add(sum - root.val);

        TreeNode node;
        int currSum;
        while ( !nodeStack.isEmpty() ) {
            node = nodeStack.pollLast();
            currSum = sumStack.pollLast();
            if ((node.right == null) && (node.left == null) && (currSum == 0))
                return true;

            if (node.right != null) {
                nodeStack.add(node.right);
                sumStack.add(currSum - node.right.val);
            }
            if (node.left != null) {
                nodeStack.add(node.left);
                sumStack.add(currSum - node.left.val);
            }
        }
        return false;
    }


}
