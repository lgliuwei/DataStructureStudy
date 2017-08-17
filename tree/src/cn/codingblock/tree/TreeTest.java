package cn.codingblock.tree;

import cn.codingblock.utils.log.Logger;
import cn.codingblock.utils.random.Random;

/**
 * Created by liuwei on 17/8/16.
 */
public class TreeTest {
    public static void main(String[] strs) {
        int[] nums = Random.initArrayByRandomNoRepeat(20);
        Tree tree = new Tree();
//        tree.insert(5);
//        tree.insert(8);
//        tree.insert(2);
//        tree.insert(0);
//        tree.insert(9);
//        tree.insert(3);
//        tree.insert(6);
//        tree.insert(7);
//        tree.insert(1);
//        tree.insert(4);
        for (int n:
             nums) {
            tree.insert(n);
        }
        Logger.println("1、中序遍历:");
        tree.inOrder();
        tree.delete(nums[5]);
        Logger.println("\n删除" + nums[5] + "后:");
        tree.inOrder();
//        Logger.println("\n2、前序遍历:");
//        tree.preOrder();
//        Logger.println("\n3、后序遍历:");
//        tree.postOrder();
//        Logger.println("\n最小值:" + tree.min().val);
//        Logger.println("\n最大值:" + tree.max().val);
    }
}
