package cn.codingblock.link;


import cn.codingblock.utils.log.Logger;

/**
 * Created by liuwei on 17/8/9.
 */
public class Test {
    /**
     * 给出链表 1->2->3->3->4->5->3, 和 val = 3, 你需要返回删除3之后的链表：1->2->4->5。
     * @param strs
     */
    public static void main(String[] strs) {
        Link link = new Link();
        link.insert(1);
        link.insert(1);
        link.insert(3);
        link.insert(3);
        link.insert(4);
        link.insert(5);
        link.insert(3);
        link.display();
        Logger.println("\n");
        ListNode list = link.insertionSortList(link.getListNode());
        while (list != null) {
            Logger.print(list.val + "->");
            list = list.next;
        }
        Logger.print("null");
//        link.delet();
    }
}
