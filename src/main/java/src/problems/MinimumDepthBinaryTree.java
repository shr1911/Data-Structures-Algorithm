package src.problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 */
public class MinimumDepthBinaryTree {
    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(3, new TreeNode(9, null, null), new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7, null, null)));
        System.out.println(minDepth(root1));

        System.out.println(minDepthBFS(root1));
    }

    private static int minDepthBFS(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 1;

        while (!queue.isEmpty()) {
            int queueSize = queue.size();

            while (queueSize > 0) {
                queueSize--;

                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }

                if (node.left == null && node.right == null) {
                    return depth;
                }

                queue.add(node.left);
                queue.add(node.right);
            }
            depth++;
        }

        return -1;
    }

    public static int minDepth(TreeNode root) {
        return dfs(root);
    }

    //Time complexity: O(N)
    //
    //We will traverse each node in the tree only once; hence, the total time complexity would be O(N).
    //
    //Space complexity: O(N)
    //
    //The only space required is the stack space; the maximum number of active stack calls would equal the maximum depth of the tree, which could equal the total number of nodes in the tree. Hence, the space complexity would equal O(N).
    private static int dfs(TreeNode root) {
        if (root == null) return 0;

        if (root.left == null)
            return 1 + dfs(root.right);
        else if (root.right == null)
            return 1 + dfs(root.left);

        return 1 + Math.min(dfs(root.left), dfs(root.right));
    }
}

