package cn.codingblock.sort.partition;

/**
 * Created by liuwei on 17/8/15.
 */
public class PartitionTest {
    public static void main(String[] strs) {
//        Partition partition = new Partition(20);
////        partition.initArrayByRandomNoRepeat(20);
//        partition.initArray(new int[]{43, 83, 94, 23, 125, 27, 60, 88, 8, 197, 140, 108, 177, 51, 33, 78, 16, 144, 198, 67});
//        partition.display();
//        partition.partitonByMid(60);
//        partition.display();

        QuickSort quickSort = new QuickSort(10);
        quickSort.initArrayByRandomNoRepeat(10);
//        quickSort.initArray(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0});
        quickSort.display();
        quickSort.quickSort();
        quickSort.display();
    }
}
