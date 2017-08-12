package cn.codingblock.link;

import cn.codingblock.utils.log.Logger;
import sun.rmi.runtime.Log;

/**
 * Created by liuwei on 17/8/9.
 */
public class Link {
    ListNode header = null;

    public void display(){
        ListNode listNode = header;
        while (listNode != null) {
            Logger.print(listNode.val + "->");
            listNode = listNode.next;
        }
        Logger.print("null");
    }

    public void insert(int x){
        ListNode listNode = new ListNode(x);
        listNode.next = header;
        header = listNode;
    }

    public void delet(){
        header = removeElements(header, 1);
        display();
    }

    public ListNode getListNode(){
        return header;
    }

    /**
     * 移除链表的val节点
     * @param head a ListNode
     * @param val an integer
     * @return a ListNode
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head != null) {
            ListNode currentNode = head;
            ListNode preNode = null;
            while (currentNode != null) {
                if (currentNode.val == val) {
                    if (currentNode == head) {
                        head = head.next;
                        preNode = currentNode;
                    } else {
                        preNode.next = currentNode.next;
                    }
                } else {
                    preNode = currentNode;
                }
                currentNode = currentNode.next;
            }
        }
        return head;
    }

    /**
     * 插入排序
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        ListNode listNode = null;
        ListNode currentNode;
        ListNode preNode;
        while (head != null) {
            ListNode newNode = new ListNode(head.val);
            currentNode = listNode;
            preNode = null;
            while (currentNode != null && currentNode.val < head.val) {
                preNode = currentNode;
                currentNode = currentNode.next;
            }
            if (preNode == null) {
                newNode.next = listNode;
                listNode = newNode;
            } else {
                newNode.next = currentNode;
                preNode.next = newNode;
            }
            head = head.next;
        }
        return listNode;
    }

    /**
     * 合并链表
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode currentNode;
        ListNode preNode;
        while (l2 != null) {
            currentNode = l1;
            preNode = null;
            ListNode newNode = new ListNode(l2.val);
            while (currentNode != null && currentNode.val < l2.val) {
                preNode = currentNode;
                currentNode = currentNode.next;
            }
            if (preNode == null) {
                newNode.next = l1;
                l1 = newNode;
            } else {
                newNode.next = currentNode;
                preNode.next = newNode;
            }
            l2 = l2.next;
        }
        return l1;
    }
}
