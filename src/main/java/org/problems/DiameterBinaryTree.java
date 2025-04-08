package org.problems;

public class DiameterBinaryTree {

    private static int diameter;

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)), new TreeNode(3, null, null));
        System.out.println(diameterOfBinaryTree(root1));
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        longestPath(root);
        return diameter;
    }

    //Time complexity: O(N). This is because in our recursion function longestPath, we only enter and exit from each node once. We know this because each node is entered from its parent, and in a tree, nodes only have one parent.
    //
    //Space complexity: O(N). The space complexity depends on the size of our implicit call stack during our DFS, which relates to the height of the tree. In the worst case, the tree is skewed so the height of the tree is O(N). If the tree is balanced, it'd be O(logN).
    private static int longestPath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftPath = longestPath(root.left);
        int rightPath = longestPath(root.right);

        diameter = Math.max(diameter, leftPath + rightPath);

        return Math.max(leftPath, rightPath) + 1;
    }
}
