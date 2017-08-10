package cn.codingblock.link.queue;

import cn.codingblock.link.stack.Stack;
import cn.codingblock.utils.log.Logger;

import java.util.Locale;

/**
 * Created by liuwei on 17/8/10.
 */
public class QueueTest {

    public static void main(String[] strs) {
        Queue queue = new Queue();
        queue.insert(0);
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        Logger.println("入队:0 1 2 3");
        Logger.print("出队:");
        while (!queue.isEmpty()) {
            Logger.print(queue.remove()+ " ");
        }

        queue.insert(5);
        queue.insert(7);
        queue.insert(8);
        queue.insert(4);
        Logger.println("\n\n再入队:5 7 8 4");

        Logger.print("再出队:");
        while (!queue.isEmpty()) {
            Logger.print(queue.remove()+ " ");
        }
    }
}
