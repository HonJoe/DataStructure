package com.datastructure.graph;

public class ElementNode<E> {

    private int weight;     //到下一定点边的权重
    private E data;         //数据
    private ElementNode next;

    public ElementNode(int weight, E data, ElementNode next) {
        this.weight = weight;
        this.data = data;
        this.next = next;
    }

    public ElementNode(E data, ElementNode next) {
        this.weight = 1;    //无权重时默认设为1
        this.data = data;
        this.next = next;
    }

    public ElementNode( E data) {
        this.weight = 1;    //无权重时默认设为1
        this.data = data;
        this.next = null;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public ElementNode getNext() {
        return next;
    }

    public ElementNode setNext(ElementNode next) {
        this.next = next;
        return this;
    }

}
