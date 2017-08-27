package cn.codingblock.hash.link_address;

import cn.codingblock.hash.open_address.DataItem;

/**
 * Created by liuwei on 17/8/25.
 */
public class HashChain {
    protected OrderedLink[] mHashArray;
    protected int mMaxSize;// 最大容量
    protected int mItems;// 当前个数

    public HashChain(int size) {
        mMaxSize = size;
        mHashArray = new OrderedLink[size];
        mItems = 0;
    }

    public void insert(Node item) {

    }

    public boolean delete(int key) {
        return false;
    }

    public DataItem find(int key) {
        return null;
    }

    public void display() {

    }
}
