package org.ds;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Depth = level
 * Maximum depth = height of tree
 * Height - no. of edges in longest path from root to leaf
 * H of empty tree - -1
 * H of tree with 1 node - 0
 * Balanced Binary Search Tree
 * Memory divided - code (text instruction) + Static/global / stack / heap
 */
public class BinarySearchTree {
    public static void main(String[] args) {
        BstNode root = null;

        //Time - O(log(n))
        BinarySearchTree tree = new BinarySearchTree();
        root = tree.insert(root, 15);
        root = tree.insert(root, 10);
        root = tree.insert(root, 20);
        root = tree.insert(root, 30);



        // Time - O(log(n)) - O(height)
        System.out.println(tree.search(root, 8));
        System.out.println(tree.search(root, 15));


        // Time - O(log(n)) - as worst case will be height O(n)
        System.out.println(tree.findMin(root));
        System.out.println(tree.findMax(root));

        System.out.println(tree.findMinRecursive(root));
        System.out.println(tree.findMaxRecursive(root));

        // O(n)
        System.out.println(tree.findHeight(root));

        // BFS = level order traversal (start from root (depth 0, and go level by level))
        // USe Queue to keep track of children of nodes that we are visiting
        // Time - complexity - O(n)
        // space- - not using extra memory - Queue - will grow and shrink - will dpened maximum elements in Q at any time
        // most unbalance - max one element in queue (best case = o(1))
        // Perfect complete binary tree - at some point all all the nodes in that level will be in Q (Worst case/Average - O(n))
        tree.levelOrderTraversal(root);

        // DFS (root means - we are reading data)
        // -> Can be preorder (root, l, r), inorder (l, root, r), postorder (l, r, root)
        // space complexity - measure of rate of growth of extra memory used wit input will - here depend upon extra memory of call stack used in call stack
        // We are not extra memory, but function call stack due to recursion - memory used, and will be removed when function call finishes
        // Call stack grows max  until leaf node (means height), and then starts shrinking
        // space complexity - O(height) (worst case - fully unbalanced tree - O(n-1)) (best/average case - perfect binary tree- O(lon(n)))
        // Time - O (n) - one function call for each node - visiting each node
        System.out.println("\npreOrderTraversal");
        tree.preOrderTraversal(root);
        System.out.println("\ninOrderTraversal");
        tree.inOrderTraversal(root);
        System.out.println("\npostOrderTraversal");
        tree.postOrderTraversal(root);
        System.out.println();


        // Lot of traversal of recursion, subtree functions are very expensive
        // Time complexity - O(n ^ 2) -

        System.out.println();
        System.out.println(isBST(root));


        // Simply check if data in this node in that range or not
        // Time complexity - O(n) - each node checking once that if it's in range or not
        System.out.println();
        System.out.println(isBSTOptimized(root));

        // Another solution.
        // Traverse as in order traversal, it will give as sorted data in order
        // During traversal only need to keep a track of previously read node,
        // and at any time data in a node that you're reading must be greater than the data in previously read node

        // ToDo: check how will we manage duplicates while checking isBinarySeachTree or not ?

        // leaf node delete scenario, one child scenario, two child scenario
        // 2 child case - deleteing in right of root - bring minimum in right subtree to the place where deleting, it will not have left child
        // they may or may not have right child, if right child it will case 2, if no right child it will be case 1
        // for 2 child case - can do opposite, choose max in left ......
        // time compexity - O(log(n))
        // space compexlity - best - O(log n) perfect binary tree, worst O(n) - skew tree
        // In iterative apprach space - O(1), and time O(n)
        tree.delete(root, 10);

        // For given node find in order
        // Normal way after doing inorder find - O(n) time
        // We want in O(height) since it's BST - O(long to the base 2)
        // ******* SO FAR MOST difficult
        System.out.println(tree.findInorderSuccessor(root, 10));

        //ToDo: find inorder predecessor - write the function for the same. Need to think

    }

    // O(height)
    private BstNode findInorderSuccessor(BstNode root, int data) {
        // SearchNode is O(height)
        BstNode current = searchNode(root, data);
        if (current == null) return null;
        //case 1: Node has right subtree - go deep in left most node in right subtree or find mi in right subtree
        if (current.right != null) {
            return findMinNode(current.right); //O(height)
        }
        //case 2: No right subtree - go to the nearest ancestor for which given node would be in left subtree
        // O(height)
        else {
            BstNode successor = null;
            BstNode ancestor = root;
            while (ancestor != current) {
                if (current.data < ancestor.data) {
                    successor = ancestor; // so  far this is the deepest node for which current node is in left
                    ancestor = ancestor.left;
                } else {
                    ancestor = ancestor.right;
                }
            }
        }
    }


    private BstNode delete(BstNode root, int data) {
        if (root == null) return root;
        else if (data < root.data) root.left = delete(root.left, data);
        else if (data > root.data) root.right = delete(root.right, data);
        else { // found the data, now start delete logic
            // case 1 - no child
            if (root.left == null && root.right == null) {
                root = null;
                return root;
            }
            // case 2 - one child
            else if (root.left == null ) {
                root = root.right;
                return root;
            }
            else if (root.right == null ) {
                root = root.left;
                return root;
            }
            // case 3 - 2 child
            else {
                BstNode temp = findMinNode(root.right);
                root.data = temp.data;
                root.right = delete(root.right, temp.data)
            }

        }

    }

    private static boolean isBSTOptimized(BstNode root) {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBSTUtil(BstNode root, int minValue, int maxValue) {
        if (root == null) return true;

        //Can write find min and find max instead these two subtree function. max in left for to check lesser, min in right for check greater
        if (root.data > minValue && root.data < maxValue
                && isBSTUtil(root.left, minValue, root.data)
                && isBSTUtil(root.right, root.data, maxValue)){
            return true;
        } else return false;
    }

    private static boolean isBST(BstNode root) {
        if (root == null) return true;

        //Can write find min and find max instead these two subtree function. max in left for to check lesser, min in right for check greater
        if (isSubtreeLesser(root.left, root.data)
                && isSubtreeGreater(root.right, root.data)
                && isBST(root.left)
                && isBST(root.right)){
            return true;
        } else return false;
    }

    private static boolean isSubtreeGreater(BstNode root, int data) {
        if (root == null) return true;
        if (root.data > data && isSubtreeGreater(root.left, data) && isSubtreeGreater(root.right, data)) {
            return true;
        }
        else return false;
    }

    private static boolean isSubtreeLesser(BstNode root, int data) {
        if (root == null) return true;
        if (root.data <= data && isSubtreeLesser(root.left, data) && isSubtreeLesser(root.right, data)) {
            return true;
        }
        else return false;
    }

    private void postOrderTraversal(BstNode root) {
        if(root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    private void inOrderTraversal(BstNode root) {
        if(root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    private void preOrderTraversal(BstNode root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    private static void levelOrderTraversal(BstNode root) {
        if (root == null) return;

        Queue<BstNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            BstNode current = queue.poll();
            System.out.print(current.data + " ");
            if (current.left != null) queue.offer(current.left);
            if (current.right != null) queue.offer(current.right);
        }

    }

    //Height = max depth - O(n))
    //Height of tree = height of root node
    //Height of leaf node/empty tree/ tree with 1 node= 0
    //Height of a node - No. of edges in the longest path from the node to a leaf node
    //Depth of node - No. of edges in path from root to that node

    // Height = max(height(left sub tree), height(right sub tree)) + 1
    private int findHeight(BstNode root) {
        if (root == null) {
            // Return 0, if you definition of height no. of nodes, here we are counting no. edges in nodes
            return -1;
        }
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);

        return Integer.max(leftHeight, rightHeight) + 1;
    }

    private int findMaxRecursive(BstNode root) {
        if (root == null) {
            System.out.println("Error: tree is empty");
            return -1;
        }
        else if (root.right == null){
            return root.data;
        } else {
            return findMinRecursive(root.right);
        }
    }

    private int findMinRecursive(BstNode root) {
        if (root == null) {
            System.out.println("Error: tree is empty");
            return -1;
        }
        else if (root.left == null){
            return root.data;
        } else {
            return findMinRecursive(root.left);
        }
    }

    private int findMax(BstNode root) {
        if (root == null) {
            System.out.println("Error: tree is empty");
            return -1;
        }
        BstNode current = root;
        while(current.right != null) {
            current = current.right;
        }
        return current.data;
    }

    private int findMin(BstNode root) {
        if (root == null) {
            System.out.println("Error: tree is empty");
            return -1;
        }
        BstNode current = root;
        while(current.left != null) {
            current = current.left;
        }
        return current.data;
    }


    private BstNode findMinNode(BstNode root) {
        if (root == null) {
            System.out.println("Error: tree is empty");
            return -1;
        }
        BstNode current = root;
        while(current.left != null) {
            current = current.left;
        }
        return current;
    }

    private BstNode insert(BstNode root, int data) {
        if (root == null) {
            root = new BstNode(data);
            return root;
        } if (data <= root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }

    private boolean search(BstNode root, int data) {
        if (root == null) return false;
        else if (root.data == data) return true;
        else if (data <= root.data) return search(root.left, data);
        else return search(root.right, data);
    }

    private BstNode searchNode(BstNode root, int data) {
        if (root == null) return null;
        else if (root.data == data) return root;
        else if (data <= root.data) return searchNode(root.left, data);
        else return searchNode(root.right, data);
    }
}


class BstNode {
    int data;
    BstNode left;
    BstNode right;


    public BstNode(int data) {
        this.data = data;
    }
}
