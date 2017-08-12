package cn.codingblock.link.ordered;

import cn.codingblock.link.Node;
import cn.codingblock.utils.log.Logger;

/**
 * 有序链表
 * Created by liuwei on 17/8/10.
 */
public class OrderedLink {
    private Node header;

    public OrderedLink() {
        this.header = null;
    }

    /**
     * 正序插入
     * @param val
     */
    public void orderedInsert(int val) {
        Node newNode = new Node(val);
        Node currentNode = header;
        Node preNode = null;

        // 遍历有序链表,直到找到第一个小于val的节点时结束循环(如果逆序,改成大于即可)
        while (currentNode != null && currentNode.val < val) {
            preNode = currentNode;
            currentNode = currentNode.next;
        }
        // 如果preNode 为null,则说明val需要插入在头上
        if (preNode == null) {
            newNode.next = header;
            header = newNode;
        } else { // 否则,将新节点的next只想当前节点,将当前节点的上个节点的next指向新节点
            newNode.next = currentNode;
            preNode.next = newNode;
        }
    }

    public boolean isEmpty() {
        return header == null;
    }

    public void display(){
        Logger.print(header);
    }
}
