package cn.codingblock.link;

import cn.codingblock.utils.log.Logger;
import sun.rmi.runtime.Log;

/**
 * Created by liuwei on 17/8/9.
 */
public class LinkTest {
    public static void main(String[] strs){
//        HeaderLink headerLink = new HeaderLink();
//        headerLink.insert(1);
//        headerLink.insert(1);
//        headerLink.insert(2);
//        headerLink.insert(3);
//        headerLink.insert(1);
//        headerLink.display();
////        Logger.println("\n 删除个数:" + headerLink.delete(1));
//        Logger.println("\nfind:" + headerLink.find(1));
//        Logger.println("");
//        headerLink.display();

        HeaderTailLink link = new HeaderTailLink();
        link.insertTail(0);
        link.insertTail(1);
        link.insertTail(2);
        link.insertTail(3);
        link.insertTail(3);
        link.insertTail(3);
        link.insertTail(3);
        Logger.println("删除前");
        link.display();
        link.delete(3);
        link.insertTail(4);
        link.insertTail(4);
        link.insertTail(4);
        link.insertTail(4);
        Logger.println("删除后");
        link.display();

    }
}
