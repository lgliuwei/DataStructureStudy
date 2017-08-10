package cn.codingblock.link;

import cn.codingblock.utils.log.Logger;

/**
 * 双端插入的链表(非双向)
 * Created by liuwei on 17/8/9.
 */
public class HeaderTailLink {
    private Node header; // 头
    private Node tail; // 尾

    public HeaderTailLink() {
        this.header = null;
        this.tail = null;
    }

    public void insertHeader(int val) {
        Node node = new Node(val);
        if (isEmpty()) {
            tail = node; // 头部插入,如果链表为空时,需要同时把节点赋值给 tail
        }
        node.next = header;
        header = node;
    }

    public void insertTail(int val) {
        Node node = new Node(val);
        if (isEmpty()) {
            header = node; // 尾部插入,如果链表为空时,需要同时把节点赋值给 header
        } else {
            tail.next = node;
        }
        tail = node;
    }

    public Node deleteHeader() {
        if (!isEmpty()) {
            Node node = header;
            header = header.next;
            return node;
        }
        return null;
    }

    public int delete(int val) {
        int count = 0;
        if (!isEmpty()) {
            Node currentNode = header;
            Node preNode = null;
            while (currentNode != null) {
                if (currentNode.val == val) {
                    if (currentNode == header) {
                        header = header.next;
                        preNode = currentNode;
                    } else {
                        preNode.next = currentNode.next;
                    }
                    count++;
                    if (currentNode.next == null) {
                        // 如果当前被删除的节点是最后一个节点的话,需要将tail赋值为当前节点的前一个节点
                        tail = preNode;
                    }
                } else {
                    preNode = currentNode;
                }
                currentNode = currentNode.next;
            }
        }
        return count;
    }

    public Node find(int id){
        if (!isEmpty()) {
            Node node = header;
            while (node != null) {
                if (node.val == id) {
                    return node;
                }
                node = node.next;
            }
        }
        return null;
    }

    public boolean isEmpty(){
        return header == null;
    }

    public void display() {
        if (!isEmpty()) {
            Node node = header;
            Logger.print(node.val);
            while (node.next != null) {
                node = node.next;
                Logger.print("->" + node.val);
            }
        } else {
            Logger.println("error!, link is emtpy");
        }
    }
}
