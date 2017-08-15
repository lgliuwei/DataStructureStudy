package cn.codingblock.sort.shellsort;

import cn.codingblock.utils.log.Logger;

/**
 * Created by liuwei on 17/8/14.
 */
public class ShellSortTest {
    public static void main(String[] strs) {
        ShellSort shellSort = new ShellSort(50);
        shellSort.initArrayByRandomNoRepeat(10);
        shellSort.display();
        shellSort.shellSort();
        shellSort.display();
        Logger.println("移动次数:" + shellSort.count);
    }
}
