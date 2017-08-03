package cn.codingblock.queue.analyse_express;


/**
 * Created by liuwei on 17/7/29.
 */
public class AnalyseExpressTest {

    public static void main(String[] strs) {
        AnalyseExpress analyseExpress = new AnalyseExpress("a*b/d+c-f/(e-g)*(j+h)");
        analyseExpress.transferExpress();
    }
}
