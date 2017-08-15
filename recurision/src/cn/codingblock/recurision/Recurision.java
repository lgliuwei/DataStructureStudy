package cn.codingblock.recurision;

import cn.codingblock.stack.Stack;
import cn.codingblock.utils.log.Logger;


/**
 * Created by liuwei on 17/8/11.
 */
public class Recurision {

    /**
     * 返回三角数字
     * @param n
     * @return
     */
    public int triangle(int n) {
//        Logger.println("n:" + n);
        if (n == 1) {
//            Logger.println("return:" + 1);
            return 1;
        } else {
            int temp = n + triangle(n - 1);
//            Logger.println("return:" + temp);
            return temp;
        }
    }

    /**
     * 返回三角数字(非递归实现, 消除递归)
     * 三角数字序列:1 3 6 10 15 21 ...
     *  规律:第n个数=n+(n-1)+(n-2)+...+1;
     */
    public int triangleByStack(int n) {
        Stack stack = new Stack(100);
        int result = 0;
        while (n > 0) {
            stack.push(n);
            n--;
        }

        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        // 本例比较简单,也可以不用栈来消除递归,但对一些较为复杂的递归算法消除递归时保留栈是必要的
//        while (n > 0) {
//            result += n;
//            n--;
//        }

        return result;
    }

    /**
     * 二分查找(递归实现)
     * @param nums
     * @param key
     * @param lowBounder
     * @param highBounder
     * @return
     */
    public int binarySereach (int[] nums, int key, int lowBounder, int highBounder) {
        if (nums != null && nums.length > 0) {
            int index = (lowBounder + highBounder) / 2;
            if (lowBounder > highBounder) {
                return -1;
            } else if (key == nums[index]) {
                return index;
            } else if (key > nums[index]) {
                lowBounder = index + 1;
            } else if (key < nums[index]) {
                highBounder = index - 1;
            }
            return binarySereach(nums, key, lowBounder, highBounder);
        } else {
            return -1;
        }
    }

    /**
     * 汉诺塔问题
     * 递归算法:
     * 1、将上面n-1个盘子移动到B座上
     * 2、将第n个盘子移动到C座上
     * 3、将n-1个盘子移动到C坐上
     */
    public void hanoi(int n, char from, char inter, char to) {
        if (n < 1) {
            return;
        }
        if (n == 1) {
            Logger.println("将第" + n + "个盘子,从 " + from + " 移动到 " + to); // 按照1、2、3步骤,一直简化问题,当只有一个盘子时
                                                                             // 直接从 A 放到 C 上即可。
        } else {
            hanoi(n - 1, from, to, inter); // 1、将上面n-1个盘子移动到B座上
            Logger.println("将第" + n + "个盘子,从 " + from + " 移动到 " + to); // 2、将第n个盘子移动到C座上
            hanoi(n - 1, inter, from, to); // 3、将n-1个盘子移动到C坐上
        }
    }

    /**
     * 归并两个有序的数组
     *      1、首先沿着a b两个数组进行循环,比较a,b两个数组值的大小,将较小的那个赋值到c中,并将其(小的那个,大数组的下标不变)下标+1
     *      2、那个数组中还有剩余的话说明,此数组中的剩余数时较大的,依次将此数组中的剩余数值赋值到c中即可
     * @param a
     * @param b
     * @return
     */
    public int[] mergeSortedArray(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int aIndex = 0;
        int bIndex = 0;
        int cIndex = 0;
        while (aIndex < a.length && bIndex < b.length) {
            if (a[aIndex] <= b[bIndex]) {
                c[cIndex++] = a[aIndex++];
            } else {
                c[cIndex++] = b[bIndex++];
            }
        }

        while (aIndex < a.length) {
            c[cIndex++] = a[aIndex++];
        }

        while (bIndex < b.length) {
            c[cIndex++] = b[bIndex++];
        }

        return c;
    }

    // 三种排序回顾
    /**
     * 冒泡排序
     * @param nums
     * @return
     */
    public int[] bubleSort(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }

    /**
     * 选择排序
     * @param nums
     * @return
     */
    public int[] selectionSort(int[] nums) {
        int min; // 最小值下标标示
        for (int out = 0; out < nums.length; out++) {
            min = out; // 假设最小值是本次循环的第一个值
            for (int in = out + 1; in < nums.length; in++) {
                if (nums[in] < nums[min]) { // 如果后面有更小的值,将其下标赋值给min
                    min = in;
                }
            }
            if (min != out) { // 如果min不等于out,说明此次循环中out后面有更小的值,交换他们两个的值即可
                int temp = nums[min];
                nums[min] = nums[out];
                nums[out] = temp;
            }
        }
        return nums;
    }

    /**
     * 插入排序
     *      1、从数组的第二个下标开始往后遍历,并记录下标对应的值(暂为temp)
     *      2、对每个下标往前循环判断,将大于当前下标对应值的数都后移一位,
     *      3、直到移动当前下标的下一位小于temp为止,将temp插入到当前下标即可。
     * @param nums
     * @return
     */
    public int[] insertionSort(int[] nums) {
        int temp;
        int in;
        for (int out = 1; out <= nums.length - 1; out++) {
            temp = nums[out];
            in = out;
            while (in > 0 && nums[in - 1] > temp) {
                nums[in] = nums[in - 1];
                in--;
            }
            nums[in] = temp;
        }
        return nums;
    }

}
