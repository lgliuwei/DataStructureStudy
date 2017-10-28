package cn.codingblock.heap;

/**
 * 队列(堆实现)
 * Created by liuwei on 17/8/29.
 */
public class PriorityQueue {

    private Heap heap;

    public PriorityQueue(int maxSize) {
        this.heap = new Heap(maxSize);
    }

    public void insert(int val) {
        heap.insert(val);
    }

    public Node remove() {
        if (!heap.isEmpty()) {
            return heap.remove();
        } else {
            return null;
        }
    }

    public void changePriority(int index, int val) {
        heap.change(index, val);
    }

    public void display() {
        heap.display();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public boolean isFull() {
        return heap.isFull();
    }
 }
