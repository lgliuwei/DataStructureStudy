package cn.codingblock.array.order;

import cn.codingblock.array.utils.Logger;

public class Test {

    public static void main(String[] args) {
        BubArray array = new BubArray(100);
        array.initArrayByRandomNoRepeat(10);
        Logger.print("排序前:");
        array.display();
        array.sort();
        Logger.print("排序后:");
        array.display();
    }
}
