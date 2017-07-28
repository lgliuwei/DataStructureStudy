package cn.codingblock.stack.reverser;

/**
 * 字符串逆序
 * Created by liuwei on 17/7/26.
 */
public class StringReverser {
    private String input;
    private String output;

    public StringReverser(String input) {
        this.input = input;
    }

    public String reverser(){
        output = "";
        CharStack charStack = new CharStack(input.length());
        for (int i = 0; i < input.length(); i++) {
            charStack.push(input.charAt(i));
        }

        while (!charStack.isEmpty()) {
            output += charStack.pop();
        }

        return output;
    }
}
