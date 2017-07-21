package cn.codingblock.array.base;

import cn.codingblock.array.utils.Logger;

import java.util.Random;

/**
 * 数组基类
 * Created by liuwei on 17/7/21.
 */
public abstract class BaseArray {
    protected int[] mArray;
    protected int mSize;
    protected int mMaxSize;

    public BaseArray(int maxSize){
        mMaxSize = maxSize;
        mArray = new int[mMaxSize];
        mSize = 0;
    }

    public int size(){
        return mSize;
    }

    /**
     * 随机数创建数组
     * @param size
     * @return
     */
    public void initArrayByRandom(int size) throws ArrayIndexOutOfBoundsException {
        if (size > mMaxSize) {
            throw new ArrayIndexOutOfBoundsException("size不能大于数组的maxSize");
        } else {
            mSize = size;
            for (int i = 0; i < size; i++) {
                mArray[i] = getRandomInt(size);
            }
        }
    }

    /**
     * 获取一个随机整数
     * @return
     */
    public int getRandomInt(int bounder){
        return new Random().nextInt(bounder);
    }

    public abstract int insert(int e) throws ArrayIndexOutOfBoundsException;

    public abstract int find(int e);

    public abstract int delete(int e);

    public void display(){
        for (int i = 0; i < mSize; i++) {
            print(mArray[i] + " ");
        }
        println("");
    }

    protected void print(Object o){
        Logger.print(o);
    }

    protected void println(Object o){
        Logger.println(o);
    }
}
