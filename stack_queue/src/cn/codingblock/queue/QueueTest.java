package cn.codingblock.queue;

import cn.codingblock.utils.Logger;

/**
 * Created by liuwei on 17/7/29.
 */
public class QueueTest {

    public static void main(String[] strs) {
        // 1、有计数项的队列示例
//        Queue queue = new Queue(10);
        // 2、 无技术项的队列示例
        Queue1 queue = new Queue1(10);
        int n = -1;
        Logger.println("已入队列的元素:");
        while (!queue.isFull()) {
            Logger.print(++n + " ");
            queue.insert(n);
            Logger.print("[size:" + queue.size() + "] ");
        }

        Logger.println("\n已出队列的元素:");
        while (!queue.isEmpty()) {
            Logger.print(queue.remove() + " ");
        }
    }
}
