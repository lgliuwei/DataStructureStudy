package cn.codingblock.sort.shellsort;

import cn.codingblock.array.base.BaseArray;

/**
 * Created by liuwei on 17/8/14.
 */
public class ShellSort extends BaseArray {
    public int count = 0;
    public ShellSort(int maxSize) {
        super(maxSize);
    }

    public void shellSort() {
//        recurisionShellSort(1);
        unRecurisionShellSort();
    }

    /**
     * 希尔排序(递归实现)
     * @param h 排序的间隔
     */
    private void recurisionShellSort(int h) {
        if (h > mSize) { // 基值条件
            // 当个间隔大于数组size的时候,return
            return;
        } else {
            recurisionShellSort(3*h+1); // 不断增大间距调用自身,根据递归的特性,
                                        // 当h > mSize后,会从最大可用间距开始进行排序,然后返回上一层(较小的间距),直到h为1时结束排序
            int tempFlag;
            for (int out = h; out < mSize; out++) {
                tempFlag = mArray[out];
                int in = out;
                while (in >= h && mArray[in - h] > tempFlag) {
                    mArray[in] = mArray[in - h];
                    in-=h;
                    count++;
                }
                if (in != out) {
                    mArray[in] = tempFlag;
                }
            }
        }
    }

    /**
     * 希尔排序(非递归实现)
     */
    public void unRecurisionShellSort() {
        int h = 1;
        while (h <= mSize / 3) {
            h = h * 3 + 1; // 计算出最大可用排序间距
        }

        // 先从最大可用间距开始排序,一步一步缩小间距,直到缩小到1
        while (h > 0) {
            int tempFlag;
            for (int out = h; out < mSize; out++) {
                tempFlag = mArray[out];
                int in = out;
                while (in >= h && mArray[in - h] > tempFlag) {
                    mArray[in] = mArray[in - h];
                    in-=h;
                    count++;
                }
                if (in != out) {
                    mArray[in] = tempFlag;
                }
            }
            h = (h - 1) / 3;
        }
    }

    /**
     * 插入排序(回顾)
     */
    public void insertionSort() {
        int tempFlag;
        for (int out = 1; out < mSize; out++) {
            tempFlag = mArray[out];
            int in = out;
            while (in > 0 && mArray[in-1] > tempFlag) {
                mArray[in] = mArray[in-1];
                in--;
                count++;
            }
            if (in != out) {
                mArray[in] = tempFlag;
//                Logger.println("中间排序(交换下标):" + in + "<->" + out);
//                display();
            }
        }
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
