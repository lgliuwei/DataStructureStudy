package cn.codingblock.graph;

import cn.codingblock.queue.Queue;
import cn.codingblock.stack.Stack;
import cn.codingblock.utils.log.Logger;

/**
 * 有向图
 *  顶点之间的边有方向
 * Created by liuwei on 17/9/5.
 */
public class Digraph {
    private int mMaxSize;
    private Vertex[] mVertexList; // 存放顶点的数组
    private int[][] mMatrix; // 矩阵,存放边
    private int mVertexs; // 顶点个数

    private Stack mStack; // 栈,用于深度优先搜索
    private Queue mQueue; // 队列,用于广度优先搜索

    private Vertex[] mSortedArray; // 拓扑排序的数组

    public Digraph(int maxSize) {
        mMaxSize = maxSize;
        mVertexList = new Vertex[mMaxSize];
        mMatrix = new int[mMaxSize][mMaxSize];
        mVertexs = 0;
        mStack = new Stack(mMaxSize * mMaxSize);
        mQueue = new Queue(mMaxSize * mMaxSize);

        mSortedArray = new Vertex[mMaxSize];
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
     * 对两个顶点连线(有向)
     * @param start
     * @param end
     */
    public void addEdage(int start, int end) {
        if (start >= 0 && start < mVertexs && end >= 0 && end < mVertexs) {
            mMatrix[start][end] = 1;
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
     * 广度优先搜索
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

    /**
     * 拓扑排序
     *  拓扑排序只能在GAG中进行(GAG:有向五环图)
     *  排列列表:如果从A到B有一条边,那么在排序列表中A在B的前面。
     *  步骤1:找到一个没有后继的顶点。
     *  步骤2:从图中删除这个顶点,在列表的前面插入顶点的标记。
     *  重复步骤1和步骤2,直到所有的顶点都从图中删除,这是,列表中显示的顺序就是拓扑排序的结果。
     *
     */
    public void topo() {
        int noSuceedV;
        int orignVertexs = mVertexs;
        while (mVertexs > 0) {
            noSuceedV = getNoSucceedVertex();
            // 如果找不到无后继节点的顶点,则说明图内存在环形图
            if (noSuceedV == -1) {
                Logger.println("Error, Graph has cycle!");
                return;
            }
            mSortedArray[mVertexs - 1] = mVertexList[noSuceedV];
            deleteVertex(noSuceedV);
        }

        for (int i = 0; i < orignVertexs; i++) {
            Logger.print(mSortedArray[i].label + ", ");
        }
    }

    /**
     * 获取没有后继的顶点
     *  在矩阵(二维数组)中按行遍历顶点,如果
     * @return
     */
    public int getNoSucceedVertex() {
        boolean noSucceed;
        for (int i = 0; i < mVertexs; i++) {
            noSucceed = true;
            for (int j = 0; j < mVertexs; j++) {
                if (mMatrix[i][j] == 1) {
                    noSucceed = false;
                    break;
                }
            }
            if (noSucceed) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 在图中删除顶点
     * @param v
     */
    public void deleteVertex(int v) {
        Logger.println("删除顶点" + mVertexList[v].label + "后的矩阵:");
        for (int row = 0; row < mVertexs - 1; row++) {
            if (row >= v) {
                mVertexList[row] = mVertexList[row+1];
                mMatrix[row] = mMatrix[row + 1];
            }
            for (int col = v; col < mVertexs - 1; col++) {
                mMatrix[row][col] = mMatrix[row][col + 1];
            }
        }
        mVertexs--;
        displayMatrix();
    }
}
