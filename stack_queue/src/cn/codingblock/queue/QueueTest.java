package cn.codingblock.queue;

import cn.codingblock.utils.log.Logger;

/**
 * Created by liuwei on 17/7/29.
 */
public class QueueTest {

    public static void main(String[] strs) {
        // 1、有计数项的队列示例
//        Queue queue = new Queue(10);

        // 2、无计数项的队列示例
//        Queue1 queue = new Queue1(10);
//        int n = -1;
//        Logger.println("已入队列的元素:");
//        while (!queue.isFull()) {
//            Logger.print(++n + " ");
//            queue.insert(n);
//            Logger.print("[size:" + queue.size() + "] ");
//        }
//
//        Logger.println("\n已出队列的元素:");
//        while (!queue.isEmpty()) {
//            Logger.print(queue.remove() + " ");
//        }
        // 3、优先级队列
        PriorityQueue priorityQueue = new PriorityQueue(10);
        priorityQueue.insert(3);
        priorityQueue.insert(4);
        priorityQueue.insert(7);
        priorityQueue.insert(8);
        priorityQueue.insert(1);
        priorityQueue.insert(0);
        priorityQueue.insert(9);
        priorityQueue.insert(5);
        priorityQueue.insert(6);
        priorityQueue.insert(2);

        while (!priorityQueue.isEmpty()) {
            Logger.print(priorityQueue.remove() + " ");
        }

    }
}
