// Class for merging two trees
public class MergeBinaryTree {
    AVL avl = new AVL();
    Rotation rotation = new Rotation();

    public Node merge(Node t1, Node t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }

        Node merged = new Node(t1.key + t2.key);
        merged.left = merge(t1.left, t2.left);
        merged.right = merge(t1.right, t2.right);

        // Balancing the merged tree
        if (!avl.checkBalance(merged)) {
            int balance = avl.height(merged.left) - avl.height(merged.right);

            if (balance > 1 && avl.height(merged.left.left) >= avl.height(merged.left.right))
                return rotation.singleRotateRight(merged);

            if (balance > 1 && avl.height(merged.left.right) > avl.height(merged.left.left))
                return rotation.doubleRotateLR(merged);

            if (balance < -1 && avl.height(merged.right.right) >= avl.height(merged.right.left))
                return rotation.singleRotateLeft(merged);

            if (balance < -1 && avl.height(merged.right.left) > avl.height(merged.right.right))
                return rotation.doubleRotateRL(merged);
        }

        return merged;
    }
}
