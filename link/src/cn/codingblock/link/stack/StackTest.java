package cn.codingblock.link.stack;

import cn.codingblock.utils.log.Logger;

/**
 * Created by liuwei on 17/8/10.
 */
public class StackTest {

    public static void main(String[] strs) {
        Stack stack = new Stack();
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        Logger.println("入栈:0 1 2 3");

        Logger.print("出栈:");
        while (!stack.isEmpty()) {
            Logger.print(stack.pop() + " ");
        }

    }
}
