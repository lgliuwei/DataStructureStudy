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

    public void insertHeader(int id) {
        Node node = new Node(id);
        if (isEmpty()) {
            tail = node; // 头部插入,如果链表为空时,需要同时把节点赋值给 tail
        }
        node.next = header;
        header = node;
    }

    public void insertTail(int id) {
        Node node = new Node(id);
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

    public Node delete(int id) {
        if (!isEmpty()) {
            Node node = header;
            if (node.id == id) {
                header = header.next;
                return node;
            }
            while (node.next != null) {
                if (node.next.id == id) {
                    Node tempNode = node.next;
                    node.next = node.next.next;

                    if (node.next == null) {
                        tail = node; // 双端链表删除逻辑与头部插入链表逻辑类似,只有这里需要注意,
                                     // 当删除的节点为最后一个节点时,需要将tail往前提一个节点。
                    }

                    return tempNode;
                }
                node = node.next;
            }
        }
        return null;
    }

    public Node find(int id){
        if (!isEmpty()) {
            Node node = header;
            while (node != null) {
                if (node.id == id) {
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
            Logger.print(node.id);
            while (node.next != null) {
                node = node.next;
                Logger.print("->" + node.id);
            }
        } else {
            Logger.println("error!, link is emtpy");
        }
    }
}
