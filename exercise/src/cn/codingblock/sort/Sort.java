package cn.codingblock.sort;

/**
 * Created by liuwei on 17/8/16.
 */
public class Sort {

    /**
     * 快速排序
     * @param nums
     */
    public void quickSort(int[] nums) {
        realQuickSort(nums, 0, nums.length - 1);
    }

    private void realQuickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        } else {
            int partitionValue = nums[right];
            int partition = partition(nums, left, right, partitionValue);
            realQuickSort(nums, left, partition - 1);
            realQuickSort(nums, partition + 1, right);
        }
    }

    private int partition(int[] nums, int left, int right, int partitionValue) {
        int leftIndex = left - 1;
        int rightIndex = right;

        while (true) {
            while (nums[++leftIndex] < partitionValue);

            while (rightIndex > leftIndex && nums[--rightIndex] > partitionValue);

            if (leftIndex >= rightIndex) {
                break;
            } else {
                swap(nums, leftIndex, rightIndex);
            }
        }
        swap(nums, leftIndex, right); // 将枢纽位置移到分割点的位置
        return leftIndex;

    }

    /**
     * 希尔排序
     * @param nums
     */
    public void shellSort(int[] nums) {
        int size = nums.length;
        int h = 1;
        while (h <= size / 3) { // 用 把size除3,这样保证了h不会超出size,并且可以正好计算到序列中的最大可用数
            h = h * 3 + 1;
        }
        int flag;
        int in;
        while (h >= 1) {
            for (int out = h; out < size; out++) {
                flag = nums[out];
                in = out;
                while (in >= h && nums[in - h] > flag) {
                    nums[in] = nums[in - h];
                    in = in - h;
                }
                nums[in] = flag;
            }
            h = (h - 1) / 3;
        }
    }

    /**
     * 归并排序
     * @param nums
     */
    public void mergeSort(int[] nums) {
        realMergeSort(nums, 0, nums.length - 1);
    }

    private void realMergeSort(int[] nums, int lowBounder, int highBounder) {
        if (lowBounder >= highBounder) {
            return;
        } else {
            int mid = (lowBounder + highBounder) / 2;
            realMergeSort(nums, lowBounder, mid);
            realMergeSort(nums, mid + 1, highBounder);
            merge(nums, lowBounder, mid, highBounder);
        }
    }

    private void merge(int[] nums, int lowBounder, int mid, int highBoudner) {
        int aIndex = lowBounder;
        int bIndex = mid + 1;
        int cIndex = 0;
        int[] cArray = new int[highBoudner - lowBounder + 1];
        while (aIndex <= mid && bIndex <= highBoudner) {
            if (nums[aIndex] < nums[bIndex]) {
                cArray[cIndex++] = nums[aIndex++];
            } else {
                cArray[cIndex++] = nums[bIndex++];
            }
        }

        while (aIndex <= mid) {
            cArray[cIndex++] = nums[aIndex++];
        }

        while (bIndex <= highBoudner) {
            cArray[cIndex++] = nums[bIndex++];
        }

        for (int i = 0; i < cIndex; i++) {
            nums[lowBounder + i] = cArray[i];
            // 这里要注意nums从lowBounder下标开始起
        }
    }

    /**
     * 冒泡排序
     * @param nums
     */
    public void bubleSort(int[] nums) {
        for (int out = nums.length - 1; out > 0; out--) {
            for (int in = 0; in < out; in++) {
                if (nums[in] > nums[in + 1]) {
                    swap(nums, in, in + 1);
                }
            }
        }
    }

    /**
     * 插入排序
     * @param nums
     */
    public void insertionSort(int[] nums) {
        int flag;
        int in;
        for (int out = 1; out < nums.length; out++) {
            flag = nums[out];
            in = out;
            while (in > 0 && nums[in - 1] > flag) {
                nums[in] = nums[in - 1];
                in--;
            }
            nums[in] = flag;
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
            for (int in = out + 1; in < nums.length; in++) {
                if (nums[in] < nums[min]) {
                    min = in;
                }
            }
            swap(nums, min, out);
        }

    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}
