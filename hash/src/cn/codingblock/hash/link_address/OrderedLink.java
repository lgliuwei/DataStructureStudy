package cn.codingblock.hash.link_address;

import cn.codingblock.utils.log.Logger;

/**
 * Created by liuwei on 17/8/25.
 */
public class OrderedLink {

    private Node header;

    public void insert(Node newNode) {
        if (newNode == null) {
            return;
        }
        Node currentNode = header;
        Node preNode = null;

        while (currentNode != null && currentNode.val < newNode.val) {
            preNode = currentNode;
            currentNode = currentNode.next;
        }

        if (preNode == null) {
            newNode.next = header;
            header = newNode;
        } else {
            newNode.next = currentNode;
            preNode.next = newNode;
        }

    }

    /**
     * 查找首个val
     * @param val
     * @return
     */
    public Node find(int val) {
        Node currentNode = header;
        while (currentNode != null) {
            if (currentNode.val == val) {
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null;
    }

    /**
     * 删除首个val
     * @param val
     * @return
     */
    public Node delete(int val) {
        Node currentNode = header;
        Node preNode = null;
        while (currentNode != null && currentNode.val != val) {
            preNode = currentNode;
            currentNode = currentNode.next;
        }
        if (currentNode != null) {
            Node temp = currentNode;
            if (currentNode == header) {
                header = header.next;
            } else {
                preNode.next = currentNode.next;
            }
            return temp;
        }
        return null;
    }
    
    public void display() {
        Node currentNode = header;
        while (currentNode != null) {
            Logger.print(currentNode.val + "->");
            currentNode = currentNode.next;
        }
        Logger.println("null");
    }

}
