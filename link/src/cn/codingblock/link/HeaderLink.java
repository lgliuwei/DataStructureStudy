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
     * @param id
     */
    public void insert(int id) {
        /*
            1、创建新节点
            2、将新节点的 next 指向 header
            3、将新节点赋值给 header
         */
        Node node = new Node(id);
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

    public Node delete(int id) {
        if (!isEmpty()) {
            Node node = header;
            if (node.id == id) {
                // 如果需要删除的是第一个,则将直接将header的下一个节点赋值给header即可。
                header = header.next;
                return node;
            }
            while (node.next != null) {
                // 否则就循环判断 【当前节点的下一个元素】 是否符合删除条件
                if (node.next.id == id) {
                    Node tempNode = node.next;
                    node.next = node.next.next; // 如果符合条件,则直接把当前节点的next指向下下个节点
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
