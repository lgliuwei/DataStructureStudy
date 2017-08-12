package cn.codingblock;

import cn.codingblock.singleton.Solution;
import cn.codingblock.utils.log.Logger;

/**
 * Created by liuwei on 17/8/7.
 */
public class exercise {

    public static void main(String[] strs){
//        Logger.println(strStr(null, null));
//        Solution A = Solution.getInstance();
//        Solution B = Solution.getInstance();
//
//        Logger.println(A);
//        Logger.println(B);
//        int[] array = new int[]{1,4,2,3,8,0,9,5,6,7};
//        int[] array = new int[]{0,1,2,3,4,5,7,8,9};
//        int[] array = new int[]{};
//        sortIntegers(array);
//        Logger.println(findPosition(array, 6));
        Logger.println(binarySearch(new int[] {1,1,4,4,5,7,7,8,9,9,10}, 1));

//        Logger.println(addDigits(1000000000));
//        Logger.println(isUnique("abcdefgjtyuiopp"));

    }

    /**
     * 实现一个算法确定字符串中的字符是否均唯一出现
     * @param str
     * @return
     */
    public static boolean isUnique(String str) {
        if (str != null && str != "") {
            for (int i = 0; i < str.length(); i++) {
                for (int j = 0; j < str.length(); j++) {
                    if (j != i && str.charAt(j) == str.charAt(i)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * 给出一个非负整数 num，反复的将所有位上的数字相加，直到得到一个一位的整数。
     * @param num
     * @return
     */
    public static int addDigits(int num) {
        while (true) {
            String numStr = String.valueOf(num);
            if (numStr.length() == 1) {
                return Integer.valueOf(numStr);
            } else {
                num = 0;
                for (int i = 0; i < numStr.length(); i++) {
                    num += Integer.valueOf(numStr.substring(i, i + 1));
                }
            }
        }
    }

    /**
     * 二分查找首次出现的位置
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch(int[] nums, int target) {
        if (nums != null && nums.length > 0) {
            int lowBounder = 0;
            int hightBounder = nums.length - 1;
            int index;
            while (true) {
                index = (lowBounder + hightBounder) / 2;
                if (lowBounder > hightBounder) {
                    return -1;
                } else if (target == nums[index]) {
                    while (index > 0 && nums[index - 1] == target) {
                        index--;
                    }
                    return index;
                } else if (target > nums[index]) {
                    lowBounder = index + 1;
                } else if (target < nums[index]) {
                    hightBounder = index - 1;
                }
            }
        } else {
            return -1;
        }
    }
    /**
     * 二分法查找
     * @param nums
     * @param target
     * @return
     */
    public static int findPosition(int[] nums, int target) {

        int lowBounder = 0;
        int highBounder = nums.length - 1;
        int index;
        while (true) {
            index = (lowBounder + highBounder) / 2;
            if (lowBounder > highBounder) {
                return -1;
            } else if (target == nums[index]) {
                return index;
            } else if (target > nums[index]) {
                lowBounder = index + 1;
            } else if (target < nums[index]) {
                highBounder = index - 1;
            }
        }
    }

    /**
     * 冒泡排序
     * @param A
     */
    public static void sortIntegers(int[] A) {
        if (A == null) {
            return;
        }
        for (int i = A.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (A[j] > A[j + 1]) {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }

        for (int a : A) {
            Logger.print(a + ",");
        }
    }

    /**
     * 字符串查找
     * @param source
     * @param target
     * @return
     */
    public static int strStr(String source, String target) {
        if (source != null && target != null) {
            return source.indexOf(target);
        } else {
            return -1;
        }
    }
}
