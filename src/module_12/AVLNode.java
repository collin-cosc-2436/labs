package module_12;

public class AVLNode {
    int key;
    int height;
    int balanceFactor;
    AVLNode left;
    AVLNode right;

    public AVLNode(int key) {
        this.key = key;
        left = right = null;
        balanceFactor = 0;
        height = 1;
    }

    @Override
    public String toString() {
        return "key: " + key + ", height: " + height + ", balanceFactor: " + balanceFactor;
    }
}