package cn.codingblock.tree;

import cn.codingblock.utils.log.Logger;

/**
 * 二叉树
 *  层数 L = log2(N+1)
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

    public TreeNode delete(int e) {
        TreeNode currentNode = root;
        TreeNode pNode = null;
        boolean isLeftChild = false;
        while (currentNode != null && currentNode.val != e) {
            pNode = currentNode;
            if (e < currentNode.val) {
                isLeftChild = true;
                currentNode = currentNode.leftChild;
            } else {
                isLeftChild = false;
                currentNode = currentNode.rightChid;
            }
        }

        if (currentNode == null) {
            return null;
        } else if (currentNode.leftChild != null && currentNode.rightChid != null) {
            // 1、待删除的节点有两个子节点
            /*
             * 对于这种情况
             * ① 首先找出待删除节点的后继节点(后继节点为中序遍历中的下一个节点)
             * ② 用后继节点替换掉待删除节点,并删除后继节点
             * ③ 如果后继节点还有子节点,将其子节点上移替代后继节点的位置。(由①知,后继节点最多存在一个右节点(或右子树))
             */
            TreeNode nextNode = currentNode.rightChid; // 后继节点
            TreeNode parentNextNode = null; // 后继节点的父节点
            while (nextNode.leftChild != null) {
                parentNextNode = nextNode;
                nextNode = nextNode.leftChild;
            }

            currentNode.val = nextNode.val; // 将当前节点的值赋值为后继节点
            if (parentNextNode == null) {
                if (nextNode.rightChid != null) {
                    currentNode.rightChid = nextNode.rightChid;
                } else {
                    currentNode.rightChid = null;
                }
            } else {
                if (nextNode.rightChid != null) {
                    parentNextNode.leftChild = nextNode.rightChid; // 若后继节点存在右节点,将其父节点的leftChild指向后继节点的右节点即可
                } else {
                    parentNextNode.leftChild = null; // 后继节点如果没有子节点,将其父节点的指向置为null,让其等待垃圾回收即可
                }
            }

        } else if (currentNode.leftChild != null || currentNode.rightChid != null) {
            // 2、待删除的节点只有一个子节点
            if (currentNode == root) {
                if (currentNode.leftChild != null) {
                    root = root.leftChild;
                } else {
                    root = root.rightChid;
                }
            } else {
                // 2.1 将currentNode 赋值为下一个子节点(左节点或右节点)
                if (currentNode.leftChild != null) {
                    currentNode = currentNode.leftChild;
                } else {
                    currentNode = currentNode.rightChid;
                }
                // 2.2 将父节点的指向更新
                if (isLeftChild) {
                    pNode.leftChild = currentNode;
                } else {
                    pNode.rightChid = currentNode;
                }
            }
        } else {
            if (currentNode == root) {
                // 整棵树只有 root 一个节点,待删除是 root
                root = null;
            } else {
                // 待删除的节点没有子节点
                if (isLeftChild) { // 待删除的节点为父节点的左节点
                    pNode.leftChild = null;
                } else {
                    pNode.rightChid = null;
                }
            }
        }

        return null;
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

    public TreeNode min() {
        TreeNode currentNode = root;
        while (currentNode != null && currentNode.leftChild != null) {
            currentNode = currentNode.leftChild;
        }
        return currentNode;
    }

    public TreeNode max() {
        TreeNode currentNode = root;
        while (currentNode != null && currentNode.rightChid != null) {
            currentNode = currentNode.rightChid;
        }
        return currentNode;
    }

    public void inOrder() {
        realInOrder(root);
    }

    /**
     * 中序遍历
     *  1、先调用自身遍历节点的左子树
     *  2、访问节点
     *  3、再调用自身遍历节点的右子数
     * @param treeNode
     */
    private void realInOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        realInOrder(treeNode.leftChild);
        Logger.print(treeNode.val + ", ");
        realInOrder(treeNode.rightChid);
    }

    public void preOrder() {
        realPreOrder(root);
    }

    /**
     * 前序遍历
     *  1、访问节点
     *  2、调用自身遍历节点的左子树
     *  3、调用自身遍历节点的右子树
     * @param treeNode
     */
    private void realPreOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        Logger.print(treeNode.val + ", ");
        realPreOrder(treeNode.leftChild);
        realPreOrder(treeNode.rightChid);
    }

    public void postOrder() {
        realPostOrder(root);
    }

    /**
     * 后序遍历
     *  1、调用自身遍历节点的左子树
     *  2、调用自身遍历节点的右子树
     *  3、访问节点
     * @param treeNode
     */
    private void realPostOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        realPostOrder(treeNode.leftChild);
        realPostOrder(treeNode.rightChid);
        Logger.print(treeNode.val + ", ");
    }
}
