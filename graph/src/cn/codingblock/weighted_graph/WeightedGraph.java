package cn.codingblock.weighted_graph;

import cn.codingblock.graph.Vertex;
import cn.codingblock.utils.log.Logger;

/**
 * 带权无向图
 * Created by liuwei on 17/9/7.
 */
public class WeightedGraph {
    private int mVertexs;
    private int mMaxSize;
    private Vertex[] mVertexList;
    private int[][] mMatrix;

    private PriorityQueue mQueue;

    public WeightedGraph(int maxSize) {
        this.mMaxSize = maxSize;
        this.mVertexList = new Vertex[mMaxSize];
        this.mMatrix = new int[mMaxSize][mMaxSize];
        this.mVertexs = 0;
        mQueue = new PriorityQueue(mMaxSize * mMaxSize);
    }

    public void addVertex(char c) {
        if (!isFull()) {
            mVertexList[mVertexs++] = new Vertex(c);
        }
    }

    public void addEdage(int start, int end, int weight) {
        if (start >= 0 && start < mVertexs && end >= 0 && end < mVertexs) {
            mMatrix[start][end] = weight;
            mMatrix[end][start] = weight;
        }
    }

    /**
     * 最小生成树
     * 带权图的最小生成树算法要点:
     *  从一个顶点开始把它放入树的集合中,然后重复做如下:
     *  1、找到从最新顶点到其他顶点的所有的边,这些顶点不能在树的集合中,把这些边放入优先级队列中。
     *  2、找到权值最小的边,把它和它所到达的顶点放入树的集合中。
     * 具体算法实现:
     *  1、当前顶点放在树中
     *  2、连接这个顶点的边放到优先级队列中(如果合适)
     *      在2中不能放入优先级队列的边包含如下:
     *          ① 原点和终点相同
     *          ② 终点在树中
     *          ③ 源点和终点之间没有边
     *  3、从优先级队列中删除权值最小的边。这条边的目的顶点变成当前顶点。
     *
     */
    public void mstw() {
        int currentVertex = 0;// 当前顶点
        int mTrees = 0;
        while (mTrees < mVertexs) {
            Logger.print(mVertexList[currentVertex].label + "-");
            mVertexList[currentVertex].isInTree = true;
            mTrees++;
            for (int i = 0; i < mVertexs; i++) {
                if (i == currentVertex) {
                    break;
                }
                if (mVertexList[i].isInTree) {
                    break;
                }
                if (mMatrix[currentVertex][i] == 0) {
                    break;
                }
                // 以上都不符合加入优先级
                currentVertex = insertPQ(currentVertex, i, mMatrix[currentVertex][i]);
            }
        }

        for (int j = 0; j < mVertexs; j++) {
            mVertexList[j].isInTree = false;
        }
    }

    public int insertPQ(int start, int end, int weight) {
        mQueue.insert(new Edage(start, end, weight));
        Edage edage = mQueue.removeMin();
        Logger.println(mVertexList[edage.end].label + ":" + edage.weight);
        return edage.end;
    }

    public boolean isEmpty() {
        return mVertexs == 0;
    }

    public boolean isFull() {
        return mVertexs == mMaxSize;
    }

    /**
     * 显示矩阵
     */
    public void displayMatrix() {
        for (int i = 0; i < mVertexs; i++) {
            Logger.print("\t" + mVertexList[i].label);
        }
        Logger.println("");
        for (int out = 0; out < mVertexs; out++) {
            Logger.print(mVertexList[out].label);
            for (int in = 0; in < mVertexs; in++) {
                Logger.print("\t" + mMatrix[out][in]);
            }
            Logger.println("");
        }
    }

    public void diaplayVertex(int v) {
        Logger.print(mVertexList[v].label + " ");
    }
}
