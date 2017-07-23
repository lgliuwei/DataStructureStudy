package cn.codingblock.array.order;

import cn.codingblock.array.base.BaseArray;
import cn.codingblock.array.utils.Logger;

/**
 * 冒泡排序
 * Created by liuwei on 17/7/23.
 */
public class BubArray extends BaseArray {

    public BubArray(int maxSize) {
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
    public void sort(){
        int t = 0;
        for (int out = mSize - 1; out > 1; out--) {
            for (int in = 0; in < out; in++) {
                if (mArray[in] > mArray[in + 1]) {
                    swap(in, in + 1);
                }
                Logger.println("第" + ++t + "次:");
                display();
            }
        }
    }

    private void swap(int index1, int index2) {
        int temp = mArray[index1];
        mArray[index1] = mArray[index2];
        mArray[index2] = temp;
    }
}
