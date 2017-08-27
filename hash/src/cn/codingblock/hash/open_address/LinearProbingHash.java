package cn.codingblock.hash.open_address;

import cn.codingblock.utils.log.Logger;

/**
 * 线性探测哈希表
 * Created by liuwei on 17/8/24.
 */
public class LinearProbingHash extends BaseHashTable {

    public LinearProbingHash(int size) {
        super(size);
        mHashArray = new DataItem[size];
    }

    /**
     * 插入
     *  1、计算出要插入的item的哈希值 hashKey (作为数组下标用)
     *  2、将新item插入到数组的 hashKey 下标中
     *  3、如果 hashKey 下标在数组中已经有值了(不为null,并且当前值不等于-1),就按顺序寻找下一个下标,直到找到空位置(null, 或者值为-1的位置)
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
        // 通过线性探测(从当前下标起按顺序寻找下一个,直到有空位置即可)寻找item的插入点
        while (mHashArray[hashKey] != null && mHashArray[hashKey].getData() != -1) {
            hashKey++;
            hashKey %= mMaxSize;// 如果hashKey超出了数组的范围,就对hashKey取余操作,这样就能保证数据可以在循环插入到数组了
        }
        mHashArray[hashKey] = item;
        mItems++;
    }

    /**
     * 删除
     *  1、计算出待删除数据的hashKey以确定其下标
     *  2、在数组中从hashKey下标开始匹配,直到找到待删除数据
     *  3、将找到的下标赋值为nonItem
     *          (注意:因为查询方法中是从hashKey下标开始匹配,
     *           如果匹配过程中遇到了null,就认为没有要查询的数据,不会再匹配了,所以这里删除数据时不置为null)
     * @param key
     * @return
     */
    @Override
    public boolean delete(int key) {
        int hashKey = hashTransfer(key);
        while (mHashArray[hashKey] != null) {
            if (mHashArray[hashKey].getData() == key) {
                mHashArray[hashKey] = nonItem;
                mItems--;
                return true;
            }
            hashKey++;
            hashKey %= mMaxSize;
        }
        return false;
    }

    @Override
    public DataItem find(int key) {
        int hashKey = hashTransfer(key);
        while (mHashArray[hashKey] != null) {
            if (mHashArray[hashKey].getData() == key) {
                return mHashArray[hashKey];
            }
            hashKey++;
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
}
