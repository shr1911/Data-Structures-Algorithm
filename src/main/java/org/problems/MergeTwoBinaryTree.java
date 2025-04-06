package org.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MergeTwoBinaryTree {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1, new TreeNode(3, new TreeNode(5, null, null), null), new TreeNode(2, null, null));
        TreeNode root2 = new TreeNode(2, new TreeNode(1, null, new TreeNode(4, null, null)), new TreeNode(3, null, new TreeNode(7, null, null)));

        TreeNode rootMerged = mergeTreesRecursive(root1, root2);
        rootMerged = mergeTreesIterative(root1, root2);

    }

    //Time complexity : O(n). We traverse over a total of n nodes. Here, n refers to the smaller of the number of nodes in the two trees.
    //
    //Space complexity : O(n). The depth of stack can grow upto n in case of a skewed tree.
    private static TreeNode mergeTreesIterative(TreeNode root1, TreeNode root2) {
        if (root1 == null)
            return root2;

        Queue<TreeNode[]> queue = new LinkedList<>();
        queue.add(new TreeNode[] { root1, root2 });

        while(!queue.isEmpty()) {
            TreeNode[] currentNodes = queue.poll();

            if(currentNodes[0] == null || currentNodes[1] == null) {
                continue;
            }

            currentNodes[0].val += currentNodes[1].val;

            if (currentNodes[0].left == null ){
                currentNodes[0].left = currentNodes[1].left;
            } else {
                queue.add(new TreeNode[] { currentNodes[0].left, currentNodes[1].left});
            }

            if (currentNodes[0].right == null ){
                currentNodes[0].right = currentNodes[1].right;
            } else {
                queue.add(new TreeNode[] {currentNodes[0].right, currentNodes[1].right});
            }
        }

        return root1;
    }

    //Time complexity : O(m). A total of m nodes need to be traversed. Here, m represents the minimum number of nodes from the two given trees.
    //
    //Space complexity : O(m). The depth of the recursion tree can go upto m in the case of a skewed tree. In average case, depth will be O(logm).
    public static TreeNode mergeTreesRecursive(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        root1.val += root2.val;
        root1.left = mergeTreesRecursive(root1. left, root2.left);
        root1.right = mergeTreesRecursive(root1.right, root2.right);

        return root1;
    }
}
