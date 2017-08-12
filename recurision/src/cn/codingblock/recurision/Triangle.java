package cn.codingblock.recurision;

import cn.codingblock.utils.log.Logger;

/**
 * Created by liuwei on 17/8/11.
 */
public class Triangle {

    /**
     * 返回三角数字
     * @param n
     * @return
     */
    public int triangle(int n) {
        Logger.println("n:" + n);
        if (n == 1) {
            Logger.println("return:" + 1);
            return 1;
        } else {
            int temp = n + triangle(n - 1);
            Logger.println("return:" + temp);
            return temp;
        }
    }
}
