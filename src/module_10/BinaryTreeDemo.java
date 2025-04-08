package module_10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTreeArray binaryTreeArray = new BinaryTreeArray(10);
        binaryTreeArray.insert(10);
        binaryTreeArray.insert(20);
        binaryTreeArray.insert(30);
        binaryTreeArray.insert(40);
        binaryTreeArray.insert(50);
        binaryTreeArray.insert(60);

        System.out.println("Left child of 20:==>"+binaryTreeArray.getLeftChild(1));


        /**
         *          CEO(A)
         *        /       \
         *     VP(B)      VP(C)
         *    /   \       /.   \
         * MGR(D) MGR(E) MGR(F) ENG(G)
         */

        BinaryTree<Employee> tree = new BinaryTree<>();

        Employee ceo = new Employee("CEO","A");
        Employee vp1 = new Employee("VP","B");
        Employee vp2 = new Employee("VP","C");
        Employee mgr1 = new Employee("MGR","D");
        Employee mgr2 = new Employee("MGR","E");
        Employee mgr3= new Employee("MGR","F");


        tree.root = new BinaryNode<>(ceo);
        tree.root.left = new BinaryNode<>(vp1);
        tree.root.right = new BinaryNode<>(vp2);

        tree.root.left.left = new BinaryNode<>(mgr1);
        tree.root.left.right = new BinaryNode<>(mgr2);

        tree.root.right.left = new BinaryNode<>(mgr3);
        tree.root.right.right = new BinaryNode<>(new Employee("ENG","G"));

        //Display the tree company hierarchy

        System.out.println("Height of tree: "+tree.height(tree.root));

        //check if tree is CompleteTree? 
        System.out.println("IsCompleteTree "+tree.isCompleteBinaryTree());

        System.out.println("InFullBinaryTree: "+tree.isFullBinaryTree(tree.root));


        //print the tree in PreOrder Traversal
        tree.preOrderTraversal(); //  CEO(A) ==>  VP(B) ==>MGR(D) ==>MGR(E) ==> VP(C) ==>F ==>G

        //print the tree in InOrder traversal
        tree.inOrderTraversal();

        tree.postOrderTraversal();

        tree.levelOrderTraversal();
    }

}

class Employee {
    String name;
    String position;
    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public String toString() {
        return this.position + "(" + this.name+")";
    }
}

class BinaryNode<E>{
    E data;
    BinaryNode<E> left;
    BinaryNode<E> right;
    public BinaryNode(E data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree<E>{
    BinaryNode<E> root;


    public int height(BinaryNode<E> node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public boolean isEmpty() {
        return root == null;
    }

    /*
      A
     / \
    B   C
   / \
  D   E
     */

    public boolean isCompleteBinaryTree() {
        if (isEmpty()) return true;
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(this.root);

        while (!queue.isEmpty()) {
            BinaryNode node = queue.poll();
            if (node.left == null && node.right != null) {
                    return false;
            }


            if (node.left != null) { queue.add(node.left); }
            if (node.right != null) { queue.add(node.right); }
        }
        return true;
    }

    public boolean isFullBinaryTree(BinaryNode<E> node) {
        if (isEmpty()) return true;

        if(node.left == null && node.right == null) { return true; }

        if(node.left != null && node.right != null) {
            return isFullBinaryTree(node.left) && isFullBinaryTree(node.right);
        }

        return false;
    }

    public void preOrderTraversal() {
        System.out.println("Preorder traversal of Binary Tree");
        preOrderTraversal(this.root);
        System.out.println();
    }

    private void preOrderTraversal(BinaryNode<E> node) {
        if(node == null) return;
        System.out.print(node.data +"  ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public void inOrderTraversal() {
        System.out.println("Inorder traversal of Binary Tree");
        inOrderTraversal(this.root);
        System.out.println();
    }

    private void inOrderTraversal(BinaryNode<E> node) {
        if(node == null) return;
        inOrderTraversal(node.left);
        System.out.print(node.data +"  ");
        inOrderTraversal(node.right);
    }

    public void postOrderTraversal() {
        System.out.println("PostOrder traversal of Binary Tree");
        postOrderTraversal(this.root);
        System.out.println();
    }

    private void postOrderTraversal(BinaryNode<E> node) {
        if(node == null) return;
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.data +"  ");
    }

    public void levelOrderTraversal() {
        if (root == null) {
            System.out.println();
            return;
        }

        Queue<BinaryNode<?>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryNode<?> node = queue.poll();
            System.out.print(node.data + " ");

            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        System.out.println();
    }

}
















class BinaryTreeArray{
    private int[] data;
    private int size;
    public BinaryTreeArray(int capacity) {
        data = new int[capacity];
    }

    public boolean insert(int value){
            if(size == data.length){
                return false;
            }
            data[size] = value;
            size++;
            return true;
    }
    public int getLeftChild(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        int leftChildIndex = 2 * index + 1;
        if(leftChildIndex > size){
            throw new IndexOutOfBoundsException();
        }
        return this.data[leftChildIndex];
    }


}


