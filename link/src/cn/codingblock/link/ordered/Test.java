package cn.codingblock.link.ordered;

import cn.codingblock.utils.log.Logger;

/**
 * Created by liuwei on 17/8/10.
 */
public class Test {
    public static void main(String[] strs) {
        // 正序
        OrderedLink orderedLink = new OrderedLink();
        orderedLink.orderedInsert(9);
        orderedLink.orderedInsert(2);
        orderedLink.orderedInsert(4);
        orderedLink.orderedInsert(10);
        orderedLink.orderedInsert(6);
        orderedLink.orderedInsert(-1);
        orderedLink.orderedInsert(11);
        orderedLink.orderedInsert(-3);
        orderedLink.orderedInsert(5);
        Logger.println("正序:");
        orderedLink.display();

        // 逆序
        DescOrderedLink descOrderedLink = new DescOrderedLink();
        descOrderedLink.orderedInsertDesc(9);
        descOrderedLink.orderedInsertDesc(2);
        descOrderedLink.orderedInsertDesc(1);
        descOrderedLink.orderedInsertDesc(5);
        descOrderedLink.orderedInsertDesc(3);
        descOrderedLink.orderedInsertDesc(7);
        descOrderedLink.orderedInsertDesc(8);
        descOrderedLink.orderedInsertDesc(4);
        descOrderedLink.orderedInsertDesc(8);
        descOrderedLink.orderedInsertDesc(0);
        descOrderedLink.orderedInsertDesc(5);
        descOrderedLink.orderedInsertDesc(2);
        descOrderedLink.orderedInsertDesc(9);
        descOrderedLink.orderedInsertDesc(7);
        descOrderedLink.orderedInsertDesc(4);
        Logger.println("\n逆序:");
        descOrderedLink.display();
    }
}
