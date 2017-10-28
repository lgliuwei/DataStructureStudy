package cn.codingblock.leetcode;

/**
 * Add Two Numbers

 You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Input: (2 -> 4 -> 3)
      + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8

 提交过程：
    第一次： Accepted
 */

import cn.codingblock.link.ListNode;
import cn.codingblock.utils.log.Logger;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class LeetCode2 {
    public static void main(String[] strs) {
        ListNode l1 = new ListNode(8);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(9);

        ListNode l2 = new ListNode(0);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        Logger.println(l1);
        Logger.println(l2);

        ListNode resultNode = addTwoNumbers(l1, l2);

        Logger.println(resultNode);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode currentNode1 = l1;
        ListNode currentNode2 = l2;
        ListNode resultHeaderNode = null;
        ListNode resultTailNode = null;
        int result = 0;
        int tenDigit = 0;
        while (currentNode1 != null || currentNode2 != null) {
            result = 0;
            result += tenDigit;

            if (currentNode1 != null) {
                result += currentNode1.val;
                currentNode1 = currentNode1.next;
            }
            if (currentNode2 != null) {
                result += currentNode2.val;
                currentNode2 = currentNode2.next;
            }

            if (result > 9) {
                tenDigit = 1;
            } else {
                tenDigit = 0;
            }

            result %= 10;

            ListNode newNode = new ListNode(result);

            if (resultHeaderNode == null) {
                resultHeaderNode = newNode;
            } else {
                resultTailNode.next = newNode;
            }
            resultTailNode = newNode;
        }

        if (tenDigit > 0) {
            ListNode newNode = new ListNode(tenDigit);
            resultTailNode.next = newNode;
            resultTailNode = newNode;
        }

        return resultHeaderNode;
    }
}
