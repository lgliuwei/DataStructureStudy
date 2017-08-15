package cn.codingblock.recurision;

import cn.codingblock.array.base.BaseArray;
import cn.codingblock.utils.log.Logger;

/**
 * 归并排序
 * Created by liuwei on 17/8/13.
 */
public class MergeSort extends BaseArray {

    public MergeSort(int maxSize) {
        super(maxSize);
    }

    @Override
    public int insert(int e) throws ArrayIndexOutOfBoundsException {
        return 0;
    }

    @Override
    public int delete(int e) {
        return 0;
    }

    /**
     * 归并排序
     * 效率: O(N*logN)
     */
    public void mergeSort() {
        recMergeSort(new int[mSize], 0, mSize - 1);
    }

    private void recMergeSort(int[] workspace, int lowBounder, int highBounder) {
        if (lowBounder == highBounder) {
            return; // 分割得每个组只剩一个数据时返回
        }
        int mid = (lowBounder + highBounder) / 2; // 对workspace数组平分
        recMergeSort(workspace, lowBounder, mid); // 对小的一半归并排序
        recMergeSort(workspace, mid + 1, highBounder); // 对大的一半归并排序
        merge(workspace, lowBounder, mid, highBounder); // 对上面两半归并排序
    }

    private void merge(int[] workspace, int lowBounder, int mid, int highBounder) {
        int leftIndex = lowBounder;
        int righIndex = mid + 1;
        int workIndex = 0;
        while (leftIndex <= mid && righIndex <= highBounder) {
            if (mArray[leftIndex] <= mArray[righIndex]) {
                workspace[workIndex++] = mArray[leftIndex++];
            } else {
                workspace[workIndex++] = mArray[righIndex++];
            }
        }

        while (leftIndex <= mid) {
            workspace[workIndex++] = mArray[leftIndex++];
        }

        while (righIndex <= highBounder) {
            workspace[workIndex++] = mArray[righIndex++];
        }

        for (int i = 0; i < workIndex; i++) {
            mArray[lowBounder + i] = workspace[i];
        }

        Logger.println("(对"+lowBounder +"->" + highBounder +")排序:");
        display(lowBounder, highBounder);
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
        println("");
    }


}
