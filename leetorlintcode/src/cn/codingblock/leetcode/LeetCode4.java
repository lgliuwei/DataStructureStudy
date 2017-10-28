package cn.codingblock.leetcode;

import cn.codingblock.utils.log.Logger;

/**
 4. Median of Two Sorted Arrays

 There are two sorted arrays nums1 and nums2 of size m and n respectively.

 Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

 Example 1:
     nums1 = [1, 3]
     nums2 = [2]

    The median is 2.0
 Example 2:
     nums1 = [1, 2]
     nums2 = [3, 4]

     The median is (2 + 3)/2 = 2.5

 思路：先合并两个数组，合并后的数组size如果是奇数，中位数即为数组最中间的值，如果是偶数，即为数组最中间两个数的平均值。

 提交过程感受：
    第一次：Accepted

 */
public class LeetCode4 {

    public static void main(String[] strs) {
        int[] nums1 = new int[]{-2, -1};
        int[] nums2 = new int[]{3, 4};

        Logger.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            throw new NullPointerException("nums1 or nums2 is null!");
        }
        int[] results = new int[nums1.length + nums2.length];
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;

        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] <= nums2[index2]) {
                results[index3++] = nums1[index1++];
            } else {
                results[index3++] = nums2[index2++];
            }
        }

        while (index1 < nums1.length) {
            results[index3++] = nums1[index1++];
        }

        while (index2 < nums2.length) {
            results[index3++] = nums2[index2++];
        }

        int resLength = results.length;
        if (resLength % 2 == 0) {
            return (results[resLength / 2] + results[resLength / 2 - 1]) / 2.0;
        } else {
            return results[resLength / 2];
        }
    }

}
