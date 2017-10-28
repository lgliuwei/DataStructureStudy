package cn.codingblock.string;

import cn.codingblock.utils.log.Logger;

/**
 * 单词翻转
 * 例如：I am a student =》 student a am I
 * 思路：
 * 1、现将真个字符串翻转：
 *      如：I am a student =》 tneduts a ma I
 * 2、通过空格判断出每个单词，然后对每个单词进行翻转
 */
public class Q5 {
    public static void main(String[] strs) {
        String input = "I am a student";
        char[] chars = input.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            swap(chars, i++, j--);
        }

        int front = 1;
        int tail = 0;
        while (front < chars.length) {
            if (chars[front] == ' ') {
                int frontTemp = front - 1;
                while (tail < frontTemp) {
                    swap(chars, tail++, frontTemp--);
                }
                tail = front + 1;
            }
            front++;
        }

        for (char c:chars
                ) {
            Logger.print(c);
        }

    }

    public static void swap(char[] chars, int index1, int index2) {
        char temp = chars[index1];
        chars[index1] = chars[index2];
        chars[index2] = temp;
    }
}
