package cn.codingblock.array.order;

import cn.codingblock.utils.log.Logger;

public class Test {

    public static void main(String[] args) {
        Array array = new Array(100);
        array.initArrayByRandomNoRepeat(100);
        Logger.print("排序前:");
        array.display();
//        array.sortByBubble();
        array.sortBySelect();
//        array.sortByInsert();
        Logger.print("排序后:");
        array.display();
    }
}
