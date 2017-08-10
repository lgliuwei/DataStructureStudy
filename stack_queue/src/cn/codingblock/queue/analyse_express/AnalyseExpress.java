package cn.codingblock.queue.analyse_express;

import cn.codingblock.stack.reverser.CharStack;
import cn.codingblock.utils.log.Logger;
import cn.codingblock.utils.text.TextUtils;

/**
 * Created by liuwei on 17/8/2.
 */
public class AnalyseExpress {

    private String midfixExpress;
    private String suffixExpress;
    private float result;
    private CharStack charStack;
    private CharQueue charQueue;

    public AnalyseExpress(String midfixExpress) {
        this.midfixExpress = midfixExpress;
    }

    /**
     * 将算术表达式转换成后缀形式
     * @return
     */
    public void transferExpress(){
        /**
         * 此算法有bug:
         * 输入:a-b/d+(c-f)/(e-g)*(j+h)/(k-n)
         * 输出:a b d / c f - e g - / j h + * k n - / + -(错误)
         * 这是因为读取到 - 入栈 读取到 + 入栈,此时栈内为 -+,读取到最后全部出栈 顺序编程了 +-
         */
        if (TextUtils.isEmpty(midfixExpress)) {
            return;
        }

        this.charStack = new CharStack(midfixExpress.length());
        this.charQueue = new CharQueue(midfixExpress.length());

        for (int i = 0; i < midfixExpress.length(); i++) {
            char c = midfixExpress.charAt(i);
            if (c == '+') {
                charStack.push(c);
            } else if (c == '-') {
                charStack.push(c);
            } else if (c == '*') {
                charStack.push(c);
            } else if (c == '/') {
                charStack.push(c);
            } else if (c == '(') {
                charStack.push(c);
            } else if (c == ')') {
                while (!charStack.isEmpty()) {
                    if (isPrePriority(charStack.peek(), i + 1)) {
                        charQueue.insert(charStack.pop());
                    } else {
                        break;
                    }
                }
            } else {
                charQueue.insert(c);
                /*if (!charStack.isEmpty() && charStack.peek() == '(') {
                    charStack.pop(); // 如果栈顶为'(',则舍弃
                } else */
                if (i == midfixExpress.length() - 1) {
                    while (!charStack.isEmpty()) {
                        charQueue.insert(charStack.pop());
                    }
                } else if (!charStack.isEmpty()) {
                    while (!charStack.isEmpty()) {
                        if (charStack.peek() == '(') {
                            charStack.pop();
                        } else if (isPrePriority(charStack.peek(), i + 1)) {
                            charQueue.insert(charStack.pop());
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        Logger.println("如下:");
        while (!charQueue.isEmpty()) {
            Logger.print(charQueue.remove() + " ");
        }
    }

    /**
     * 将算术表达式转换成后缀形式
     * @return
     */
    public void transferExpress1(){
        if (TextUtils.isEmpty(midfixExpress)) {
            return;
        }
        this.charStack = new CharStack(midfixExpress.length());
        this.charQueue = new CharQueue(midfixExpress.length());

    }

    public String calculate(){
        return null;
    }

    /**
     * 前一位是否优先入栈
     * @param index
     * @return
     */
    private boolean isPrePriority(char symbol, int index){
        if (index >= midfixExpress.length()) {
            // 此情况表明表达式结束
            return true;
        }

        switch (symbol) {
            case '*':
            case '/':
                return true;
        }

        switch (midfixExpress.charAt(index)) {
            case ')':return true;
            case '*':
            case '/':return false;
        }

        return true;
    }
}
