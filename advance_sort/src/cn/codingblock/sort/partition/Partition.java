package cn.codingblock.sort.partition;

import cn.codingblock.array.base.BaseArray;
import cn.codingblock.utils.log.Logger;

/**
 * 划分
 * Created by liuwei on 17/8/15.
 */
public class Partition extends BaseArray {

    public Partition(int maxSize) {
        super(maxSize);
    }

    /**
     * 例如: 5 为分割线
     * 3  7  1  9  0  4  2  6  5  8
     *    ↑              ↑
     *    7<->2
     * 3  2  1  9  0  4  7  6  5  8
     *          ↑     ↑
     *          9<->4
     * 3  2  1  4  0  9  7  6  5  8
     *             ↑↑
     */
    public int partitonByMid (int partitionFlag) {
        int leftIndex = -1;
        int rightIndex = mSize;
        while (true) {
            while (leftIndex < rightIndex && mArray[++leftIndex] < partitionFlag);
            while (rightIndex > leftIndex && mArray[--rightIndex] > partitionFlag);

            if (leftIndex >= rightIndex) {
                break;
            } else {
                swap(leftIndex, rightIndex);
            }
        }
        Logger.println("分割数为:" + partitionFlag + " 位置:" + leftIndex);
        return leftIndex;
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
