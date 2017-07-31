package cn.codingblock.queue;

import cn.codingblock.utils.Logger;

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
            if (mItem > 0) {
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
