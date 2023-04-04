package com.leetcode.medium;

import com.leetcode.easy.Node;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersII {

    Node prev, leftmost;

    public static Node connect(Node root) {

        if (root == null) {
            return null;
        }

        // Initialize a queue data structure which contains
        // just the root of the tree
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        // Outer while loop which iterates over
        // each level
        while (queue.size() > 0) {

            // Note the size of the queue
            int size = queue.size();

            // Iterate over all the nodes on the current level
            for(int i = 0; i < size; i++) {

                // Pop a node from the front of the queue
                Node node = queue.poll();

                // This check is important. We don't want to
                // establish any wrong connections. The queue will
                // contain nodes from 2 levels at most at any
                // point in time. This check ensures we only
                // don't establish next pointers beyond the end
                // of a level
                if (i < size - 1) {
                    node.next = queue.peek();
                }

                // Add the children, if any, to the back of
                // the queue
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        // Since the tree has now been modified, return the root node
        return root;
    }

    public void processChild(Node childNode) {

        if (childNode != null) {

            // If the "prev" pointer is already set i.e. if we
            // already found atleast one node on the next level,
            // setup its next pointer
            if (this.prev != null) {
                this.prev.next = childNode;

            } else {

                // Else it means this child node is the first node
                // we have encountered on the next level, so, we
                // set the leftmost pointer
                this.leftmost = childNode;
            }

            this.prev = childNode;
        }
    }

    public Node connectV2(Node root) {

        if (root == null) {
            return null;
        }

        // The root node is the only node on the first level
        // and hence its the leftmost node for that level
        this.leftmost = root;

        // Variable to keep track of leading node on the "current" level
        Node curr;

        // We have no idea about the structure of the tree,
        // so, we keep going until we do find the last level.
        // the nodes on the last level won't have any children
        while (this.leftmost != null) {

            // "prev" tracks the latest node on the "next" level
            // while "curr" tracks the latest node on the current
            // level.
            this.prev = null;
            curr = this.leftmost;

            // We reset this so that we can re-assign it to the leftmost
            // node of the next level. Also, if there isn't one, this
            // would help break us out of the outermost loop.
            this.leftmost = null;

            // Iterate on the nodes in the current level using
            // the next pointers already established.
            while (curr != null) {

                // Process both the children and update the prev
                // and leftmost pointers as necessary.
                this.processChild(curr.left);
                this.processChild(curr.right);

                // Move onto the next node.
                curr = curr.next;
            }
        }
        return root ;
    }
}
