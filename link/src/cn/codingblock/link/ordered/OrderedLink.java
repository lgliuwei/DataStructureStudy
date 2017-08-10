package cn.codingblock.link.ordered;

import cn.codingblock.link.Node;
import cn.codingblock.utils.log.Logger;

/**
 * 正序
 * Created by liuwei on 17/8/10.
 */
public class OrderedLink {
    private Node header;
    private Node tail;// 尾巴,正序插入时使用

    public OrderedLink() {
        this.header = null;
        this.tail = null;
    }

    /**
     * 正序
     * @param val
     */
    public void orderedInsert(int val) {
        Node newNode = new Node(val);
        Node currentNode = header;
        Node preNode = null;
        while (currentNode != null) {
            if (val < currentNode.val) {
                if (currentNode == header) {
                    newNode.next = header;
                    header = newNode;
                } else {
                    preNode.next = newNode;
                    newNode.next = currentNode;
                }
                return;
            }
            preNode = currentNode;
            currentNode = currentNode.next;
        }
        // 如果遍历完链表后依然没有大于val的,则需要将val插入到链表的尾巴上
        if (isEmpty()) {
            header = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    public boolean isEmpty() {
        return header == null;
    }

    public void display(){
        Logger.print(header);
    }
}
