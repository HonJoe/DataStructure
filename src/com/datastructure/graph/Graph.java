package com.datastructure.graph;

public interface  Graph<E> {



    //遍历
    void display();

    void dfs(int k ,int visted[]);

    void bfs(int k);

    //添加边
    void insertVertex(int i,int j);

    void insertVertex(int i,int j,int weight);

    //删除<V1,V2>边
    void deleteEdge(int v1, int v2);

    //顶点个数
    int getNumOfVertex();

    //边个数
    int getNumOfEdges();

}
