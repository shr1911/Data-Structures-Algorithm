package org.problems;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
 *
 * A leaf is a node with no children.
 */
public class TreePathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,
                new TreeNode(4, new TreeNode(11, new TreeNode(7, null, null), new TreeNode(2, null, null)), null),
                new TreeNode(8, new TreeNode(13, null, null), new TreeNode(4, null, new TreeNode(1, null, null))));

        System.out.println(hasPathSumRecursion(root, 22));

        System.out.println(hasPathSumIterative(root, 26));

    }

    private static boolean hasPathSumIterative(TreeNode root, int targetSum) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> sum = new LinkedList<>();

        queue.add(root);
        sum.add(targetSum - root.val);

        TreeNode node;
        int curr_sum;

        while (!queue.isEmpty()) {
            node = queue.poll();
            curr_sum = sum.poll();

            if (node.right == null && node.left == null && curr_sum == 0){
                return true;
            }
            if (node.left != null) {
                queue.add(node.left);
                sum.add(curr_sum - node.left.val);
            }

            if (node.right != null) {
                queue.add(node.right);
                sum.add(curr_sum - node.right.val);
            }
        }
        return false;
    }

    //Time complexity : we visit each node exactly once, thus the time complexity is O(N), where N is the number of nodes.
    //Space complexity : in the worst case, the tree is completely unbalanced, e.g. each node has only one child node, the recursion call would occur N times (the height of the tree), therefore the storage to keep the call stack would be O(N). But in the best case (the tree is completely balanced), the height of the tree would be log(N). Therefore, the space complexity in this case would be O(log(N)).
    public static boolean hasPathSumRecursion(TreeNode root, int targetSum) {
        if (root == null) return false;
        targetSum = targetSum - root.val;
        if ((root.left == null && root.right == null)) return (targetSum == 0);

        return hasPathSumRecursion(root.left, targetSum) || hasPathSumRecursion(root.right, targetSum);

    }

}
