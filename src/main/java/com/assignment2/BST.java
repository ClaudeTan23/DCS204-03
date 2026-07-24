package com.assignment2;

/**
 * Binary Search Tree
 */
public class BST {

    private TreeNode root;

    /**
     * Constructor
     */
    public BST() {
        root = null;
    }

    // =====================================================
    // Check Empty
    // =====================================================

    public boolean isEmpty() {
        return root == null;
    }

    // =====================================================
    // Insert
    // =====================================================

    public void insert(int value) {

        root = insert(root, value);

    }

    private TreeNode insert(TreeNode node, int value) {

        if (node == null) {
            return new TreeNode(value);
        }

        if (value < node.value) {

            node.left = insert(node.left, value);

        } else if (value > node.value) {

            node.right = insert(node.right, value);

        } else {

            System.out.println("Duplicate value is not allowed.");

        }

        return node;

    }

    // =====================================================
    // Search
    // =====================================================

    public boolean search(int value) {

        return search(root, value);

    }

    private boolean search(TreeNode node, int value) {

        if (node == null)
            return false;

        if (node.value == value)
            return true;

        if (value < node.value)
            return search(node.left, value);

        return search(node.right, value);

    }

    // =====================================================
    // Find Minimum
    // =====================================================

    public int findMin() {

        if (root == null)
            throw new IllegalStateException("Tree is empty.");

        TreeNode current = root;

        while (current.left != null) {
            current = current.left;
        }

        return current.value;

    }

    // =====================================================
    // Find Maximum
    // =====================================================

    public int findMax() {

        if (root == null)
            throw new IllegalStateException("Tree is empty.");

        TreeNode current = root;

        while (current.right != null) {
            current = current.right;
        }

        return current.value;

    }

    // =====================================================
    // Delete
    // =====================================================

    public void delete(int value) {

        if (!search(value)) {

            System.out.println("Value not found.");
            return;

        }

        root = delete(root, value);

        System.out.println("Value deleted successfully.");

    }

    private TreeNode delete(TreeNode node, int value) {

        if (node == null)
            return null;

        if (value < node.value) {

            node.left = delete(node.left, value);

        } else if (value > node.value) {

            node.right = delete(node.right, value);

        } else {

            // No child
            if (node.left == null && node.right == null)
                return null;

            // One child
            if (node.left == null)
                return node.right;

            if (node.right == null)
                return node.left;

            // Two children
            TreeNode successor = getMinNode(node.right);

            node.value = successor.value;

            node.right = delete(node.right, successor.value);

        }

        return node;

    }

    private TreeNode getMinNode(TreeNode node) {

        while (node.left != null) {
            node = node.left;
        }

        return node;

    }

    // =====================================================
    // Inorder Traversal
    // =====================================================

    public void inorder() {

        System.out.print("Inorder   : ");

        inorder(root);

        System.out.println();

    }

    private void inorder(TreeNode node) {

        if (node == null)
            return;

        inorder(node.left);

        System.out.print(node.value + " ");

        inorder(node.right);

    }

    // =====================================================
    // Preorder Traversal
    // =====================================================

    public void preorder() {

        System.out.print("Preorder  : ");

        preorder(root);

        System.out.println();

    }

    private void preorder(TreeNode node) {

        if (node == null)
            return;

        System.out.print(node.value + " ");

        preorder(node.left);

        preorder(node.right);

    }

    // =====================================================
    // Postorder Traversal
    // =====================================================

    public void postorder() {

        System.out.print("Postorder : ");

        postorder(root);

        System.out.println();

    }

    private void postorder(TreeNode node) {

        if (node == null)
            return;

        postorder(node.left);

        postorder(node.right);

        System.out.print(node.value + " ");

    }

    // =====================================================
    // Tree Height
    // =====================================================

    public int height() {
        return height(root);
    }

    private int height(TreeNode node) {

        if (node == null)
            return -1;

        return Math.max(height(node.left), height(node.right)) + 1;

    }

    // =====================================================
    // Total Nodes
    // =====================================================

    public int totalNodes() {
        return totalNodes(root);
    }

    private int totalNodes(TreeNode node) {

        if (node == null)
            return 0;

        return totalNodes(node.left)
                + totalNodes(node.right)
                + 1;

    }

    // =====================================================
    // Leaf Nodes
    // =====================================================

    public int leafNodes() {
        return leafNodes(root);
    }

    private int leafNodes(TreeNode node) {

        if (node == null)
            return 0;

        if (node.left == null && node.right == null)
            return 1;

        return leafNodes(node.left)
                + leafNodes(node.right);

    }

    // =====================================================
    // Display Traversals
    // =====================================================

    public void displayTraversals() {

        if (root == null) {

            System.out.println("Tree is empty.");
            return;

        }

        System.out.println("\n========== TREE TRAVERSALS ==========");

        inorder();
        preorder();
        postorder();
        displayTree();

    }

    // =====================================================
    // Display Properties
    // =====================================================

    public void displayProperties() {

        if (root == null) {

            System.out.println("Tree is empty.");
            return;

        }

        System.out.println("\n========== TREE PROPERTIES ==========");

        System.out.println("Minimum Value : " + findMin());
        System.out.println("Maximum Value : " + findMax());
        System.out.println("Tree Height   : " + height());
        System.out.println("Total Nodes   : " + totalNodes());
        System.out.println("Leaf Nodes    : " + leafNodes());

    }

    // =====================================================
    // Display Tree (Sideways)
    // =====================================================

    public void displayTree() {

        if (root == null) {

            System.out.println("Tree is empty.");
            return;

        }

        System.out.println("\n========== BINARY SEARCH TREE ==========");

        displayTree(root, 0);

    }

    private void displayTree(TreeNode node, int level) {

        if (node == null)
            return;

        displayTree(node.right, level + 1);

        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }

        System.out.println(node.value);

        displayTree(node.left, level + 1);

    }

}