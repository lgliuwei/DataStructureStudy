package cn.codingblock.link.ordered;

import cn.codingblock.link.Node;

/**
 * 插入排序
 * Created by liuwei on 17/8/11.
 */
public class InsertionSortLink {

    public Node insertionSort(Node link){
        Node header = null;
        Node currentNode;
        Node preNode;
        while (link != null) {
            Node newNode = new Node(link.val);
            currentNode = header;
            preNode = null;
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
            link = link.next;
        }
        return header;
    }
}
