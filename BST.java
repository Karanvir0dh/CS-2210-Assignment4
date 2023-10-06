public class BST {
    Node root;
    MergeBinaryTree mergeBinaryTree = new MergeBinaryTree();

    // BST constructor
    public BST() {
        root = null;
    }

    // Insertion method
    public void insert(int key) {
        root = insert(root, key);
    }

    // Insertion method with balancing
    public Node insert(Node node, int key) {
        AVL avl = new AVL();
        Rotation rotation = new Rotation();

        // Simple BST insert
        if (node == null)
            return new Node(key);
        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else
            return node;

        // Balancing Tree
        if (!avl.checkBalance(node)) {
            int balance = avl.height(node.left) - avl.height(node.right);

            // If left child is heavier
            if (balance > 1 && avl.height(node.left.left) >= avl.height(node.left.right))
                return rotation.singleRotateRight(node);

            // If right child of left subtree is heavier
            if (balance > 1 && avl.height(node.left.right) > avl.height(node.left.left))
                return rotation.doubleRotateLR(node);

            // If right child is heavier
            if (balance < -1 && avl.height(node.right.right) >= avl.height(node.right.left))
                return rotation.singleRotateLeft(node);

            // If left child of right subtree is heavier
            if (balance < -1 && avl.height(node.right.left) > avl.height(node.right.right))
                return rotation.doubleRotateRL(node);
        }
        return node;
    }

    // Inorder print method
    public static void printInorder(Node node) {
        if (node != null) {
            printInorder(node.left);
            System.out.print(node.key + " ");
            printInorder(node.right);
        }
    }


    public static void main(String[] args) {
        BST tree1 = new BST();
        tree1.root = new Node(23);
        tree1.root.left = new Node(17);
        tree1.root.left.left = new Node(9);
        tree1.root.right = new Node(39);
        tree1.root.right.right = new Node(78);
        tree1.root.right.right.left = new Node(61);

        BST tree2 = new BST();
        tree2.root = new Node(18);
        tree2.root.left = new Node(15);
        tree2.root.left.right = new Node(16);
        tree2.root.left.right.left = new Node(19);
        tree2.root.right = new Node(20);
        tree2.root.right.right = new Node(25);

        MergeBinaryTree mergeBinaryTree = new MergeBinaryTree();
        Node mergedTreeRoot = mergeBinaryTree.merge(tree1.root, tree2.root);

        printInorder(mergedTreeRoot);
    }
}
