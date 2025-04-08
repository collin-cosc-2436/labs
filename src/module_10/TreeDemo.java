package module_10;

import java.util.ArrayList;
import java.util.List;

public class TreeDemo {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.root = new TreeNode(1);
        TreeNode ch2 = new TreeNode(2);
        tree.root.children.add(ch2);
        ch2.children.add(new TreeNode(3));
        tree.root.children.add(new TreeNode(21));
        tree.root.children.add(new TreeNode(21));
        System.out.println("Node counts: " + tree.countNodes(tree.root));

        System.out.println("Tree height: " + tree.height(tree.root));
    }
}

class TreeNode {
    int value;
    List<TreeNode> children;


    public TreeNode(int value) {
        this.value = value;
        this.children = new ArrayList<>();
    }
}

class Tree {
    TreeNode root;

    public Tree() {
    }

    public Tree(int value) {
        this.root = new TreeNode(value);
    }

    public int countNodes(TreeNode node) {
        if (node == null) { //base case
            return 0;
        }
        int count = 1;
        for (TreeNode child : node.children) {
            count += countNodes(child);
        }
        return count;
    }

    public int height(TreeNode node) {
        if (node == null) return 0;

        int maxHeight = 0;
        for (TreeNode child : node.children) {
            maxHeight = Math.max(maxHeight, height(child));
        }
        return maxHeight + 1;
    }


}

