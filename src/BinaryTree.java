public class BinaryTree {
    // Root of Binary Tree
    public Node root;

    // Constructors
    public BinaryTree(int key) {
        root = new Node(key);
    }

    public BinaryTree() {
        root = null;
    }
}

class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}
