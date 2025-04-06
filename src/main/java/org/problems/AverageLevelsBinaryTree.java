package org.problems;

import java.util.*;

public class AverageLevelsBinaryTree {
    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(3, new TreeNode(9, null, null), new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7, null, null)));
        System.out.println(averageOfLevelsDFS(root1));

        System.out.println(averageOfLevelsBFS(root1));

    }

    //Time complexity : O(n). The whole tree is traversed at most once. Here, n refers to the number of nodes in the given binary tree.
    //
    //Space complexity : O(m). The size of queue or temp can grow upto at most the maximum number of nodes at any level in the given binary tree. Here, m refers to the maximum mumber of nodes at any level in the input tree.
    private static List<Double> averageOfLevelsBFS(TreeNode root) {
        List <Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            long sum = 0, count = 0;
            Queue <TreeNode> temp = new LinkedList<>();

            while (!queue.isEmpty()) {
                TreeNode current = queue.poll();
                sum += current.val;
                count++;
                if (current.left != null) temp.offer(current.left);
                if (current.right != null) temp.offer(current.right);
            }
            queue = temp;
            res.add(sum * 1.0 / count);
        }

        return res;
    }

    //Time complexity : O(n). The whole tree is traversed once only. Here, n refers to the total number of nodes in the given binary tree.
    //
    //Space complexity : O(h). res and count array of size h are used. Here, h refers to the height(maximum number of levels) of the given binary tree. Further, the depth of the recursive tree could go upto h only.
    public static List<Double> averageOfLevelsDFS(TreeNode root) {
        List <Integer> count = new ArrayList< >();
        List <Double> res = new ArrayList < > ();

        averageDFS(root, 0, res, count);

        for (int i = 0; i < res.size(); i++)
            res.set(i, res.get(i) / count.get(i));
        return res;
    }


    public static void averageDFS(TreeNode root, int i, List <Double> sum, List <Integer> count) {
        if (root == null) {
            return;
        }
        if (i < sum.size()) {
            sum.set(i, sum.get(i) + root.val);
            count.set(i, count.get(i) + 1);
        } else {
            sum.add(1.0 * root.val);
            count.add(1);
        }
        averageDFS(root.left, i + 1, sum, count);
        averageDFS(root.right, i +1, sum, count);
    }


}




//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

