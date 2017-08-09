package cn.codingblock.link;

import cn.codingblock.utils.log.Logger;

/**
 * Created by liuwei on 17/8/9.
 */
public class LinkTest {
    public static void main(String[] strs){
//        HeaderLink headerLink = new HeaderLink();
//        headerLink.insert(0);
//        headerLink.insert(1);
//        headerLink.insert(2);
//        headerLink.insert(3);
//        headerLink.insert(4);
//        headerLink.insert(5);
//        headerLink.insert(6);
//        headerLink.insert(7);
//        headerLink.insert(8);
//        headerLink.display();
//        Logger.println("\n查找:" + headerLink.find(5));
//        Logger.println("\n查找:" + headerLink.find(9));

        HeaderTailLink link = new HeaderTailLink();
        link.insertTail(0);
        link.insertTail(1);
        link.insertTail(2);
        link.insertTail(3);
        link.delete(3);
        link.insertTail(4);
        link.display();
        Logger.println("\n查找:" + link.find(3));

    }
}
