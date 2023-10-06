// Class for AVL operations
public class AVL {
    // Method to get height of the node
    public int height(Node node) {
        if (node == null)
            return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    // Method to check balance of the tree
    public boolean checkBalance(Node node) {
        if (node == null)
            return true;
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return Math.abs(leftHeight - rightHeight) <= 1 && checkBalance(node.left) && checkBalance(node.right);
    }
}
