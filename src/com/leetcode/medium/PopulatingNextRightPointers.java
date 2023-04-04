package com.leetcode.medium;

import com.leetcode.easy.Node;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointers {

    public static Node connect(Node root) {
        if (root == null) return null;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while ( !queue.isEmpty() ) {

            // number of elements in the current level
            int size = queue.size();
            for(int i = 0; i < size; ++i) {
                Node node = queue.poll();

                //add the connection only the current level
                if (i < size - 1) {
                    node.next = queue.peek();
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }

    public static Node connectV2(Node root) {

        if (root == null) {
            return null;
        }

        // Start with the root node. There are no next pointers
        // that need to be set up on the first level
        Node leftmost = root;

        // Once we reach the final level, we are done
        while (leftmost.left != null) {

            // Iterate the "linked list" starting from the head
            // node and using the next pointers, establish the
            // corresponding links for the next level
            Node head = leftmost;

            while (head != null) {

                // CONNECTION 1
                head.left.next = head.right;

                // CONNECTION 2
                if (head.next != null) {
                    head.right.next = head.next.left;
                }

                // Progress along the list (nodes on the current level)
                head = head.next;
            }

            // Move onto the next level
            leftmost = leftmost.left;
        }

        return root;
    }

}
