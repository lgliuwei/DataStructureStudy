package cn.codingblock.stack;

/**
 * 栈(LIFO)
 * Created by liuwei on 17/7/25.
 */
public class Stack {

    private int[] mArray;
    private int mMaxSize;
    private int mTop;

    public Stack(int maxSize) {
        mMaxSize = maxSize;
        this.mArray = new int[mMaxSize];
        mTop = -1;
    }

    public boolean isEmpty() {
        if (mTop < 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        if (mTop >= mMaxSize - 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 入栈
     */
    public void push(int e) throws StackOverflowError {
        if (isFull()) {
            throw new StackOverflowError("栈满了!");
        }
        mArray[++mTop] = e;
    }

    /**
     * 出栈
     */
    public int pop() throws NullPointerException {
        if (isEmpty()) {
            throw new NullPointerException("栈已经空了!");
        }
        return mArray[mTop--];
    }

    /**
     * 查看
     */
    public int peek() throws NullPointerException {
        if (isEmpty()) {
            throw new NullPointerException("栈已经空了!");
        }
        return mArray[mTop];
    }

}
