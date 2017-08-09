package cn.codingblock.link;

/**
 * Created by liuwei on 17/8/9.
 */
public class Node {
    public int id;
    public Node next;

    public Node(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", next=" + next +
                '}';
    }
}
