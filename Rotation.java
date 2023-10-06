// Class for rotations
public class Rotation {

    public Node singleRotateRight(Node y) {
        Node x = y.left;
        Node T2 = x.right;
        x.right = y;
        y.left = T2;
        return x;
    }

    public Node singleRotateLeft(Node x) {
        Node y = x.right;
        Node T2 = y.left;
        y.left = x;
        x.right = T2;
        return y;
    }

    public Node doubleRotateLR(Node y) {
        y.left = singleRotateLeft(y.left);
        return singleRotateRight(y);
    }

    public Node doubleRotateRL(Node x) {
        x.right = singleRotateRight(x.right);
        return singleRotateLeft(x);
    }
}

