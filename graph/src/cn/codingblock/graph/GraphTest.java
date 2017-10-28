package cn.codingblock.graph;

import cn.codingblock.utils.log.Logger;

/**
 * Created by liuwei on 17/9/1.
 */
public class GraphTest {

    public static void main(String[] strs) {
        Graph graph = new Graph(20);
        graph.addVertex('a');
        graph.addVertex('b');
        graph.addVertex('c');
        graph.addVertex('d');
        graph.addVertex('e');
        graph.addVertex('f');
        graph.addVertex('g');
        graph.addVertex('i');
        graph.addVertex('h');
        graph.addEdage(0, 1);
        graph.addEdage(0, 2);
        graph.addEdage(0, 3);
        graph.addEdage(0, 4);
        graph.addEdage(1, 5);
        graph.addEdage(5, 8);
        graph.addEdage(3, 6);
        graph.addEdage(6, 7);
        graph.displayMatrix();
        // 深度优先
        Logger.println("深度优先:");
        graph.dfs();
        Logger.println("\n广度优先:");
        graph.bfs();
        Logger.println("\n最小生成树路径:");
        graph.mst();
    }
}
