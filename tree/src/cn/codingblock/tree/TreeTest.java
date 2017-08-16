package cn.codingblock.tree;

import cn.codingblock.utils.log.Logger;

/**
 * Created by liuwei on 17/8/16.
 */
public class TreeTest {
    public static void main(String[] strs) {
        Tree tree = new Tree();
        tree.insert(5);
        tree.insert(8);
        tree.insert(2);
        tree.insert(0);
        tree.insert(9);

        Logger.println("find:" + tree.find(10).val);
    }
}
