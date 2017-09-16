package cn.codingblock.heap;

import cn.codingblock.utils.log.Logger;

/**
 * 堆排序
 *  一个数组完成堆排序
 *  思路:简单来说,对一组数据利用向上筛选的方式插入,然后在用向下筛选的方式remove即可得到一组有序的数据
 *  insert() 和 remove() 的时间复杂都是O(logN),并且每个方法都执行N次,所以堆排序的时间复杂度O(NlogN)时间
 *      更加节省时间和节省空间方式:(抛弃insert插入和向上筛选)
 *      1、对一组无序的数据,从树(数组形式的树)的最底层开始由右向左对节点向下筛选(从最右边的有子节点的节点开始遍历即可,对应数组下标(arraySize/2-1)),这样当前节点的子树就变成了一个正确的堆,
 *      直到根节点为止,这样整个树就变成了正确的堆。
 *      2、然后使用remove方法将数据输出即可到的有序数据
 *          在使用remove输出时,输出了数组的下标为0的数据,这样原数组中无序部分的尺寸越来越小,正好使得原数组腾出空间插入remove出来的数据
 *          这样就可以用一个数组完成堆排序了,节省了空间开销。
 * Created by liuwei on 17/8/31.
 */
public class HeapSort {

    private int bounder;

    public int[] heapSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        bounder = nums.length;
        // 从数组的 nums.length/2-1 下标开始至下标0顺序遍历,将节点向下筛选,使数组变成正确的堆
        for (int i = bounder / 2 - 1; i >= 0; i--) {
            trickleDown(nums, i);
        }

        while (bounder > 0) {
            nums[bounder-1] = remove(nums);
        }
        return nums;
    }

    public int remove(int[] nums) {
        int num = nums[0];
        nums[0] = nums[--bounder];
        trickleDown(nums, 0);
        return num;
    }

    private void trickleDown(int[] nums, int index) {
        int temp = nums[index];
        int leftIndex;
        int rightIndex;
        int largerIndex;
        while (index < bounder / 2) {
            leftIndex = 2 * index + 1;
            rightIndex = leftIndex + 1;
            if (rightIndex < bounder && nums[rightIndex] > nums[leftIndex]) {
                largerIndex  = rightIndex;
            } else {
                largerIndex = leftIndex;
            }

            if (temp < nums[largerIndex]) {
                nums[index] = nums[largerIndex];
                index = largerIndex;
            } else {
                break;
            }
        }
        nums[index] = temp;
    }
}
