package cn.codingblock.recurision;

import cn.codingblock.utils.log.Logger;

/**
 * Created by liuwei on 17/8/11.
 */
public class RecurisionTest {
    public static void main(String[] strs) {
        Recurision recurision = new Recurision();
        Logger.println(recurision.triangle(1));
        Logger.println(recurision.triangle(2));
        Logger.println(recurision.triangle(3));
        Logger.println(recurision.triangle(4));
        Logger.println(recurision.triangle(5));
        Logger.println(recurision.triangle(6));

        Logger.println("\n" + recurision.triangleByStack(1));
        Logger.println(recurision.triangleByStack(2));
        Logger.println(recurision.triangleByStack(3));
        Logger.println(recurision.triangleByStack(4));
        Logger.println(recurision.triangleByStack(5));
        Logger.println(recurision.triangleByStack(6));

////        Logger.println(recurision.binarySereach(new int[] {1, 2, 3, 5, 7, 10, 11}, 10, 0, 6));
////        recurision.hanoi(20, 'A', 'B', 'C');
//        int[] nums = new int[]{1, 4, 5, 7, 10, 6, 3, 2, 9, 8, 3, 0};
////        recurision.insertionSort(nums);
//        int[] c = recurision.mergeSortedArray(new int[]{1, 5, 9}, new int[]{3, 4, 6, 10});
//        for (int n:
//             c) {
//            Logger.print(n + ", ");
//        }
//        MergeSort mergeSort = new MergeSort(500);
//        mergeSort.initArrayByRandomNoRepeat(10);
//        mergeSort.display();
//        mergeSort.mergeSort();
//        mergeSort.display();
    }
}
