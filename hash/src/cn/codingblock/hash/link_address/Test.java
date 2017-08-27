package cn.codingblock.hash.link_address;

import cn.codingblock.utils.log.Logger;

/**
 * Created by liuwei on 17/8/25.
 */
public class Test {
    public static void main(String[] strs) {
        HashChain hashChain = new HashChain(10);
        hashChain.insert(new Node(9));
        hashChain.insert(new Node(7));
        hashChain.insert(new Node(0));
        hashChain.insert(new Node(4));
        hashChain.insert(new Node(6));
        hashChain.insert(new Node(16));
        hashChain.insert(new Node(17));
        hashChain.insert(new Node(19));
        hashChain.insert(new Node(10));
        hashChain.insert(new Node(1));
        hashChain.insert(new Node(23));
        hashChain.display();
        Logger.println("find19:" + hashChain.find(19));
        Logger.println("find0:" + hashChain.find(0));
        Logger.println("find11:" + hashChain.find(11));
        Logger.println("find1:" + hashChain.find(1));
        hashChain.delete(10);
        hashChain.delete(9);
        hashChain.delete(20);
        hashChain.delete(1);
        hashChain.display();
    }
}
