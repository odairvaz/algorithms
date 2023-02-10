package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    private List<Integer> ans = new ArrayList<>();

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        // Note that we add currNode's right child to the stack first.
        while (!stack.isEmpty()) {
            TreeNode currNode = stack.peek();
            stack.pop();
            if (currNode != null) {
                answer.add(currNode.val);
                stack.add(currNode.right);
                stack.add(currNode.left);
            }
        }
        return answer;
    }

    public static void preorderTraversalRec(TreeNode node) {
        if (node == null) {
            return;
        }
        // Visit the root first, then the left subtree, then the right subtree.
        System.out.print(node.val + "--> ");
        preorderTraversalRec(node.left);
        preorderTraversalRec(node.right);
    }
}

