package cn.codingblock.tree;

/**
 * Created by liuwei on 17/8/23.
 */
public class Tree {
    TreeNode root;

    public Tree() {
        this.root = null;
    }

    public void insert(int e) {
        TreeNode newNode = new TreeNode(e);
        if (root == null) {
            root = newNode;
        } else {
            TreeNode currentNode = root;

            while (currentNode != null) {
                if (e > currentNode.val) {
                    if (currentNode.right == null) {
                        currentNode.right = newNode;
                        break;
                    } else {
                        currentNode = currentNode.right;
                    }
                } else {
                    if (currentNode.left == null) {
                        currentNode.left = newNode;
                        break;
                    } else {
                        currentNode = currentNode.left;
                    }
                }
            }
        }
    }

    public TreeNode getTree() {
        return root;
    }
}
