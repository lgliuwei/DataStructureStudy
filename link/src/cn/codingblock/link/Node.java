package cn.codingblock.link;

/**
 * Created by liuwei on 17/8/9.
 */
public class Node {
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
//        return "Node{" +
//                "val=" + val +
//                ", next=" + next +
//                '}';
        return val + "->" + next;
    }
}
