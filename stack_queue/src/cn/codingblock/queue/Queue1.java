package cn.codingblock.queue;

import cn.codingblock.utils.Logger;

/**
 * 不带计数项的队列
 * Created by liuwei on 17/7/28.
 */
public class Queue1 {

    private int[] mArray;
    private int mMaxSize;
    private int front = 0; // 队头
    private int rear = -1; // 队尾

    public Queue1(int maxSize) {
        this.mMaxSize = maxSize + 1;
        this.mArray = new int[mMaxSize];
    }

    public void insert(int e){
        if (!isFull()) {
            if (rear == mMaxSize - 1) {
                rear = -1;
            }
            mArray[++rear] = e;
        } else {
            Logger.print("insert error, queue is full!");
        }
    }

    public int remove() throws NullPointerException{
        if (!isEmpty()) {
            int e = mArray[front++];
            if (front == mMaxSize) {
                front = 0;
            }
            return e;
        }
        throw new NullPointerException("remove error, queue is empty!");
    }

    public int peek() throws NullPointerException{
        if (isEmpty()) {
            throw new NullPointerException("peek error, queue is empty!");
        } else {
            return mArray[front];
        }
    }

    public boolean isEmpty(){
        /**
         * 为空时即标示 mMaxSize 长度的数组是空的,所以会有两种情况:
         * 1、尾标 - 头标 = mMaxSize - 1 (好理解)
         * 2、rear < front 并且 rear 紧挨着 front。(这样就没有空间在放下去元素了)
         */
        return (rear + 1 == front) || (front + mMaxSize - 1 == rear);
    }

    public boolean isFull(){
        /**
         * 由于我们设定 mMaxSize 比实际长度大1,所以满时即表示当前数组的元素个数比 mMaxSize 少1个,这样会有两种情况:
         * 1、尾标 - 头标 = mMaxSize - 2
         * 2、rear < front 并且 rear 和 front 之间实际上会多出一个元素的空间。
         */
        return (rear + 2 == front) || (front + mMaxSize - 2 == rear);
    }

    public int size(){
        if (rear >= front) {
            return rear - front + 1;
        } else {
            return rear + 1 + mMaxSize - front;
        }
    }

}
