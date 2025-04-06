package org.problems;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4,
                new TreeNode(2, new TreeNode(1, null, null), new TreeNode(3, null, null)),
                new TreeNode(7, new TreeNode(6, null, null), new TreeNode(9, null, null)));

        TreeNode invertedRoot = invertTree(root);

        invertedRoot = invertTreeIterative(root);
    }

    //Since each node in the tree is visited / added to the queue only once, the time complexity is O(n), where n is the number of nodes in the tree.
    //
    //Space complexity is O(n), since in the worst case, the queue will contain all nodes in one level of the binary tree. For a full binary tree, the leaf level has ⌈n/2⌉=O(n) leaves.
    private static TreeNode invertTreeIterative(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return root;
    }

    //Since each node in the tree is visited only once, the time complexity is O(n), where n is the number of nodes in the tree. We cannot do better than that, since at the very least we have to visit each node to invert it.
    //
    //Because of recursion, O(h) function calls will be placed on the stack in the worst case, where h is the height of the tree. Because h∈O(n), the space complexity is O(n).
    public static TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }

        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }
}
