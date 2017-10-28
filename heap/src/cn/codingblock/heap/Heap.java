package cn.codingblock.heap;

import cn.codingblock.utils.log.Logger;

/**
 * 堆
 *   如:
 *                  ⑩
 *          ⑧              ⑨
 *      ②     ③        ⑥      ⑦
 *   对应数组: 10-8-9-2-3-6-7
 * Created by liuwei on 17/8/29.
 */
public class Heap {
    private int mMaxSize;
    private int mCurrentSize;
    private Node[] mHeapArray;

    public Heap(int maxSize) {
        mMaxSize = maxSize;
        mHeapArray = new Node[mMaxSize];
        mCurrentSize = 0;
    }

    /**
     * 插入
     *  1、将新数据插入到数组的尾端
     *  2、通过向上筛选的算法将新插入的数组移到合适的位置
     *  3、数组实际尺寸+1
     * @param val
     */
    public boolean insert(int val) {
        if (isFull()) {
            return false;
        }
//        mHeapArray[mCurrentSize++] = new Node(val);
        mHeapArray[mCurrentSize] = new Node(val);
        trickleUp(mCurrentSize++);
        return true;
    }

    /**
     * 删除
     *  1、删除根节点
     *  2、把数组的最后一个节点移到跟节点
     *  3、把新的根节点向下筛选以符合堆的要求
     *  4、数组实际尺寸-1
     * @return
     */
    public Node remove() {
        if (isEmpty()) {
            return null;
        }
        Node root = mHeapArray[0];
        mHeapArray[0] = mHeapArray[mCurrentSize - 1];
        mCurrentSize--;
        trickleDown(0);
        return root;
    }

    /**
     * 改变index节点的优先级
     * @param index
     * @param val
     */
    public void change(int index, int val) {
        if (index >= 0 && index < mCurrentSize) {
            int oldVal = mHeapArray[index].val;
            mHeapArray[index].val = val;
            if (val > oldVal) { // 如果调高了优先级就向上筛选,否则向下筛选
                trickleUp(index);
            } else {
                trickleDown(index);
            }
        }
    }

    public boolean isEmpty() {
        return mCurrentSize == 0;
    }

    public boolean isFull() {
        return mCurrentSize == mMaxSize;
    }

    public void display() {
        for (int i = 0; i < mCurrentSize; i++) {
            Logger.println("[" + i + "]" + mHeapArray[i].val);
        }
    }

    /**
        * 将 index 位置的元素向上筛选
     * 思路:将index节点与其父节点对比,如果index节点大于父节点就将其和父节点调换
     * @param index
     */
    private void trickleUp(int index) {
        // 1、获取index节点的父节点下标
        int pIndex = (index - 1) / 2;
        // 2、将当前的节点临时存起来,以便把 index 节点看做一个"洞",通过洞的上移来确定currentNode的合适位置
        Node tempNode = mHeapArray[index];
        // 3、循环将"洞"上移
        while (index > 0 && tempNode.val > mHeapArray[pIndex].val) {
            mHeapArray[index] = mHeapArray[pIndex];
            index = pIndex;
            pIndex = (index - 1) / 2;
        }
        // 4、将tempNode放入"洞"中
        mHeapArray[index] = tempNode;
    }

    /**
     * 将index节点向下筛选
     * 思路: 将当前节点与其左右子节点中较大的节点对比,若小于子节点则和子节点调换
     * @param index
     */
    private void trickleDown(int index) {
        Node tempNode = mHeapArray[index];
        int subLeft;
        int subRight;
        int largeRight;
        while (index < mCurrentSize / 2) {
            subLeft = 2*index + 1;
            subRight = subLeft + 1;
            if (subRight < mCurrentSize && mHeapArray[subRight].val > mHeapArray[subLeft].val) {
                largeRight = subRight;
            } else {
                largeRight = subLeft;
            }

            if (tempNode.val < mHeapArray[largeRight].val) {
                mHeapArray[index] = mHeapArray[largeRight];
                index = largeRight;
            } else {
                break;
            }
        }
        mHeapArray[index] = tempNode;
    }

    /**
     * 堆排序
     * 思路: 简单来说,对一组数据利用向上筛选的方式插入,然后在用向下筛选的方式remove即可得到一组有序的数据
     *  insert() 和 remove() 的时间复杂都是O(logN),并且每个方法都执行N次,所以堆排序的时间复杂度O(NlogN)时间
     *  向下筛选到合适的位置:
     *
     */
    public void heapSort() {
        for (int i = mCurrentSize / 2 - 1; i >= 0; i--) {
            trickleDown(i);
        }
    }

    /**
     * 堆排序(递归)
     */
    public void heapSortByRecurision() {
        if (!isEmpty()) {
            heapify(0);
        }
    }

    private void heapify(int index) {
        if (index > mCurrentSize / 2 - 1) {
            return;
        }
        heapify(2 * index + 1);
        heapify(2 * index + 2);
        trickleDown(index);
    }
}
