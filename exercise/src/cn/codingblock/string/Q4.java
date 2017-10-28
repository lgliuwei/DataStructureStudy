package cn.codingblock.string;

/**
 * 子串变位词
 *  给定两个串a和b，问b是否a的子串变位词。
 *  例如：a=hello
 *      b=lel，lle，ello都是true
 *      b=elo是false
 *  思路：
 *      一、首先需要了解对两个串是否是变位词的判断：
 *          1、对两个串按统一规则排序，排序后若相等则是变位词。
 *          2、对两个串中出现的字母统计，两串中相同的字母出现的次数一致则为变位词。
 *      二、然后从母串的第一个元素遍历，每往后遍历一个元素就把从当前元素开始到加上子串的长度的位置作为一个区间和子串比较是否是变位词。
 */
public class Q4 {
    public static void main(String[] strs) {
        String a = "hello";
        String b = "lel";

        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();

        int lengthA = charsA.length;
        int lengthB = charsB.length;

        for (int i = 0; i < (lengthA - lengthB); i++) {

        }
    }
}
