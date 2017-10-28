package cn.codingblock.weighted_graph;

import cn.codingblock.utils.log.Logger;

/**
 * Created by liuwei on 17/9/11.
 */
public class PriorityQueue {
    private int mMaxSize;
    private int mSize;
    private Edage[] mArrays;

    public PriorityQueue(int maxSize) {
        this.mMaxSize = maxSize;
        mArrays = new Edage[mMaxSize];
        mSize = 0;
    }

    public void insert(Edage edage) {
        if (!isFull()) {
            int n = mSize - 1;
            while (n >= 0 && mArrays[n].weight < edage.weight) {
                mArrays[n+1] = mArrays[n];
                n--;
            }
            mArrays[n + 1] = edage;
            mSize++;
        } else {
            Logger.println("full error!");
        }
    }

    public Edage removeMin() {
        if (!isEmpty()) {
            return mArrays[--mSize];
        } else {
            Logger.println("empty error!");
            return null;
        }
    }

    public Edage removeN(int n) {
        if (n < mSize) {
            Edage temp = mArrays[n];
            while (n < mSize) {
                mArrays[n] = mArrays[n + 1];
                n++;
            }
            mSize--;
            return temp;
        } else {
            Logger.println("empty error!");
            return null;
        }
    }

    public Edage peekMin() {
        if (!isEmpty()) {
            return mArrays[mSize - 1];
        } else {
            Logger.println("empty error!");
            return null;
        }
    }

    public Edage peekN(int n) {
        if (n < mSize) {
            return mArrays[n];
        } else {
            Logger.println("null pointer error!");
            return null;
        }
    }

    public boolean isFull() {
        return mSize == mMaxSize;
    }

    public boolean isEmpty() {
        return mSize == 0;
    }

    public void display() {
        for(int i = 0; i < mSize; i++) {
            Logger.println(mArrays[i].start + "-" + mArrays[i].end + ":" + mArrays[i].weight);
        }
    }
}
