package cn.codingblock.graph;

import cn.codingblock.queue.Queue;
import cn.codingblock.stack.Stack;
import cn.codingblock.utils.log.Logger;

/**
 * 图
 * Created by liuwei on 17/9/1.
 */
public class Graph {
    private int mMaxSize;
    private Vertex[] mVertexList; // 存放顶点的数组
    private int[][] mMatrix; // 矩阵,存放边
    private int mVertexs; // 顶点个数

    private Stack mStack; // 栈,用于深度优先搜索
    private Queue mQueue; // 队列,用于广度优先搜索

    public Graph(int maxSize) {
        mMaxSize = maxSize;
        mVertexList = new Vertex[mMaxSize];
        mMatrix = new int[mMaxSize][mMaxSize];
        mVertexs = 0;
        mStack = new Stack(mMaxSize * mMaxSize);
        mQueue = new Queue(mMaxSize * mMaxSize);
    }

    /**
     * 添加顶点
     * @param lable
     */
    public void addVertex(char lable) {
        if (!isFull()) {
            mVertexList[mVertexs++] = new Vertex(lable);
        }
    }


    /**
     * 对两个顶点连线
     * @param start
     * @param end
     */
    public void addEdage(int start, int end) {
        if (start >= 0 && start < mVertexs && end >= 0 && end < mVertexs) {
            mMatrix[start][end] = 1;
            mMatrix[end][start] = 1;
        }
    }

    /**
     * 深度优先搜索
     * 规则1:如果可能,访问一个邻接的未访问顶点,标记它,并把它放入栈中。
     * 规则2:当不能执行规则1时,如果栈不空,就从栈中弹出一个顶点。
     * 规则3:如果不能执行规则1和规则2,就完成了整个搜索过程。
     * 算法: 深度优先遍历算法借助栈实现
     *  1、用peek方法检查栈顶的顶点。
     *  2、试图找出这个顶点还未访问的邻接点。
     *  3、如果没有找到,出栈。
     *  4、如果找到了顶点,访问这个顶点,并把它入栈。
     */
    public void dfs() {
        mVertexList[0].wasVisited = true;
        diaplayVertex(0);
        mStack.push(0);
        int v;
        while (!mStack.isEmpty()) {
            v = getUnvisitedVertex(mStack.peek());
            if (v != -1) {
                mVertexList[v].wasVisited = true;
                diaplayVertex(v);
                mStack.push(v);
            } else {
                mStack.pop();
            }
        }
        // 最后重置所有wasVisited标记,以便后续使用。
        for (int i = 0; i < mVertexs; i++) {
            mVertexList[i].wasVisited = false;
        }
    }

    /**
     * 广度优先搜索(通过队列实现)
     *  规则1:访问下一个未来访问的邻接点(若存在),这个顶点必须是当前顶点的邻接点,标记它,并入队。
     *  规则2:若因为已经没有未来访问顶点而不能执行规则1,那么从队头取一点(若存在)作为当前顶点。
     *  规则3:若队列为空而不能执行规则2,则搜索结束。
     */
    public void bfs() {
        mVertexList[0].wasVisited = true;
        diaplayVertex(0);
        mQueue.insert(0);
        int v;
        while (!mQueue.isEmpty()) {
            v = getUnvisitedVertex(mQueue.peek());
            if (v != -1) {
                mVertexList[v].wasVisited = true;
                diaplayVertex(v);
                mQueue.insert(v);
            } else {
                mQueue.remove();
            }
        }
        // 最后重置所有wasVisited标记,以便后续使用。
        for (int i = 0; i < mVertexs; i++) {
            mVertexList[i].wasVisited = false;
        }
    }

    /**
     * 最小生成树
     *  最小生成树包含了链接图中所有的顶点所需要的最少数量的边。
     *  在执行深度优先搜索过程中,记录走过的边,就可以创建一棵最小生成树。
     */
    public void mst() {
        mVertexList[0].wasVisited = true;
        mStack.push(0);
        int currentV;
        int v;
        while (!mStack.isEmpty()) {
            currentV = mStack.peek();
            v = getUnvisitedVertex(currentV);
            if (v != -1) {
                Logger.print(mVertexList[currentV].label + "-" + mVertexList[v].label + ",");
                mVertexList[v].wasVisited = true;
                mStack.push(v);
            } else {
                mStack.pop();
            }
        }

        // 最后重置所有wasVisited标记,以便后续使用。
        for (int i = 0; i < mVertexs; i++) {
            mVertexList[i].wasVisited = false;
        }
    }

    /**
     * 获取v顶点的未访问过的邻接点
     * @param v
     * @return
     */
    private int getUnvisitedVertex(int v) {
        for (int i = 0; i < mVertexs; i++) {
            if (mMatrix[v][i] == 1 && mVertexList[i].wasVisited == false) {
                return i;
            }
        }
        return -1;
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
            Logger.print("  " + mVertexList[i].label);
        }
        Logger.println("");
        for (int out = 0; out < mVertexs; out++) {
            Logger.print(mVertexList[out].label);
            for (int in = 0; in < mVertexs; in++) {
                Logger.print(" " + mMatrix[out][in] + " ");
            }
            Logger.println("");
        }
    }

    public void diaplayVertex(int v) {
        Logger.print(mVertexList[v].label + " ");
    }
}
