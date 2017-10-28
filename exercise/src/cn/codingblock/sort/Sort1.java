package cn.codingblock.sort;

import cn.codingblock.utils.log.Logger;

/**
 * Created by liuwei on 17/10/2.
 */
public class Sort1 {

    /**
     * 插入排序
     * @param nums
     */
    public void insertionSort(int[] nums) {
        int temp;
        int in;
        for(int out = 1; out < nums.length; out++) {
            temp = nums[out];
            in = out;
            while (in > 0 && nums[in - 1] > temp) {
                nums[in] = nums[in - 1];
                in--;
            }
            nums[in] = temp;
        }
    }

    /**
     * 选择排序
     * @param nums
     */
    public void selectionSort(int[] nums) {
        int min;
        for (int out = 0; out < nums.length; out++) {
            min = out;
            for (int in = out + 1; in <nums.length; in++) {
                if (nums[in] < nums[min]) {
                    min = in;
                }
            }
            int temp = nums[min];
            nums[min] = nums[out];
            nums[out] = temp;
        }
    }

    /**
     * 冒泡排序
     * @param nums
     */
    public void bubbleSort(int[] nums){
        int count = 0;// 日志辅助代码
        for (int out = nums.length - 1; out > 1; out--){
            for (int in = 0; in < out; in++) {
                Logger.print("比较 " + nums[in] + " , " + nums[in + 1]);
                if (nums[in] > nums[in + 1]) {
                    int temp = nums[in+1];
                    nums[in+1] = nums[in];
                    nums[in] = temp;
                    Logger.println(": 交换: ");// 日志辅助代码
                    display(nums, in, in + 1);// 日志辅助代码
                } else  {
                    Logger.println(": 不交换");// 日志辅助代码
                }
            }
            Logger.print(">>第" + (++count) + "趟冒泡:");// 日志辅助代码
            display(nums);// 日志辅助代码
        }
    }

    /**
     * 显示数组
     * @param nums
     */
    public void display(int[] nums) {
        for (int n: nums) {
            Logger.print(n + ", ");
        }
        Logger.println("");
    }

    public void display(int[] nums, int index1, int index2) {
        for (int i = 0; i < nums.length; i++) {
            if (i == index1 || i == index2) {
                Logger.print("[");
            }

            Logger.print(nums[i]);

            if (i == index1 || i == index2) {
                Logger.print("]");
            }
            Logger.print(", ");
        }
        Logger.println("");
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
