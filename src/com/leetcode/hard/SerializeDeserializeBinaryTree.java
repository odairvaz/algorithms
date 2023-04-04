package com.leetcode.hard;

import com.leetcode.easy.TreeNode;

import java.lang.ref.SoftReference;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBinaryTree {

    public String serialize(TreeNode root) {
        if (root == null) return "X,";
        String leftSerialized = serialize(root.left);
        String rightSerialized = serialize(root.right);
        return root.val + "," + leftSerialized + rightSerialized;
    }

    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(",")));
        return deserializeHelper(nodes);

    }

    private TreeNode deserializeHelper(Queue<String> nodes) {
        String val = nodes.poll();
        if(val.equals("X")) return null;
        TreeNode node = new TreeNode(Integer.valueOf(val));

        node.left = deserializeHelper(nodes);
        node.right = deserializeHelper(nodes);
        return node;
    }

}
