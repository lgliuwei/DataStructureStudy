package cn.codingblock.queue;

import cn.codingblock.utils.Logger;

/**
 * 队列(FIFO)
 * Created by liuwei on 17/7/28.
 */
public class Queue {

    private int[] mArray;
    private int mMaxSize;
    private int front = 0; // 队头
    private int rear = -1; // 队尾
    private int mSize = 0; // 个数

    public Queue(int maxSize) {
        this.mMaxSize = maxSize;
        this.mArray = new int[maxSize];
    }

    public void insert(int e){
        if (!isFull()) {
            if (rear == mMaxSize - 1) {
                rear = -1;
            }
            mArray[++rear] = e;
            mSize++;
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
            mSize--;
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
        return mSize == 0;
    }

    public boolean isFull(){
        return mSize == mMaxSize;
    }

    public int size(){
        return mSize;
    }

}
