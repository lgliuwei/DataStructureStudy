package cn.codingblock.leetcode;

import cn.codingblock.utils.log.Logger;

/**
 3. Longest Substring Without Repeating Characters

 Given a string, find the length of the longest substring without repeating characters.

 Examples:

     Given "abcabcbb", the answer is "abc", which the length is 3.

     Given "bbbbb", the answer is "b", with the length of 1.

     Given "pwwkew", the answer is "wke", with the length of 3.

     Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

 提交过程感受：
    第一次：Submission Result: Wrong
         Input:
         "dvdf"
         Output:
         2
         Expected:
         3
        一开始想的是，遍历字符串时，无重复的字符就放入子串数组里面，一旦当前字符串与子串数组里面的有重复就"清空"数组。
        这样显然忽略"dvdf"这种情况，
        新思路：用"滑动窗口"的思路来处理这个问题应该会更简单一些
    第二次：Wrong Answer
         Input:
         "c"
         Output:
         0
         Expected:
         1
    第三次：Wrong Answer
         Input:
         ""
         Output:
         1
         Expected:
         0
    第四次：Accepted

    一定要仔细，多考虑null，""，一个长度的字符串等极端情况！！！

 */
public class LeetCode3 {

    public static void main(String[] strs) {
        int length = lengthOfLongestSubstring("");
        Logger.println(length);
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int longestLength = 0;
        if (chars.length > 1) {
            int startIndex = 0;
            int endIndex = 0;
            for (int i = 1; i < chars.length; i++) {

                for (int j = startIndex; j <= endIndex; j++) {
                    if (chars[i] == chars[j]) {
                        startIndex = j + 1;
                    }
                }
                endIndex++;
                if (startIndex > endIndex) {
                    endIndex = startIndex;
                }

                if (endIndex - startIndex + 1 > longestLength) {
                    longestLength = endIndex - startIndex + 1;
                }
            }
        } else {
            longestLength = chars.length;
        }

        return longestLength;
    }

    /**
     * 第一次的提交代码：Wrong Answer
     * 一开始想的是，遍历字符串时，无重复的字符就放入子串数组里面，一旦当前字符串与子串数组里面的有重复就"清空"数组。
     * 这样显然忽略"dvdf"这种情况，
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring1(String s) {
        char[] chars = s.toCharArray();

        char[] subString = new char[s.length()]; // 子串
        int subStrLength = 0; // 子串的长度
        int longestLength = 0;//最大子串长度
        boolean isRepeat;
        for (int i = 0; i < chars.length; i++) {

            isRepeat = false;

            for (int j = 0; j < subStrLength; j++) {
                if (chars[i] == subString[j]) {
                    isRepeat = true;
                    break;
                }
            }

            if (isRepeat) {
                subStrLength = 0;
            }

            subString[subStrLength++] = chars[i];

            if (subStrLength > longestLength) {
                longestLength = subStrLength;
            }
        }

        return longestLength;
    }

}
