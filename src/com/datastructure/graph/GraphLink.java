package com.datastructure.graph;

import com.datastructure.queque.LinkedListQueue;
import com.datastructure.queque.Queue;



/**
 * 邻接表
 */
public class GraphLink<E> implements Graph {

    /**
     * 邻接表元素集合
     */
    private ElementNode[] elementNodes;
    private int size;

    public GraphLink(E[] datas) {
        initGraph(datas);
    }

    /**
     * 初始化图结构 添加定点的操作
     */


    public void initGraph(E[] datas){
        size = datas.length;
        elementNodes=new ElementNode[size];
        for(int i=0;i<size;i++){
            elementNodes[i]=new ElementNode(datas[i]);  //顶点存数据，后继节点存下标
        }
    }




    /**
     * 添加边，顶点k连接顶点j
     *
     */
    public void insertVertex(int k,int j,int weight){
        ElementNode nextNode = elementNodes[k].getNext();
        ElementNode node = new ElementNode(weight, j, nextNode);
        elementNodes[k].setNext(node);
    }

    public void insertVertex(int k,int j){
        ElementNode nextNode = elementNodes[k].getNext();
        ElementNode node = new ElementNode(j, nextNode);
        elementNodes[k].setNext(node);
    }


    //得到第一个邻接结点的下标
    public int getFirstNeighbor(int index) {
        if ( this.elementNodes[index].getNext()!=null){
            return (int) elementNodes[index].getNext().getData();
        }
        return  -1;
    }


    public int getNumOfVertex(){
        return this.size;
    }

    public int getNumOfEdges(){
        int numOfEdges = 0 ;
        ElementNode node;
        for (int i=0;i<size;i++){
            node = this.elementNodes[i].getNext();
            while (node!= null){
                numOfEdges++;
                node =node.getNext();
            }
        }
        return numOfEdges;
    }


    @Override
    public void deleteEdge(int v1, int v2){
        ElementNode preNode = this.elementNodes[v1];
        while (preNode.getNext()!= null){
            if (v2 == (int)preNode.getNext().getData()){
                ElementNode nexNode = preNode.getNext();
                preNode.setNext(nexNode.getNext());
                nexNode.setNext(null);
                return;
            }
            preNode =preNode.getNext();
        }
    }




    //输出邻接表
    @Override
    public void display() {
        for (int i=0;i<this.size;i++){

            System.out.print("V"+i+": ");
            ElementNode node = this.elementNodes[i].getNext();
            while (node!=null){
                System.out.print("V"+i+"-"+"V"+node.getData().toString()+" ");
                node = node.getNext();
            }
            System.out.println();
        }
    }

    public void dfs(int k , int[] visted){
        System.out.print(" "+this.elementNodes[k].getData().toString());
//        System.out.print(" "+elementNodes[k].getData().toString()+","+elementNodes[k].getWeight());
        ElementNode nextNode = this.elementNodes[k].getNext();                  //取顶点k的第一个邻接点
        visted[k] = 1;
        while (nextNode !=null){
            int index = (int) nextNode.getData();
            if (visted[index] ==0){
                dfs(index, visted);
            }
            nextNode = nextNode .getNext();
        }
    }


    //以顶点k为起点，广度优先遍历图
    public void bfs(int k){
        Queue<Integer> queue = new LinkedListQueue<Integer>();      //待遍历顶点下标队列
        int [] visted = new int[this.size];
        queue.enqueue(k);
        visted[k] = 1;
         int tempIndex = k,nextIndex;
        ElementNode tempnode;

        while (!queue.isEmpty()){
            tempnode = this.elementNodes[tempIndex].getNext();
            while (tempnode!= null){ //连通
                nextIndex = (int) tempnode.getData();
                if (visted[nextIndex]!= 1){     //未遍历
                    queue.enqueue(nextIndex);
                    visted[nextIndex]=1;
                }
                tempnode = tempnode.getNext();
            }
            tempIndex = queue.dequeue();
            System.out.print(" "+this.elementNodes[tempIndex].getData().toString());
            }
        System.out.println();
    }


    public static void main(String[] args) {

        String labels[]={"V0","V1","V2","V3","V4","V5","V6","V7"};//结点的标识
        Graph graph = new GraphLink(labels);

        //插入边
        graph.insertVertex(0,1);
        graph.insertVertex(0,2);
        graph.insertVertex(1,3);
        graph.insertVertex(1,4);
        graph.insertVertex(2,5);
        graph.insertVertex(2,6);
        graph.insertVertex(3,7);
        graph.insertVertex(4,7);
        graph.insertVertex(7,1);
//        graph.insertVertex(5,4);
        graph.display();

        System.out.println();

        graph.bfs(0);

        System.out.println();

        graph.dfs(0, new int[labels.length]);

        System.out.println();

        System.out.println("结点个数是："+graph.getNumOfVertex());
        System.out.println("边的个数是："+graph.getNumOfEdges());

        graph.deleteEdge(3, 7);//删除<V1,V2>边
        System.out.println("删除<V3,V7>边后...");
        System.out.println("结点个数是："+graph.getNumOfVertex());
        System.out.println("边的个数是："+graph.getNumOfEdges());

    }

}
