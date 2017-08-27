package cn.codingblock.hash.link_address;

import cn.codingblock.utils.log.Logger;

/**
 * Created by liuwei on 17/8/25.
 */
public class Test {
    public static void main(String[] strs) {
        OrderedLink orderedLink = new OrderedLink();
        orderedLink.insert(5);
        orderedLink.insert(9);
        orderedLink.insert(4);
        orderedLink.insert(2);
        orderedLink.insert(0);
        orderedLink.insert(1);
        orderedLink.display();
        Logger.println("find: " + orderedLink.find(9));
        Logger.println("find: " + orderedLink.find(10));
        Logger.println("delete:" + orderedLink.delete(9));
        orderedLink.display();

    }
}
