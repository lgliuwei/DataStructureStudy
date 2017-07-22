package cn.codingblock.array.orderedarray;

import cn.codingblock.array.base.BaseArray;

/**
 * 有序数组
 *
 * Created by liuwei on 17/7/21.
 */
public class OrderedArray extends BaseArray {

    public OrderedArray(int maxSize) {
        super(maxSize);
    }

    /**
     * 有序插入
     */
    @Override
    public int insert(int e) throws ArrayIndexOutOfBoundsException {
        if (mSize == mMaxSize) {
            throw new ArrayIndexOutOfBoundsException("数组已经满了");
        }
        int i;
        for (i = 0; i < mSize; i++) {
            if (e < mArray[i]) break;
        }
        for (int j = mSize; j > i; j--) {
            mArray[j] = mArray[j-1];
        }
        mArray[i] = e;
        mSize++;

        return i;
    }

    @Override
    public int delete(int e) {
        int index = findByHalf(e);
        if (index >= 0) {
            for (int i = index; i < mSize; i++) {
                mArray[i] = mArray[i + 1];
            }
            mSize--;
        }
        return index;
    }

    /**
     * 二分查找
     * @param e
     * @return
     */
    public int findByHalf(int e) {
        int lowIndex = 0;
        int highIndex = mSize - 1;

        int findTimes = 1;
        println("查找次数:" + findTimes);
        if (e < mArray[lowIndex] || e > mArray[highIndex]) {
            return -1;
        }

        int currentIndex;

        while(true){
            findTimes++;
            println("查找次数:" + findTimes);
            currentIndex = (lowIndex + highIndex) / 2;
            if (e == mArray[currentIndex]) {
                return currentIndex;
            } else if (lowIndex >= highIndex) {
                return -1;
            } else if (e > mArray[currentIndex]) {
                lowIndex = currentIndex + 1;
            } else {
                highIndex = currentIndex - 1;
            }
        }
    }

    /**
     * 线性查找
     * @param e
     * @return
     */
    public int findByLiner(int e) {
        int findTimes = 1;
        println("查找次数:" + findTimes);
        if (e < mArray[0] || e > mArray[mSize - 1]) {
            return -1;
        }
        for(int i = 0; i < mSize; i++) {
            findTimes++;
            println("查找次数:" + findTimes);
            if (e == mArray[i]) {
                return i;
            } else if (mSize > (i + 1) &&e > mArray[i] && e < mArray[i + 1]) {
                return -1;
            }
        }
        return -1;
    }
}
