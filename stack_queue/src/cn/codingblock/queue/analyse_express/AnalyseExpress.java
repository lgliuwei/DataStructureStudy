package cn.codingblock.queue.analyse_express;

import cn.codingblock.stack.reverser.CharStack;
import cn.codingblock.utils.log.Logger;
import cn.codingblock.utils.text.TextUtils;

/**
 * Created by liuwei on 17/8/2.
 */
public class AnalyseExpress {

    private String prefixExpress;
    private String suffixExpress;
    private float result;
    private CharStack charStack;
    private CharQueue charQueue;

    public AnalyseExpress(String prefixExpress) {
        this.prefixExpress = prefixExpress;
        if (prefixExpress.length() > 0) {
            this.charStack = new CharStack(prefixExpress.length());
            this.charQueue = new CharQueue(prefixExpress.length());
        }
    }

    /**
     * 将算术表达式转换成中缀形式
     * @return
     */
    public void transferExpress(){

        if (TextUtils.isEmpty(prefixExpress)) {
            return;
        }

        for (int i = 0; i < prefixExpress.length(); i++) {
            char c = prefixExpress.charAt(i);
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
                if (!charStack.isEmpty() && charStack.peek() == '(') {
                    charStack.pop();
                } else if (i == prefixExpress.length() - 1) {
                    while (!charStack.isEmpty()) {
                        charQueue.insert(charStack.pop());
                    }
                } else if (!charStack.isEmpty()) {
                    if (isPrePriority(charStack.peek(), i + 1)) {
                        charQueue.insert(charStack.pop());
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
     * 前一位是否优先入栈
     * @param index
     * @return
     */
    private boolean isPrePriority(char symbol, int index){
        if (index >= prefixExpress.length()) {
            // 此情况表明表达式结束
            return true;
        }

        switch (symbol) {
            case '*':
            case '/':
                return true;
        }

        switch (prefixExpress.charAt(index)) {
            case ')':return true;
            case '*':
            case '/':return false;
        }

        return true;
    }
}
