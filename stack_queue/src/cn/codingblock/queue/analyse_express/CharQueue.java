package cn.codingblock.queue.analyse_express;

import cn.codingblock.utils.log.Logger;

/**
 * 队列(FIFO)
 * Created by liuwei on 17/7/28.
 */
public class CharQueue {

    private char[] mArray;
    private int mMaxSize;
    private int front = 0; // 队头
    private int rear = -1; // 队尾
    private int mSize = 0; // 个数

    public CharQueue(int maxSize) {
        this.mMaxSize = maxSize;
        this.mArray = new char[maxSize];
    }

    public void insert(char e){
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

    public char remove() throws NullPointerException{
        if (!isEmpty()) {
            char e = mArray[front++];
            if (front == mMaxSize) {
                front = 0;
            }
            mSize--;
            return e;
        }
        throw new NullPointerException("remove error, queue is empty!");
    }

    public char peek() throws NullPointerException{
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
