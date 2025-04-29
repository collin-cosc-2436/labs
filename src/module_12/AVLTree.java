package module_12;

import module_11.Node;

public class AVLTree {
    AVLNode root;

    public AVLTree() {
        this.root = null;
    }


    public int height(AVLNode node) {
        return node == null ? 0 : node.height;
    }

    public void updateHeight(AVLNode node) {
        if (node != null){
            updateHeight(node.left);
            updateHeight(node.right);
            node.height = Math.max(height(node.left), height(node.right)) + 1;
        }
    }


    public void updateBalanceFactor(AVLNode node) {
        if (node != null) {
            updateBalanceFactor(node.left);
            updateBalanceFactor(node.right);
            node.balanceFactor = height(node.left) - height(node.right);
        }
    }


    public void printTree(AVLNode node) {
        if (node != null) {
            printTree(node.left);
            System.out.println("Node: " + node);
            System.out.println("LNode: " + node.left);
            System.out.println("RNode: " + node.right);
            printTree(node.right);
        }
    }

    public void insert(int key) {
        root = insertRecord(root, key);
    }

    private AVLNode insertRecord(AVLNode node, int key) {
        if (node == null) {
            return new AVLNode(key);
        }

        if (key < node.key) {
            node.left = insertRecord(node.left, key);
        } else if (key > node.key) {
            node.right = insertRecord(node.right, key);
        } else {
            return node; //Duplicate value
        }


        //updateHeight and bf
        updateHeight(node);
        updateBalanceFactor(node);


        if(Math.abs(node.balanceFactor)>1){
            System.out.println("Balance has been DISRUPTED at node: "+node);

            //check for imbalance unbalance
        findImbalanceType(node, key);

        //self balance
            return selfBalance(node);
        }




        //

        return node;

    }

    private AVLNode selfBalance(AVLNode node) {
        int balanceFactor = node.balanceFactor;

        if (balanceFactor > 1) {
            // check left child balance factor
            AVLNode leftChild = node.left;
            if(leftChild.balanceFactor>0){
                //LL so do single right rotation.
                return llBalance(node);
            }else{
                //LR
                return lrBalance(node);
            }
        }
        else if (balanceFactor < -1) {
            AVLNode rightChild = node.right;
            if(rightChild.balanceFactor<0){
                return rrBalance(node);
            }else{
                //RL
            }
        }

        return node;

    }

    private AVLNode llBalance(AVLNode parent) {

        AVLNode leftChild = parent.left;

        AVLNode leftRightTree = leftChild.right;

        leftChild.right = parent;
        parent.left = leftRightTree;

        updateHeight(leftChild);
        updateBalanceFactor(leftChild);

        return leftChild;
    }
    private AVLNode lrBalance(AVLNode parent) {


        AVLNode lNode = parent.left;  //10
        AVLNode lrNode  = lNode.right;  //20

        AVLNode lrLeftTree = lrNode.left;  //20's left tree
        AVLNode lrRightTree = lrNode.right;  //20's right
        parent.left = lrRightTree; // 30's left is 20's right
        lNode.right = lrLeftTree; //10's right is 20's left tree
        lrNode.left = lNode;


        updateHeight(lrNode);
        updateBalanceFactor(lrNode);

        return lrNode;
    }

    private AVLNode rrBalance(AVLNode parent) {

        AVLNode rightChild = parent.right;

        AVLNode rightLeftTree = rightChild.left;

        //rotation
        rightChild.left = parent;
        parent.right = rightLeftTree;

        updateHeight(rightChild);
        updateBalanceFactor(rightChild);

        return rightChild;
    }

    private void findImbalanceType(AVLNode node, int key) {
        int balanceFactor = node.balanceFactor;


        //left heavy
        if (balanceFactor > 1) {
            if (key < node.left.key) {
                //this is LL
                System.out.println("LL imbalance happened: node: " + node.key + " balanceFactor: " + balanceFactor);
            } else {
                System.out.println("LR imbalance happened: node: " + node.key + " balanceFactor: " + balanceFactor);
//                this is LR
            }
        }
        //right heavy
        else if (balanceFactor < -1) {
            if (key > node.right.key) {
                System.out.println("RR imbalance happened: node: " + node.key + " balanceFactor: " + balanceFactor);
            } else {
                System.out.println("RL imbalance happened: node: " + node.key + " balanceFactor: " + balanceFactor);
            }
        }

    }
}
