package cn.codingblock.queue;

import cn.codingblock.utils.log.Logger;

/**
 * 以数组方式实现的优先级队列(标准的优先级队列用堆实现比较合适)
 * Created by liuwei on 17/7/29.
 */
public class PriorityQueue {

    private int mMaxSize;
    private int mItem;
    private int[] mArray;

    public PriorityQueue(int maxSize) {
        mMaxSize = maxSize;
        mArray = new int[mMaxSize];
        mItem = 0;
    }

    /**
     * 其实优先级队列,简单说来就是在插入时按照特定规则排序(以 小-->大 示例)
     * 插入
     */
    public void insert(int e){
        if (isFull()) {
            Logger.print("insert error, queue is full!");
        } else {
            int i = -1;
            // 如果mItem为0,直接插入
            if (mItem > 0) {
                /**
                 * 从数组的尾部开始比较,凡是大于e的元素就往后挪一格,直到发现不大于的e的元素,记住其下标,并将e插入其前一格。
                 * 注意:最后一次循环结束后 i 为 -1,证明全部都比e大,这时候e的位置为 -1 前面,即为0的位置。
                 */
                for (i = mItem - 1; i >= 0; i--) {
                    if (mArray[i] > e) {
                        mArray[i + 1] = mArray[i];
                    } else {
                        break;
                    }
                }
            }
            mArray[i + 1] = e;
            mItem++;
        }
    }

    public int remove() throws NullPointerException {
        if (!isEmpty()) {
            return mArray[--mItem];
        } else {
            throw new NullPointerException("remove error, queue is empty!");
        }
    }

    public int peek() throws NullPointerException {
        if (!isEmpty()) {
            return mArray[mItem - 1];
        } else {
            throw new NullPointerException("remove error, queue is empty!");
        }
    }

    public int size(){
        return mItem + 1;
    }

    public boolean isEmpty(){
        return mItem == 0;
    }

    public boolean isFull(){
        return mItem == mMaxSize;
    }
}
