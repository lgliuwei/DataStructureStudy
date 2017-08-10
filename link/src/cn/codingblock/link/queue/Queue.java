package cn.codingblock.link.queue;

import cn.codingblock.link.Node;
import cn.codingblock.utils.log.Logger;

/**
 * Created by liuwei on 17/8/10.
 */
public class Queue {

    private Node tail;
    private Node header;
    private int size;

    public Queue() {
        this.header = null;
        this.tail = null;
        this.size = 0;
    }

    public void insert(int e) {
        Node node = new Node(e);
        if (isEmpty()) {
            header = node;
        } else {
            tail.next = node;
        }
        tail = node;
        size++;
    }

    public int remove() throws NullPointerException {
        if (!isEmpty()) {
            Node node = header;
            header = header.next;
            if (header == null) {
                tail = null;
            }
            size--;
            return node.val;
        }
        throw new NullPointerException("Queue is empty!");
    }

    public int peek() throws NullPointerException {
        if (!isEmpty()) {
            return header.val;
        }
        throw new NullPointerException("Queue is empty!");
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void display() {
        if (!isEmpty()) {
            Logger.println(header);
        } else {
            Logger.println("null");
        }
    }

}
