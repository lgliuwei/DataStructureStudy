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
        int j = -1;
        if (mSize == 0) {
            mArray[0] = e;
            j = 0;
        } else {
            for (int i = 0; i < mSize; i++) {
                if (e < mArray[i]) {
                    j = i;
                    break;
                }
            }
            if (j == -1) {
                mArray[mSize] = e;
            } else {
                for (int n = mSize; n > j; n--) {
                    mArray[n] = mArray[n-1];
                }
                mArray[j] = e;
            }
        }
        mSize++;
        return j;
    }

    /**
     * 二分查找
     * @param e
     * @return
     */
    @Override
    public int find(int e) {
        int lowIndex = 0;
        int highIndex = mSize - 1;

        if (e < mArray[lowIndex] || e > mArray[highIndex]) {
            return -1;
        }

        int currentIndex;

        while(true){
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

    @Override
    public int delete(int e) {
        int index = find(e);
        if (index >= 0) {
            for (int i = index; i < mSize; i++) {
                mArray[i] = mArray[i + 1];
            }
            mSize--;
        }
        return index;
    }
}
