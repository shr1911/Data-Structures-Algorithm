package org.problems;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthBinaryTree {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3, new TreeNode(9, null, null), new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7, new TreeNode(18, null, null), null)));
        System.out.println(maxDepthDFS(root1));

//        System.out.println(maxDepthBFS(root1));


    }



    //Time complexity: we visit each node exactly once, thus the time complexity is O(N), where N is the number of nodes.
    //
    //Space complexity: in the worst case, the tree is completely unbalanced, e.g. each node has only left child node, the recursion call would occur N times (the height of the tree), therefore the storage to keep the call stack would be O(N). But in the best case (the tree is completely balanced), the height of the tree would be log(N). Therefore, the space complexity in this case would be O(log(N)).
    public static int maxDepthDFS(TreeNode root) {
        if (root == null) return 0;

        if (root.left == null) {
            return 1 + maxDepthDFS(root.right);
        }
        if (root.right == null) {
            return 1 + maxDepthDFS(root.left);
        }

        return 1 + Math.max(maxDepthDFS(root.left), maxDepthDFS(root.right));
    }
}
