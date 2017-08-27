package cn.codingblock.hash.open_address;

import cn.codingblock.utils.log.Logger;

/**
 * 再哈希法测探哈希表
 * Created by liuwei on 17/8/24.
 */
public class ReHashProbingHash extends BaseHashTable {

    public ReHashProbingHash(int size) {
        super(size);
        mHashArray = new DataItem[size];
    }

    /**
     * 再哈希法探测插入
     *  1、计算出要插入的item的哈希值 hashKey (作为数组下标用)
     *  2、将新item插入到数组的 hashKey 下标中
     *  3、如果 hashKey 下标在数组中已经有值了(不为null,并且当前值不等于-1),就按顺序每隔 reHash(item.getData()) 步寻找下一个下标,直到找到空位置(null, 或者值为-1的位置)
     * @param item
     */
    @Override
    public void insert(DataItem item) {
        if (item == null) {
            return;
        }
        if (mItems == mMaxSize) {
            Logger.println("error, hash table is full!");
            return;
        }
        // 将 DataItem.data 哈希化为数组的下标
        int hashKey = hashTransfer(item.getData());
        int stepSize = reHash(item.getData());
        // 通过线性探测(从当前下标起按顺序寻找下一个,直到有空位置即可)寻找item的插入点
        while (mHashArray[hashKey] != null && mHashArray[hashKey].getData() != -1) {
            hashKey += stepSize;
            hashKey %= mMaxSize;// 如果hashKey超出了数组的范围,就对hashKey取余操作,这样就能保证数据可以在循环插入到数组了
        }
        mHashArray[hashKey] = item;
        ++mItems;
    }

    /**
     * 删除
     * @param key
     * @return
     */
    @Override
    public boolean delete(int key) {
        int hashKey = hashTransfer(key);
        int stepSize = reHash(key);
        while (mHashArray[hashKey] != null) {
            if (mHashArray[hashKey].getData() == key) {
                mHashArray[hashKey] = nonItem;
                mItems--;
                return true;
            }
            hashKey += stepSize;
            hashKey %= mMaxSize;
        }
        return false;
    }

    @Override
    public DataItem find(int key) {
        int hashKey = hashTransfer(key);
        int stepSize = reHash(key);
        while (mHashArray[hashKey] != null) {
            if (mHashArray[hashKey].getData() == key) {
                return mHashArray[hashKey];
            }
            hashKey += stepSize;
            hashKey %= mMaxSize;
        }
        return null;
    }

    public void display() {
        for (int i = 0; i < mMaxSize; i++) {
            if (mHashArray[i] != null) {
                Logger.print(mHashArray[i].getData() + " ");
            } else {
                Logger.print("* ");
            }
        }
    }

    private int reHash(int key) {
        return 5 - key % 5;
    }
}
