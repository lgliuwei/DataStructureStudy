package cn.codingblock.tree;

import cn.codingblock.utils.log.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuwei on 17/8/23.
 */
public class TreeTest {

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] strs) {
        Tree tree = new Tree();
        tree.insert(5);
        tree.insert(1);
        tree.insert(4);
        tree.insert(3);
        tree.insert(9);
        tree.insert(8);
        List<Integer> temps = inorderTraversal(tree.getTree());
        Logger.println(temps);
    }

    /*
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        inorderTraversal(root.left);
        inorderTraversal(root.right);
        list.add(root.val);
        return list;
    }

    public static TreeNode sortedArrayToBST(int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }
        int lowBounder = 0;
        int highBounder = A.length - 1;
        int mid;
        while (true) {
            mid = (lowBounder + highBounder) / 2;

        }

    }

}
