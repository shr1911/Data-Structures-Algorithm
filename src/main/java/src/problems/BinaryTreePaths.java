package src.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePaths {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(5, null, null)), new TreeNode(3, null, null));
        System.out.println(binaryTreePathsRecursive(root));

        System.out.println();
    }


    //Time complexity: O(N) since each node is visited exactly once.
    //Space complexity: O(N) as we could keep up to the entire tree.
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null)
            return paths;

        LinkedList<TreeNode> node_stack = new LinkedList();
        LinkedList<String> path_stack = new LinkedList();
        node_stack.add(root);
        path_stack.add(Integer.toString(root.val));
        TreeNode node;
        String path;

        while ( !node_stack.isEmpty() ) {
            node = node_stack.pollLast();
            path = path_stack.pollLast();
            if ((node.left == null) && (node.right == null))
                paths.add(path);
            if (node.left != null) {
                node_stack.add(node.left);
                path_stack.add(path + "->" + Integer.toString(node.left.val));
            }
            if (node.right != null) {
                node_stack.add(node.right);
                path_stack.add(path + "->" + Integer.toString(node.right.val));
            }
        }
        return paths;
    }

    //Time complexity: O(NlogN)
    //We visit each node exactly once, which contributes O(N) to the time complexity.
    //At each node, we are copying the current path to store it. The length of the path is proportional to the height of the tree, which is logN. Since this copying operation occurs for each node, and there are N nodes, this contributes an additional O(NlogN) complexity due to copying paths.
    //Combining these factors, the total time complexity is O(NlogN). This is because, although we visit each node once, the cost of copying paths (which can be proportional to the height of the tree) adds a logN factor to the complexity.
    //
    //Space complexity: O(N)
    //Here we use the space for a stack call and for a paths list to store the answer. paths contains as many elements as leaves in the tree and hence couldn't be larger than logN for the trees containing more than one element. Hence the space complexity is determined by a stack call. In the worst case, when the tree is completely unbalanced, e.g. each node has only one child node, the recursion call would occur N times (the height of the tree), therefore the storage to keep the call stack would be O(N). But in the best case (the tree is balanced), the height of the tree would be log(N). Therefore, the space complexity in this case would be O(log(N)).
    public static List<String> binaryTreePathsRecursive(TreeNode root) {
        List<String> paths = new ArrayList<>();
        construct_paths(root, "", paths);
        return paths;
    }

    public static void construct_paths(TreeNode root, String path, List<String> paths) {
        if (root != null) {
            path += Integer.toString(root.val);
            if ((root.left == null) && (root.right == null))  // if reach a leaf
                paths.add(path);  // update paths
            else {
                path += "->";  // extend the current path
                construct_paths(root.left, path, paths);
                construct_paths(root.right, path, paths);
            }
        }
    }
}
