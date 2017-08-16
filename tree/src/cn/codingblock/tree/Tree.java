package cn.codingblock.tree;

/**
 * Created by liuwei on 17/8/16.
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
                    if (currentNode.rightChid == null) {
                        currentNode.rightChid = newNode;
                        break;
                    } else {
                        currentNode = currentNode.rightChid;
                    }
                } else {
                    if (currentNode.leftChild == null) {
                        currentNode.leftChild = newNode;
                        break;
                    } else {
                        currentNode = currentNode.leftChild;
                    }
                }
            }
        }
    }

    public TreeNode deleteFirst(int e) {
        return null;
    }

    public int deleteAll(int e) {
        int count = 0;
        return count;
    }

    public TreeNode find(int e) {
        TreeNode currentNode = root;
        while (currentNode != null) {
            if (e == currentNode.val) {
                return currentNode;
            } else if (e > currentNode.val) {
                currentNode = currentNode.rightChid;
            } else {
                currentNode = currentNode.leftChild;
            }
        }
        return null;
    }
}
