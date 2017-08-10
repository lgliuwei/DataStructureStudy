package cn.codingblock.link;

import cn.codingblock.utils.log.Logger;

/**
 * 头部插入的链表
 * Created by liuwei on 17/8/9.
 */
public class HeaderLink {
    private Node header;

    public HeaderLink() {
        this.header = null;
    }

    /**
     * 插入
     * @param val
     */
    public void insert(int val) {
        /*
            1、创建新节点
            2、将新节点的 next 指向 header
            3、将新节点赋值给 header
         */
        Node node = new Node(val);
        node.next = header;
        header = node;
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
        int count = 0;// 删除节点的个数
        if (!isEmpty()) {
            Node currentNode = header;
            Node preNode = null;
            while (currentNode != null) {
                if (currentNode.val == val) {
                    if (currentNode == header) {
                        header = header.next; // 需要删除的节点为第一个节点时,只需将header的下一个节点赋值给header即可。
                        preNode = currentNode;// 在将当前节点置为下一个节点前,先把preNode赋值为当前节点
                    } else {
                        preNode.next = currentNode.next; // 需要删除的节点不是第一个时,需要将前一个节点的next指向当前节点的下一个节点。
                    }
                    count++;
                } else {
                    preNode = currentNode; // 在将当前节点置为下一个节点前,先把preNode赋值为当前节点
                }
                currentNode = currentNode.next; // 将当前节点赋值为下一个节点
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
