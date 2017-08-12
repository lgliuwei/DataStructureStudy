package cn.codingblock.link.doublelinked;

import cn.codingblock.utils.log.Logger;

/**
 * Created by liuwei on 17/8/11.
 */
public class ToubleLinkedTest {
    public static void main(String[] strs) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        Logger.println("\ntail insert: -1 -2 -3:");
        doubleLinkedList.insertTail(-1);
        doubleLinkedList.insertTail(-2);
        doubleLinkedList.insertTail(-3);
//        Logger.println("header:");
//        doubleLinkedList.displayFromHeader();
//        Logger.println("\ntail:");
//        doubleLinkedList.displayFormTail();

        Logger.println("\nhead insert: 0 1 2 3:");
        doubleLinkedList.insertHead(0);
        doubleLinkedList.insertHead(1);
        doubleLinkedList.insertHead(2);
        doubleLinkedList.insertHead(3);
        doubleLinkedList.insertHead(3);
        Logger.println("header:");
        doubleLinkedList.displayFromHeader();
        Logger.println("\ntail:");
        doubleLinkedList.displayFormTail();

//        doubleLinkedList.delHeader();
//        doubleLinkedList.delTail();
//        doubleLinkedList.delTail();
//        doubleLinkedList.delTail();
//        doubleLinkedList.delTail();
//        doubleLinkedList.delTail();
//        doubleLinkedList.delTail();
//        doubleLinkedList.delHeader();
//        doubleLinkedList.insertHead(7);
//        doubleLinkedList.insertHead(8);
//        doubleLinkedList.insertHead(9);
//        doubleLinkedList.insertTail(-7);
//        doubleLinkedList.insertTail(-8);
//        doubleLinkedList.insertTail(-9);

//        doubleLinkedList.insertAfter(-3, 8);
//        doubleLinkedList.insertTail(9);
//        doubleLinkedList.insertHead(10);
        doubleLinkedList.delFirstKey(0);
        doubleLinkedList.delFirstKey(1);
        doubleLinkedList.delFirstKey(2);
        doubleLinkedList.delFirstKey(3);
        doubleLinkedList.delFirstKey(-1);
        doubleLinkedList.delFirstKey(-2);
        doubleLinkedList.delFirstKey(-3);
        doubleLinkedList.delFirstKey(3);
        doubleLinkedList.insertHead(10);
        doubleLinkedList.insertHead(11);
        doubleLinkedList.insertHead(12);
        doubleLinkedList.insertTail(-11);
        doubleLinkedList.insertTail(-12);
        doubleLinkedList.insertTail(-13);
        Logger.println("\n\nheader:");
        doubleLinkedList.displayFromHeader();
        Logger.println("tail:");
        doubleLinkedList.displayFormTail();


    }
}
