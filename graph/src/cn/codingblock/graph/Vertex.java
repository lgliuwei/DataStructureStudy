package cn.codingblock.graph;

/**
 * 图的顶点
 * Created by liuwei on 17/9/1.
 */
public class Vertex {
    public char label;
    public boolean wasVisited;// 是否已被访问过,深搜广搜时用到
    public boolean isInTree; // 是否已经存入树中,带权图的最小生成树中使用

    public Vertex(char label) {
        this.label = label;
        this.wasVisited = false;
        this.isInTree = false;
    }
}
