package cn.codingblock.recurision;

/**
 * Created by liuwei on 17/8/12.
 */
public class Fibonacci {
    /*
        查找斐波纳契数列中第 N 个数。

        所谓的斐波纳契数列是指：

        前2个数是 0 和 1 。
        第 i 个数是第 i-1 个数和第i-2 个数的和。
        斐波纳契数列的前10个数字是：

        0, 1, 1, 2, 3, 5, 8, 13, 21, 34 ...
     * @param : an integer
     * @return: an ineger f(n)
     */
    public int fibonacci(int n) {
        if (n <= 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
