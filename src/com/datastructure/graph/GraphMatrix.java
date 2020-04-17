package com.datastructure.graph;

import com.datastructure.queque.LinkedListQueue;
import com.datastructure.queque.Queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 邻接矩阵
 */
public class GraphMatrix<E> implements Graph {
    private List<E> vertexList;//一维数组顶点表
    private int[][] matrix;//邻接矩阵，用来存储边
    private int numOfEdges;//边的数目

    public GraphMatrix(int n) {
        //初始化矩阵，一维数组，和边的数目
        matrix =new int[n][n];
        vertexList=new ArrayList(n);
        numOfEdges=0;
    }



    public GraphMatrix(int n,E datas[]) {
        //初始化矩阵，一维数组，和边的数目
        matrix =new int[n][n];
        vertexList=new ArrayList(Arrays.asList(datas));
        numOfEdges=0;
    }


    //得到结点的个数
    public int getNumOfVertex() {
        return vertexList.size();
    }

    //得到边的数目
    public int getNumOfEdges() {
        return numOfEdges;
    }

    //返回结点i的数据
    public E getValueByIndex(int i) {
        return vertexList.get(i);
    }

    //返回v1,v2的权值
    public int getWeight(int v1,int v2) {
        return matrix[v1][v2];
    }

    //插入结点
    public void insertVertex(E vertex) {
        vertexList.add(vertexList.size(),vertex);
    }

    //插入结点（带边和权重）
    public void insertEdge(int v1,int v2,int weight) {
        matrix [v1][v2]=weight;
        numOfEdges++;
    }

    //插入结点（带边不带权重）
    public void insertEdge(int v1,int v2) {
        matrix[v1][v2]=1;
        numOfEdges++;
    }

    @Override
    //插入结点（无向带边，带权重)
    public void insertVertex(int v1,int v2,int weight) {
        matrix [v1][v2]= weight;
        matrix [v2][v1]= weight;
        numOfEdges++;
    }

    @Override
    //插入结点（无向带边，不带权重)
    public void insertVertex(int v1,int v2) {
        matrix [v1][v2]=1;
        matrix [v2][v1]=1;
        numOfEdges++;
    }





    //删除边
    public void deleteEdge(int v1,int v2) {
        matrix [v1][v2]=0;
        numOfEdges--;
    }

    //删除边
    public void deleteUndiEdge(int v1,int v2) {
        matrix [v1][v2]=0;
        matrix [v2][v1]=0;
        numOfEdges--;
    }


    //得到第一个邻接结点的下标
    public int getFirstNeighbor(int index) {
        for(int j=0;j<vertexList.size();j++) {
            if (matrix [index][j]>0) {
                return j;
            }
        }
        return -1;
    }

    //根据前一个邻接结点的下标来取得下一个邻接结点
    public int getNextNeighbor(int v1,int v2) {
        for (int j=v2+1;j<vertexList.size();j++) {
            if (matrix [v1][j]>0) {
                return j;
            }
        }
        return -1;
    }



    //    展示
    public void display(){
        for (int i = 0;i <vertexList.size();i++){
            System.out.print("V"+i+": ");
            for (int j =0;j<vertexList.size();j++){
                if (matrix [i][j] !=0 ){
                    System.out.print("V"+i+"-"+"V"+j+" ");
                }
            }
            System.out.println();
        }

    }

    //以顶点k为起点，深度优先遍历图
    public void dfs( int k , int[] visted){
        int u ;
        System.out.print(" "+this.vertexList.get(k).toString());  //访问起点k
        visted[k] = 1;                                   //访问标志记为1，代表已访问
        u = this.getFirstNeighbor(k);                  //取顶点k的第一个邻接点
//        System.out.print(" "+graph.vertexList.get(k).toString()+graph.getWeight(k, u));  //访问起点k和权重
        while (u !=-1 ){
            if (visted[u]==0) {                          //如果未被访问
                dfs(u, visted);                   //以顶点u为起点，继续深度优先遍历(递归)
            }
            u = this.getNextNeighbor(k,u);             //回到顶点u，取顶点k的位于顶点u之后的下一个邻接点，如有，继续循环过程
        }

    }

    ///以顶点k为起点，广度优先遍历图
    public void bfs( int k){

        Queue<Integer> queue = new LinkedListQueue<Integer>();  //待遍历顶点下标队列
        int [] visted = new int[this.vertexList.size()];
        queue.enqueue(k);
        visted[k] = 1;
        while (!queue.isEmpty()){
            for (int i =0;i<vertexList.size();i++){
                if (matrix[k][i] !=0 && visted[i]!=1){      //连通且未遍历过
                    queue.enqueue(i);                           //将与k连通的节点入队
                    visted[i]=1;
                }
            }
            int index = queue.dequeue();
            System.out.print(" "+this.vertexList.get(index).toString());
            if (!queue.isEmpty()){
                k =queue.getFront();
            }

        }


    }




}