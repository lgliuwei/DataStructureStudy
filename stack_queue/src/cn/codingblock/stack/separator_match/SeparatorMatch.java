package cn.codingblock.stack.separator_match;

import cn.codingblock.utils.Logger;
import cn.codingblock.stack.reverser.CharStack;

/**
 *  分隔符匹配
 *  Created by liuwei on 17/7/26.
 */
public class SeparatorMatch {

    private char[] leftSep = new char[] {'{','[','('};
    private char[] rightSep = new char[] {'}',']',')'};

    private String input;

    public SeparatorMatch(String input) {
        this.input = input;
    }

    public boolean doMatch(){
        if (input != null) {
            CharStack charStack = new CharStack(input.length());
            char c;
            for (int i = 0; i < input.length(); i++) {
                c = input.charAt(i);
                if (matchLeftSep(c) != -1) {
                    charStack.push(c);
                } else {
                    int index = matchRightSep(c);
                    if (index != -1) {
                        if (!charStack.isEmpty()) {
                            char temp = charStack.pop();
                            if (leftSep[index] != temp) {
                                Logger.print("第" + i + "个字符错误:'" + c + "'");
                                return false;
                            }
                        } else {
                            Logger.print("第" + i + "个字符错误:'" + c + "'");
                            return false;
                        }
                    }
                }
            }
            if (charStack.isEmpty()) {
                return true;
            } else {
                Logger.print("错误:缺少分隔符:" + rightSep[matchLeftSep(charStack.peek())]);
                return false;
            }

        }
        return false;
    }

    private int matchLeftSep(char c) {
        for (int i = 0; i < leftSep.length; i++) {
            if (leftSep[i] == c) {
                return i;
            }
        }
        return -1;
    }

    private int matchRightSep(char c) {
        for (int i = 0; i < rightSep.length; i++) {
            if (rightSep[i] == c) {
                return i;
            }
        }
        return -1;
    }

}
