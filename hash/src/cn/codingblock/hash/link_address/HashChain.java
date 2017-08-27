package cn.codingblock.hash.link_address;

import cn.codingblock.utils.log.Logger;

/**
 * Created by liuwei on 17/8/25.
 */
public class HashChain {
    protected OrderedLink[] mHashArray;
    protected int mMaxSize;// 最大容量
    protected int mItems;// 当前个数

    public HashChain(int size) {
        mMaxSize = size;
        mHashArray = new OrderedLink[mMaxSize];
        mItems = 0;
    }

    public void insert(Node item) {
        if (item == null) {
            return;
        }
        Logger.println("装填因子:实际量/数组容量=" + ((float)mItems / mMaxSize));
        int hashKey = hashTransfer(item.val);
        if (mHashArray[hashKey] == null) {
            mHashArray[hashKey] = new OrderedLink();
        }
        mHashArray[hashKey].insert(item);
        mItems++;
    }

    public boolean delete(int key) {
        int hashKey = hashTransfer(key);
        if (mHashArray[hashKey] != null) {
            mHashArray[hashKey].delete(key);
            return true;
        }
        return false;
    }

    public Node find(int key) {
        int hashKey = hashTransfer(key);
        if (mHashArray[hashKey] != null) {
            return mHashArray[hashKey].find(key);
        }
        return null;
    }

    public void display() {
        for (int i = 0; i < mMaxSize; i++) {
            if (mHashArray[i] != null) {
                Logger.print("[" + i + "]:");
                mHashArray[i].display();
            }
        }
    }

    /**
     * 将key哈希化
     * @param key
     * @return
     */
    protected int hashTransfer(int key) {
        return key % mMaxSize;
    }
}
