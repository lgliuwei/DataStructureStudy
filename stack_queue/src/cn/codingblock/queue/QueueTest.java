package cn.codingblock.queue;

import cn.codingblock.utils.Logger;

/**
 * Created by liuwei on 17/7/29.
 */
public class QueueTest {

    public static void main(String[] strs) {
        Queue queue = new Queue(10);
        queue.insert(0);
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);
        queue.insert(6);
        queue.insert(7);
        queue.insert(8);
        queue.insert(9);
        Logger.println(queue.remove());
        Logger.println(queue.remove());
        Logger.println(queue.remove());
        Logger.println(queue.remove());
        queue.insert(0);
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        Logger.println(queue.remove());
        Logger.println("queue:");
        while (!queue.isEmpty()) {
            Logger.println(queue.remove());
        }
    }
}
