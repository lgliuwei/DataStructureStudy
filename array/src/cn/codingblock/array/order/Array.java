package cn.codingblock.array.order;

import cn.codingblock.array.base.BaseArray;
import cn.codingblock.array.utils.Logger;

/**
 * 冒泡排序
 * Created by liuwei on 17/7/23.
 */
public class Array extends BaseArray {

    public Array(int maxSize) {
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
     * 冒泡排序
     */
    public void sortByBubble(){
        int comptimes = 0;
        int swapTimes = 0;
        for (int out = mSize - 1; out > 1; out--) {
            for (int in = 0; in < out; in++) {
                Logger.println("第" + ++comptimes + "次比较");
                if (mArray[in] > mArray[in + 1]) {
                    swap(in, in + 1);
                    swapTimes++;
                    Logger.print("交换" + swapTimes + "次:");
                    display();
                }
            }
        }
    }

    /**
     * 选择排序
     */
    public void sortBySelect(){
        int comptimes = 0;
        int swapTimes = 0;

        int index;
        for (int out = 0; out < mSize; out++) {
            index = out;
            for (int in = out + 1; in < mSize; in++) {
                if (mArray[in] < mArray[index]) {
                    index = in;
                }

                Logger.println("第" + ++comptimes + "次比较");
            }
            if (index != out) {
                swap(index, out);
                swapTimes ++;

                Logger.print("交换" + swapTimes + "次:");
                display();
            }
        }
    }

    /**
     * 插入排序
     */
    public void sortByInsert(){
        int comptimes = 0;
        int temp;
        for (int out = 1; out < mSize; out++) {
            temp = mArray[out];
            int in = out;
            while (in > 0 && mArray[in - 1] > temp) {
                mArray[in] = mArray[in - 1];
                in--;

                Logger.println("第" + ++comptimes + "次移动");
                display();

            }
            mArray[in] = temp;

            Logger.println("第" + ++comptimes + "次移动(阶段性完成):");
            display();

        }
    }

    private void swap(int index1, int index2) {
        int temp = mArray[index1];
        mArray[index1] = mArray[index2];
        mArray[index2] = temp;
    }
}
