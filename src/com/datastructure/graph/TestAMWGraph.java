package com.datastructure.graph;

public class TestAMWGraph {
    public static void main(String args[]) {
        int n=8,e=8;//分别代表结点个数和边的数目
        String labels[]={"V0","V1","V2","V3","V4","V5","V6","V7"};//结点的标识
        Graph graph=new GraphMatrix(n,labels);
        //插入边
        graph.insertVertex(0, 1, 2);
        graph.insertVertex(0, 2, 5);
        graph.insertVertex(1, 3, 8);
        graph.insertVertex(1, 4, 7);
        graph.insertVertex(2, 5, 2);
        graph.insertVertex(2, 6, 5);
        graph.insertVertex(3, 7, 8);
        graph.insertVertex(4, 7, 8);
        graph.insertVertex(7, 1, 8);

        System.out.println("结点个数是："+graph.getNumOfVertex());
        System.out.println("边的个数是："+graph.getNumOfEdges());

        graph.display();

        graph.dfs(0, new int[8]);
        System.out.println();
        graph.bfs( 0);
        System.out.println();
        graph.deleteEdge(0, 1);//删除<V1,V2>边
        System.out.println("删除<V1,V2>边后...");
        System.out.println("结点个数是："+graph.getNumOfVertex());
        System.out.println("边的个数是："+graph.getNumOfEdges());
    }
}
