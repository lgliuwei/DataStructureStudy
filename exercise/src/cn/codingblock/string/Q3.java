package cn.codingblock.string;

import cn.codingblock.utils.log.Logger;

/**
 * 交换星号
 * 一个字符串只包含*和数字，请把它的*号都放在开头。
 */
public class Q3 {
    public static void main(String[] strs) {
        char[] chars = new char[]{'1', '*', '4', '3', '*', '5', '*'};

        // 方案一（操作后，数字的相对位置不变）
        // 倒着操作：从最大下标开始向前遍历，遇到非*号的元素则加入"新"下标中，遍历完毕后，j即代表*号的个数，然后将0-j赋值为*即可。
//        int j = chars.length - 1;
//
//        for (int i = j; i >= 0; i--) {
//            if (chars[i] != '*') {
//                chars[j--] = chars[i];
//            }
//        }
//
//        while (j >= 0) {
//            chars[j--] = '*';
//        }

        // 方案二（操作后，数组的相对位置会变）
        // 快排划分，根据循环不变式（每一步循环之后条件都成立）:如本题[0..i-1]是*,[i..j-1]是数字,[j...n-1]未探测，循环时，随着i和j增加，维护此条件依然不变
        for (int i = 0, j = 0; j < chars.length; ++j) {
            if (chars[j] == '*') {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
            }
        }

        for (char c:chars
                ) {
            Logger.print(c + ", ");
        }
    }
}
