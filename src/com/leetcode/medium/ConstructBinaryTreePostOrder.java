package com.leetcode.medium;

import com.leetcode.easy.TreeNode;

import java.util.HashMap;

public class ConstructBinaryTreePostOrder {
    int postIdx;
    int[] postorder;
    int[] inorder;
    HashMap<Integer, Integer> idxMap = new HashMap<>();

    public TreeNode helper(int inLeft, int inRight) {
        // if there is no elements to construct subtrees
        if (inLeft > inRight)
            return null;

        // pick up postIdx element as a root
        int rootVal = postorder[postIdx];
        TreeNode root = new TreeNode(rootVal);

        // root splits inorder list
        // into left and right subtrees
        int index = idxMap.get(rootVal);

        // recursion
        postIdx--;
        // build right subtree
        root.right = helper(index + 1, inRight);
        // build left subtree
        root.left = helper(inLeft, index - 1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        // start from the last postorder element
        postIdx = postorder.length - 1;

        // build a hashmap value -> its index
        int idx = 0;
        for (Integer val : inorder)
            idxMap.put(val, idx++);
        return helper(0, inorder.length - 1);
    }

}
