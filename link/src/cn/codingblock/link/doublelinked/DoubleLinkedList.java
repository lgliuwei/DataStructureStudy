package cn.codingblock.link.doublelinked;

import cn.codingblock.utils.log.Logger;

/**
 * 双向链表
 * Created by liuwei on 17/8/11.
 */
public class DoubleLinkedList {

    private DoubleLinkNode header;
    private DoubleLinkNode tail;

    public DoubleLinkedList() {
        this.header = null;
        this.tail = null;
    }

    public void insertHead(int val) {
        DoubleLinkNode newNode = new DoubleLinkNode(val);// 1、创建一个新节点
        if (isEmpty()) {            // 1.2、如果链表为空时,新增第一节点需要将tail也赋值为当前节点
            tail = newNode;
        } else {
            header.pre = newNode;   // 2.1、链表非空情况下需要将header的pre指向新节点
        }
        newNode.next = header;      // 2、将新节点的next指向header
        header = newNode;           // 3、将header赋值为新节点

    }

    public void insertTail(int val) {
        DoubleLinkNode newNode = new DoubleLinkNode(val);
        if (isEmpty()) {
            header = newNode;
        } else {
            tail.next = newNode;
        }
        newNode.pre = tail;
        tail = newNode;
    }

    /**
     * 插入到第一次 val 出现的位置之后
     * @param val
     * @param afterValue
     */
    public void insertAfter(int val, int afterValue) {
        if (!isEmpty()) {
            DoubleLinkNode currentNode = header;
            while (currentNode != null && currentNode.val != val) {
                currentNode = currentNode.next;
                                                // 1、一直循环,直到当前节点的值等于val
            }
            if (currentNode == null) {
                Logger.println("sorry, not find:" + val);
            } else {
                DoubleLinkNode newNode = new DoubleLinkNode(afterValue);
                if (currentNode.next == null) {
                    tail = newNode;             // 1.1、如果插入的位置是最后一个节点,需要将tail赋值为新节点
                } else {
                    currentNode.next.pre = newNode; // 1.2、先将当前节点的下一个节点的pre指向新节点
                }
                newNode.pre = currentNode;      // 2、将新节点的pre指向当前节点
                newNode.next = currentNode.next;// 3、当新节点的next指向下一个节点
                currentNode.next = newNode;     // 4、将当前节点的next指向新节点

            }
        } else {
            Logger.println("error, link is empty!");
        }
    }

    public DoubleLinkNode delHeader() {
        if (!isEmpty()) {
            DoubleLinkNode node = header;
            header = header.next; // 1、将header后移一个节点
            if (header != null) { // 2、如果此时为null,需要将tail置为null
                header.pre = null;// 3、不为null,需要将header的前缀置为null
            } else {
                tail = null;
            }
            return node;
        }
        return null;
    }

    public DoubleLinkNode delTail() {
        if (!isEmpty()) {
            DoubleLinkNode node = tail;
            tail = tail.pre;
            if (tail != null) {
                tail.next = null;
            } else {
                header = null;
            }
            return node;
        }
        return null;
    }

    public DoubleLinkNode delFirstKey(int val) {
        if (!isEmpty()) {
            DoubleLinkNode currentNode = header;
            while (currentNode != null && currentNode.val != val) {
                currentNode = currentNode.next;
            }
            if (currentNode == null) {
                Logger.println("sorry, not find:" + val);
            } else {
                DoubleLinkNode node = currentNode;
                if (currentNode == header) {
                    header = currentNode.next; // 1、如果是头节点,则将header后移一个节点
                } else {
                    currentNode.pre.next = currentNode.next; // 1.1、非头结点的情况下,将当前节点的前缀节点的next指向当前节点的下一个
                }

                if (currentNode == tail) {
                    tail = currentNode.pre; // 2、如果是尾节点,则将tail前移
                } else {
                    currentNode.next.pre = currentNode.pre; // 2.1、非尾节点时,将下一个节点的前缀指向前一个节点
                }

                return node;

//                DoubleLinkNode node = currentNode;
//                if (header == tail) {
//                    // 只剩下一个节点,将header和tail置为null即可
//                    header = tail = null;
//                    return node;
//                }
//                if (currentNode.next == null) {
//                    // 1、如果为最后一个节点
//                    tail = currentNode.pre;
//                    tail.next = null;
//                } else if (currentNode.pre == null) {
//                    // 2、如果为第一个节点
//                    header = currentNode.next;
//                    header.pre = null;
//                } else {
//                    // 3、当前节点若不是最后一个也不是第一个
//                    currentNode.next.pre = currentNode.pre;
//                    currentNode.pre.next = currentNode.next;
//                }
//                return node;
            }
        }
        return null;
    }

    public int delAllKey() {
        int count = 0;
        return count;
    }

    public void displayFromHeader() {
        DoubleLinkNode node = header;
        while (node != null) {
            Logger.print(node.val + "n->");
            node = node.next;
        }
        Logger.println("null");
    }

    public void displayFormTail() {
        DoubleLinkNode node = tail;
        while (node != null) {
            Logger.print(node.val + "p->");
            node = node.pre;
        }
        Logger.println("null");
    }

    public boolean isEmpty() {
        return header == null;
    }
}
