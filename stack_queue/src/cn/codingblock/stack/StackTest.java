package cn.codingblock.stack;

import cn.codingblock.stack.reverser.StringReverser;
import cn.codingblock.utils.Logger;
import cn.codingblock.stack.separator_match.SeparatorMatch;

public class StackTest {

    public static void main(String[] args) {
        /* 1、简单栈用法示例 */
//        Stack stack = new Stack(10);
//        stack.push(0);
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        stack.push(4);
//        stack.push(5);
//        stack.push(6);
//        stack.push(7);
//        stack.push(8);
//        stack.push(9);
//
//        while(!stack.isEmpty()) {
//            Logger.println("pop:" + stack.pop());
//        }
//        Logger.print("peek:" + stack.peek());

        /* 2、字符串逆序 */
//        StringReverser stringReverser = new StringReverser("dlrow olleh");
//        Logger.println("reverser:" + stringReverser.reverser());

        /* 3、分割符校验示例 */
        SeparatorMatch match = new SeparatorMatch("[a+b+c3");
        Logger.println("验证:" + match.doMatch());
    }
}
