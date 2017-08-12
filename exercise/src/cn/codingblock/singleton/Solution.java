package cn.codingblock.singleton;

/**
 * Created by liuwei on 17/8/7.
 */
public class Solution {
    private static Solution instance;
    private Solution() {

    }
    public static Solution getInstance() {
        if (instance == null) {
            synchronized (Solution.class) {
                if (instance == null) {
                    instance = new Solution();
                }
            }
        }
        return instance;
    }
}
