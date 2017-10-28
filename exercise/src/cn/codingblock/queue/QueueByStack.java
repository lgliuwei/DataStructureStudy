package cn.codingblock.queue;

import cn.codingblock.utils.log.Logger;

import java.util.Stack;

public class QueueByStack {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    public QueueByStack() {
        // do intialization if necessary
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /*
     * @param element: An integer
     * @return: nothing
     */
    public void push(int element) {
        // write your code here
        stack1.push(element);
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        if (stack2.isEmpty()) {
            while (stack1.isEmpty()) {
                stack2.push(stack1.push(pop()));
            }
        }

        return stack2.pop();
    }

    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        if (stack2.isEmpty()) {
            while (stack1.isEmpty()) {
                stack2.push(stack1.push(pop()));
            }
        }

        return stack2.peek();
    }

    public static void main(String[] strs) {
        QueueByStack queueByStack = new QueueByStack();
        queueByStack.push(1);
        queueByStack.push(2);
        queueByStack.push(3);
        Logger.println(queueByStack.top());
        Logger.println(queueByStack.pop());
        Logger.println(queueByStack.pop());
        Logger.println(queueByStack.pop());
        Logger.println(queueByStack.pop());
    }
}
