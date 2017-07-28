package cn.codingblock.stack.reverser;

/**
 * 字符栈
 * Created by liuwei on 17/7/26.
 */
public class CharStack {

    private char[] mArray;
    private int mMaxSize;
    private int mTop;

    public CharStack(int maxSize) {
        mMaxSize = maxSize;
        this.mArray = new char[mMaxSize];
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
    public void push(char e) throws StackOverflowError {
        if (isFull()) {
            throw new StackOverflowError("栈满了!");
        }
        mArray[++mTop] = e;
    }

    /**
     * 出栈
     */
    public char pop() {
        return mArray[mTop--];
    }

    /**
     * 查看
     */
    public char peek() {
        return mArray[mTop];
    }

}
