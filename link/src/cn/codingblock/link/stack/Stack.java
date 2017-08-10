package cn.codingblock.link.stack;

import cn.codingblock.link.Node;
import cn.codingblock.utils.log.Logger;

/**
 * 栈(链表)
 * Created by liuwei on 17/8/10.
 */
public class Stack {

    private Node header;
    private int size;

    public Stack() {
        this.header = null;
        this.size = 0;
    }

    public void push(int e) {
        Node node = new Node(e);
        node.next = header;
        header = node;
        size++;
    }

    public int pop() throws NullPointerException {
        if (!isEmpty()) {
            Node node = header;
            header = header.next;
            size--;
            return node.val;
        } else {
            throw new NullPointerException("Stack is empty!");
        }
    }

    public int peek() throws NullPointerException {
        if (!isEmpty()) {
            return header.val;
        } else {
            throw new NullPointerException("Stack is empty!");
        }
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void display(){
        if (!isEmpty()) {
            Logger.println(header);
        } else {
            Logger.println("null");
        }
    }
}
