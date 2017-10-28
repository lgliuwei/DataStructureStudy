package cn.codingblock.string;


import cn.codingblock.utils.log.Logger;

/**
 * 字符串替换和复制
 * 删除一个字符串所有的a，并且复制所有的b（字符数组足够大）
 */
public class Q2 {
    public static void main(String[] strs) {
        char[] input = new char[]{'a', 'b', 'c', 'd', 'a', 'f', 'a', 'b', 'c', 'd', 'b', 'b', 'a', 'b'};
        char[] chars = new char[50];
        for (int j = 0; j < input.length; j++) {
            chars[j] = input[j];
        }
        Logger.println("操作前：");
        for (char c:chars
                ) {
            Logger.print(c + ", ");
        }
        int n = 0;
        int countB = 0;
        // 1、删除a，用n当做新下标，循环遍历数组，凡是不是a的元素都放到新下标的位置，由于新n增长慢，老下标i增长快，所以元素不会被覆盖。
        // 并且在删除a时顺便记录b的数量，以便下一步复制b时可以提前确定数组最终的最大的下标。
        for (int i = 0; chars[i] != '\u0000' && i < chars.length; i++) {
            if (chars[i] != 'a') {
                chars[n++] = chars[i];
            }
            if (chars[i] == 'b') {
                countB++;
            }
        }

        // 2、复制b，由于在第一步中就已经知道了字符串中b的个数，这里就能确定最终字符串的最大下标，从最打下表开始倒着复制原字符串，碰到b时复制即可。
        int newMaxIndex = n + countB - 1;
        for (int k = n - 1; k >= 0; k--) {
            chars[newMaxIndex--] = chars[k];
            if (chars[k] == 'b') {
                chars[newMaxIndex--] = chars[k];
            }
        }

        Logger.println("\n操作后：");
        for (char c:chars
                ) {
            Logger.print(c + ", ");
        }
    }
}
