package src.problems;

import java.util.LinkedList;
import java.util.Queue;

//
public class SameTree {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, null, null));
        TreeNode root2 = new TreeNode(1, new TreeNode(3, null, null), new TreeNode(3, null, null));

        System.out.println(isSameTreeRecurion(root1, root2));
        System.out.println(isSameTreeIteration(root1, root2));

    }

    //Time complexity : O(N) since each node is visited
    //exactly once.
    //
    //Space complexity : O(N) in the worst case, where the tree is a perfect fully balanced binary tree, since BFS will have to store at least an entire level of the tree in the queue, and the last level has O(N) nodes.
    private static boolean isSameTreeIteration(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (p == null && q == null)
            return true;
        else if (p == null || q == null)
            return false;
        if (p != null && q != null) {
            queue.offer(p);
            queue.offer(q);
        }
        while (!queue.isEmpty()) {
            TreeNode first = queue.poll();
            TreeNode second = queue.poll();
            if (first == null && second == null)
                continue;
            if (first == null || second == null)
                return false;
            if (first.val != second.val)
                return false;
            queue.offer(first.left);
            queue.offer(second.left);
            queue.offer(first.right);
            queue.offer(second.right);
        }
        return true;

    }

    public static boolean check(TreeNode p, TreeNode q) {
        // p and q are null
        if (p == null && q == null) return true;
        // one of p and q is null
        if (q == null || p == null) return false;
        if (p.val != q.val) return false;
        return true;
    }

    //Time complexity : O(N),
    //where N is a number of nodes in the tree, since one visits
    //each node exactly once.
    //
    //Space complexity : O(N) in the worst case of completely unbalanced tree, to keep a recursion stack.
    public static boolean isSameTreeRecurion(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;

        if (root1.val != root2.val) return false;
        return isSameTreeRecurion(root1.right, root2.right) && isSameTreeRecurion(root1.left, root2.left);

    }
}
