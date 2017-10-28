package cn.codingblock.leetcode;

import cn.codingblock.utils.log.Logger;

import java.util.Arrays;

/**
 Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 You may assume that each input would have exactly one solution, and you may not use the same element twice.

 Example:
 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].

 提交过程感受：
    第一次提交：失败，由于审题出错，把题目的最后一句话看成你可以使用同一个元素两次了。
    第二次提交：失败，没有考虑负数
    第三次提交：通过

 做题时首先要仔细审题，只有审对题了才有可能做正确，然后做题时要考虑全面，正数、负数、0，边界等各种情况。
 */
public class LeetCode1 {

    public static void main(String[] strs) {
//        int[] res = twoSum(new int[]{-2, -7, -11, -15, 0, 3, 8}, -3);
        int[] res = twoSum(new int[]{-1,-2,-3,-4,-5}, -8);
//        int[] res = twoSum(new int[]{3,2,4}, 6);
        Logger.println(Arrays.toString(res));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
            for (int j = 0; j < nums.length; j++) {
                if (i != j && result == nums[j]) {
                    indices[0] = i;
                    indices[1] = j;
                    return indices;
                }
            }
        }
        return null;
    }

}
