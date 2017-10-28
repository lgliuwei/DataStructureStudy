package cn.codingblock.sort;

import cn.codingblock.utils.log.Logger;
import cn.codingblock.utils.random.Random;

/**
 * Created by liuwei on 17/8/16.
 */
public class SortTest {
    public static void main(String[] strs) {
//        int[] nums = new int[] {4, 5, 3, 1, 0, 6, 8, 10, 9, 7};
        int[] nums = Random.initArrayByRandomNoRepeat(20);
//        int[] nums = Random.initArrayByRandom(10);
        Logger.print("排序前:");
        display(nums);
        Sort1 sort = new Sort1();
        sort.insertionSort(nums);
        Logger.print("排序后:");
        display(nums);
    }

    public static void display(int[] nums) {
        for (int n: nums) {
            Logger.print(n + ", ");
        }
        Logger.println("");
    }
}
