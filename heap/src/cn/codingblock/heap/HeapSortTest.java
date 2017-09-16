package cn.codingblock.heap;

import cn.codingblock.utils.log.Logger;
import cn.codingblock.utils.random.Random;

/**
 * Created by liuwei on 17/8/31.
 */
public class HeapSortTest {

    public static void main(String[] strs) {
        int[] nums = Random.initArrayByRandomNoRepeat(10);
        for (int n:
             nums) {
            Logger.print(n + ",");
        }
        Logger.println(" ");
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(nums);
        for (int n:
                nums) {
            Logger.print(n + ",");
        }
    }
}
