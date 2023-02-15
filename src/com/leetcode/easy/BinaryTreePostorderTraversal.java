package com.leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        helper(root, res);
        return res;
    }

    public static void helper(TreeNode root, List<Integer> res) {
        if(root != null) {
            helper(root.left, res);
            helper(root.right, res);
            res.add(root.val);
        }
    }

    public static List<Integer> postorderTraversal2(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while(!stack.empty() || curr != null){
            while(curr != null){
                stack.push(curr);
                ans.add(0,curr.val);
                curr = curr.right;
            }
            TreeNode node = stack.pop();
            curr = node.left;
        }
        return ans;
    }







}
