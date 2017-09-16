package cn.codingblock.heap;

import cn.codingblock.utils.log.Logger;

/**
 * Created by liuwei on 17/8/29.
 */
public class HeapTest {
    public static void main(String[] strs) {
        // 堆测试
//        Heap heap = new Heap(10);
//        heap.insert(7);
//        heap.insert(10);
//        heap.insert(9);
//        heap.insert(6);
//        heap.insert(2);
//        heap.insert(11);
//        heap.display();
////        heap.heapSort();
//        heap.heapSortByRecurision();
//        while (!heap.isEmpty()) {
//            Logger.println(heap.remove().val);
//        }
////        Logger.println("change:");
////        heap.change(0, 1);
////        heap.display();
        // 优先级队列测试
        PriorityQueue priorityQueue = new PriorityQueue(10);
        priorityQueue.insert(6);
        priorityQueue.insert(16);
        priorityQueue.insert(10);
        priorityQueue.insert(2);
        priorityQueue.insert(7);
        priorityQueue.insert(5);
        priorityQueue.insert(0);
        priorityQueue.insert(8);
        priorityQueue.insert(20);
        priorityQueue.insert(17);
        priorityQueue.display();
        while (!priorityQueue.isEmpty()) {
            Logger.print(priorityQueue.remove().val + " ");
        }
    }
}
