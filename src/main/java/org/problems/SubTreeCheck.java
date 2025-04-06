package org.problems;

public class SubTreeCheck {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(4, new TreeNode(1, null, null), new TreeNode(2, null, null)), new TreeNode(5, null, null));
        TreeNode subRoot = new TreeNode(4, new TreeNode(1, null, null), new TreeNode(2, null, null));

        System.out.println(isSubtree(root, subRoot));

        // ToDo: Implement another solution with better time complexity
    }

    //Time complexity: O(MN). For every N node in the tree, we check if the tree rooted at node is identical to subRoot. This check takes O(M) time, where M is the number of nodes in subRoot. Hence, the overall time complexity is O(MN).
    //
    //Space complexity: O(M+N).
    //
    //There will be at most N recursive call to dfs ( or isSubtree). Now, each of these calls will have M recursive calls to isIdentical. Before calling isIdentical, our call stack has at most O(N) elements and might increase to O(N+M) during the call. After calling isIdentical, it will be back to at most O(N) since all elements made by isIdentical are popped out. Hence, the maximum number of elements in the call stack will be M+N.
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {

        // If this node is Empty, then no tree is rooted at this Node
        // Hence, "tree rooted at node" cannot be equal to "tree rooted at subRoot"
        // "tree rooted at subRoot" will always be non-empty, as per constraints
        if (root == null) {
            return false;
        }

        // Check if the "tree rooted at root" is identical to "tree roooted at subRoot"
        if (isIdentical(root, subRoot)) {
            return true;
        }

        // If not, check for "tree rooted at root.left" and "tree rooted at root.right"
        // If either of them returns true, return true
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private static boolean isIdentical(TreeNode node1, TreeNode node2) {

        // If any of the nodes is null, then both must be null
        if (node1 == null || node2 == null) {
            return node1 == null && node2 == null;
        }

        // If both nodes are non-empty, then they are identical only if
        // 1. Their values are equal
        // 2. Their left subtrees are identical
        // 3. Their right subtrees are identical
        return node1.val == node2.val && isIdentical(node1.left, node2.left) && isIdentical(node1.right, node2.right);
    }

}
