package cn.codingblock.weighted_graph;

import cn.codingblock.utils.log.Logger;

/**
 * Created by liuwei on 17/9/7.
 */
public class Test {
    public static void main(String[] strs) {
        WeightedGraph graph = new WeightedGraph(10);
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');
        graph.addEdage(0, 1, 6);
        graph.addEdage(0, 2, 4);
        graph.addEdage(1, 3, 7);
        graph.addEdage(1, 2, 10);
        graph.addEdage(1, 4, 7);
        graph.addEdage(3, 2, 8);
        graph.addEdage(3, 4, 12);
        graph.addEdage(2, 4, 5);
        graph.addEdage(2, 5, 6);
        graph.addEdage(4, 5, 7);
        graph.displayMatrix();
        Logger.println("mstw:");
        graph.mstw();
    }
}
