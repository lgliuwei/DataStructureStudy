package cn.codingblock.utils.random;

/**
 * Created by liuwei on 17/8/16.
 */
public class Random {
    /**
     * 随机数创建数组
     * @param size
     * @return
     */
    public static int[] initArrayByRandom(int size) throws ArrayIndexOutOfBoundsException {
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = getRandomInt(size);
        }
        return nums;
    }

    /**
     * 随机数创建数组(无重复)
     * @param size
     * @return
     */
    public static int[] initArrayByRandomNoRepeat(int size) throws ArrayIndexOutOfBoundsException {
        int[] nums = new int[size];
        int n = 0;
        boolean noRepeat;
        while (n < size) {
            noRepeat = true;
            int temp = getRandomInt(size * 10);
            for (int i = 0; i < n; i++) {
                if (temp == nums[i]) {
                    noRepeat = false;
                    break;
                }
            }
            if (noRepeat) {
                nums[n] = temp;
                n++;
            }
        }
        return nums;
    }

    /**
     * 获取一个随机整数
     * @return
     */
    public static int getRandomInt(int bounder){
        return new java.util.Random().nextInt(bounder);
    }

}
