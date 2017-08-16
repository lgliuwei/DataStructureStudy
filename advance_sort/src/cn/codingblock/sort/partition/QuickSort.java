package cn.codingblock.sort.partition;

import cn.codingblock.array.base.BaseArray;

/**
 * Created by liuwei on 17/8/15.
 */
public class QuickSort extends BaseArray {

    public QuickSort(int maxSize) {
        super(maxSize);
    }

    public void quickSort() {
        realQuickSort(0, mSize - 1);
    }

    /**
     * 快速排序
     * 1、将数组划分为两组
     * 2、对左边一组进行快排
     * 3、对右边一组进行快排
     * @param leftIndex
     * @param rightIndex
     */
    public void realQuickSort(int leftIndex, int rightIndex) {
        int size = rightIndex - leftIndex + 1;
        if (size <= 3) {
            // 由于中值划分(medianOf3)方法只能对大于4个项目的数据求中值,对于小于等于3个项目数据,需要其他方法排序
            // 说明:任意找枢纽的方法(例如:以最右端数据作为枢纽),这里只判断剩余一项时return即可
            if (size <= 1) {
                return;
            } else if (size == 2) {
                if (mArray[leftIndex] > mArray[rightIndex]) {
                    swap(leftIndex, rightIndex);
                }
            } else if (size == 3) {
                if (mArray[leftIndex] > mArray[leftIndex + 1]) {
                    swap(leftIndex, leftIndex + 1);
                }

                if (mArray[leftIndex] > mArray[rightIndex]) {
                    swap(leftIndex, rightIndex);
                }

                if (mArray[leftIndex + 1] > mArray[rightIndex]) {
                    swap(leftIndex + 1, rightIndex);
                }
            }
        } else {
            int partitionFlag = medianOf3(leftIndex, rightIndex);
            int partition = realPartion(leftIndex, rightIndex, partitionFlag);// 将数组划分为两组
            realQuickSort(leftIndex, partition - 1); // 对左边一组进行快排(对于枢纽的位置不需要在进行划分了)
            realQuickSort(partition + 1, rightIndex); // 对右边一组进行快排(对于枢纽的位置不需要在进行划分了)
        }
    }

    /**
     * 划分
     * @param leftIndex
     * @param rightIndex
     * @return
     */
    public int realPartion(int leftIndex, int rightIndex, int partitionFlag) {
        int leftScan = leftIndex;
        int rightScan = rightIndex - 1;
        while (true) {

            // 由于在循环前调用 medianOf3 时已经将三个数排序,此时最左端的值一定小于枢纽,没必要在划分,
            // 直接从第二个开始即可(所以用++leftIndex没问题)。中值被放到了倒数第二个下标中,所以leftIndex不会越界。
            while (mArray[++leftScan] < partitionFlag);

            // 从倒数第三个下标开始循环即可(由medianOf3可知, 最后一个数大于枢纽,倒数第二个数是枢纽本身)
            while (mArray[--rightScan] > partitionFlag);
            if (leftScan >= rightScan) {
                break;
            } else {
                swap(leftScan, rightScan);
            }
        }
        swap(leftScan, rightIndex - 1); // 将枢纽和划分点的数据互换,此时枢纽的位置不需要再变了(小于枢纽的都在枢纽左边,大于枢纽的都在枢纽右边)
        return leftScan;
    }

    /**
     * 三项取中值
     *      从 leftIndex -> rightIndex 这一组数据中,在 头,中间,尾 三个数中找出中值,同时也对三个数排序。
     *      最后再将中值和倒数第二个值互换,以保证在 (mArray[++leftIndex] < 枢纽)中的leftIndex不会越界
     * @param leftIndex
     * @param rightIndex
     * @return 返回枢纽的值
     */
    public int medianOf3(int leftIndex, int rightIndex) {
        int midIndex = (rightIndex + leftIndex) / 2;
        if (mArray[leftIndex] > mArray[midIndex]) {
            swap(leftIndex, midIndex);
        }

        if (mArray[leftIndex] > mArray[rightIndex]) {
            swap(leftIndex, rightIndex);
        }

        if (mArray[midIndex] > mArray[rightIndex]) {
            swap(midIndex, rightIndex);
        }

        swap(midIndex, rightIndex - 1);

        return mArray[rightIndex - 1]; // 返回枢纽的下标
    }

    public void display(int lowBounder, int highBounder){
        for (int i = 0; i < mSize; i++) {
            if (i == lowBounder) {
                print("[");
            }
            print(mArray[i]);
            if (i == highBounder) {
                print("]");
            }
            print(" ");
        }
        println("\n");
    }

    @Override
    public int insert(int e) throws ArrayIndexOutOfBoundsException {
        return 0;
    }

    @Override
    public int delete(int e) {
        return 0;
    }
}
