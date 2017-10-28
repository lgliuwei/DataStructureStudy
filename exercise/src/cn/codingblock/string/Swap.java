package cn.codingblock.string;

import cn.codingblock.utils.log.Logger;

/**
 * 交换
 * 把一个只包含0 1的串排序，可交换任意两个数的位置，最少交换的次数？
 */
public class Swap {
    public static void main(String[] strs) {
        int count = 0;
        int[] arrays = new int[] {0, 0, 1, 1, 1, 0, 1, 0, 0, 1};
        int left = 0;
        int right = arrays.length - 1;
        while (true) {
            while (arrays[left] == 0) {
                left++;
            }
            while (arrays[right] == 1) {
                right--;
            }
            if (left >= right) {
                break;
            } else {
                int temp = arrays[left];
                arrays[left] = arrays[right];
                arrays[right] = temp;
                count++;
            }
        }
        Logger.println("交换次数：" + count);
        for (int array : arrays) {
            Logger.print(array + ", ");
        }
    }
}
