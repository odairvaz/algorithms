package com.leetcode.medium;

import com.leetcode.easy.TreeNode;

public class LowestCommonAncestor {

        private TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;

        if(root.val == p.val || root.val == q.val) return root;

        TreeNode leftSub = lca(root.left, p, q);
        TreeNode rightSub = lca(root.right, p, q);

        if (leftSub == null) return rightSub;
        if (rightSub == null) return leftSub;

        return root;
    }
}
