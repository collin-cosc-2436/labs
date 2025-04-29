package module_12;

public class AVLTreeDemo {
    public static void main(String[] args) {
//        AVLTree tree = new AVLTree();
//
//        AVLNode root = new AVLNode(50);
//        tree.root = root;
//
//        AVLNode node30 = new AVLNode(30);
//        AVLNode node70 = new AVLNode(70);
//        AVLNode node20 = new AVLNode(20);
//        AVLNode node40 = new AVLNode(40);
//        AVLNode node80 = new AVLNode(80);
//        AVLNode node10 = new AVLNode(10);
//
//        root.left = node30;
//        root.right = node70;
//
//        node30.left = node20;
//        node30.right = node40;
//
//        node70.right = node80;
//        node20.left = node10;
//

/**
//                50(4,1)
//             /           \
//           30(3,2)       80(2, 0)
//          /      \         /.  \
//         10(3,-1) 40(1,0) 70(1,0)  90(1,0)
//        /.   \
//       5(1,0) 20(2,-1)
                 \
                 25(1,0)

 */
//
//
//        tree.updateHeight(tree.root);
//        tree.updateBalanceFactor(root);
//        System.out.println("height: "+tree.height(tree.root));
//        System.out.println("bf: "+tree.balanceFactor(tree.root));
//        tree.printTree(tree.root);


        AVLTree tree2 = new AVLTree();
        tree2.insert(50);
        tree2.insert(30);
        tree2.insert(70);
        tree2.insert(20);
        tree2.insert(40);
        tree2.insert(80);
        tree2.insert(10);
        tree2.insert(5);
        tree2.insert(90);


        tree2.insert(25);
        tree2.printTree(tree2.root);

    }
}
