package module_11;

public class BSTDemo {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(100);
        bst.insert(80);
        bst.insert(90);
        bst.insert(60);
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(101);
        bst.insert(100);

        bst.inorder();

        System.out.println("is 30 exist: " +bst.search(30));
        System.out.println("is 100 exist: " +bst.search(100));
        System.out.println("is 12 exist: " +bst.search(12));

        bst.delete(60);
        bst.inorder();
    }
}


