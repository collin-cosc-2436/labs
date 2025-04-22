package module_11;

public class BinarySearchTree {

    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int key) {
        root = insertRecord(root, key);
    }

    private Node insertRecord(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key) {
            root.left = insertRecord(root.left, key);
        } else if (key > root.key) {
            root.right = insertRecord(root.right, key);
        }
        return root;
    }

    public void inorder() {
        System.out.println("Inorder traversal of Binary Search Tree");
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.key + "  ");
            inOrderRec(root.right);
        }
    }

    public boolean search(int key) {
        return searchRec(root, key);
    }

    private boolean searchRec(Node root, int key) {
        //base case
        if (root == null) {
            return false;
        }
        if (root.key == key) {
            return true;
        }
        if (root.key < key) {
            return searchRec(root.right, key);
        }

        return searchRec(root.left, key);
    }

    public void delete(int key) {
        root = deleteRec(root, key);
    }

    private Node deleteRec(Node root, int key) {

        if (root == null) {
            return root;
        }

        if(key < root.key) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.key) {
            root.right = deleteRec(root.right, key);
        }else{
            // Node either leaf or has one child.
            if(root.left ==null){
                return root.right;
            }else if (root.right ==null){
                return root.left;
            }

            //Node with two children


            //



        }



        return root;
    }

}

