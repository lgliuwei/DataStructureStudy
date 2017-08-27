package cn.codingblock.hash.open_address;

/**
 * 哈希表
 * Created by liuwei on 17/8/24.
 */
public abstract class BaseHashTable {

    protected DataItem[] mHashArray;
    protected int mMaxSize;// 最大容量
    protected int mItems;// 当前个数
    protected DataItem nonItem;// 被删除的item
    public BaseHashTable(int size) {
        mMaxSize = size;
        nonItem = new DataItem(-1);
        mItems = 0;
    }

    public abstract void insert(DataItem item);

    public abstract boolean delete(int key);

    public abstract DataItem find(int key);

    public abstract void display();

    /**
     * 将key哈希化
     * @param key
     * @return
     */
    protected int hashTransfer(int key) {
        return key % mMaxSize;
    }
}
