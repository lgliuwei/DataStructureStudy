package cn.codingblock.link.ordered;

import cn.codingblock.link.HeaderLink;
import cn.codingblock.link.Node;
import cn.codingblock.utils.log.Logger;

/**
 * Created by liuwei on 17/8/10.
 */
public class Test {
    public static void main(String[] strs) {
        // 有序插入
//        OrderedLink orderedLink = new OrderedLink();
//        orderedLink.orderedInsert(9);
//        orderedLink.orderedInsert(2);
//        orderedLink.orderedInsert(4);
//        orderedLink.orderedInsert(10);
//        orderedLink.orderedInsert(6);
//        orderedLink.orderedInsert(-1);
//        orderedLink.orderedInsert(11);
//        orderedLink.orderedInsert(-3);
//        orderedLink.orderedInsert(5);
//        orderedLink.orderedInsert(5);
//        orderedLink.orderedInsert(12);
//        orderedLink.orderedInsert(-3);
//        orderedLink.orderedInsert(-4);
//        Logger.println("正序:");
//        orderedLink.display();

        // 排序
        HeaderLink headerLink = new HeaderLink();
        headerLink.insert(3);
        headerLink.insert(5);
        headerLink.insert(6);
        headerLink.insert(1);
        headerLink.insert(0);
        headerLink.insert(2);
        headerLink.insert(4);
        headerLink.insert(4);
        headerLink.insert(7);
        headerLink.insert(9);
        headerLink.insert(8);
        headerLink.insert(8);
        headerLink.insert(9);
        Logger.println("\n排序前:");
        headerLink.display();
        InsertionSortLink insertionSortLink = new InsertionSortLink();
        Node header = insertionSortLink.insertionSort(headerLink.getLink());
        Logger.println("\n排序后:");
        Logger.print(header);

    }
}
