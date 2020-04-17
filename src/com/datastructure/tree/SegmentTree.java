package com.datastructure.tree;

import com.sun.org.apache.bcel.internal.generic.LMUL;

public class SegmentTree<E> {

    private E[] tree;
    private E[] data;
    private Merger<E> merger;

    public SegmentTree(E[] arr,Merger<E> merger) {
        this.merger = merger;
        data = (E [])new Object[arr.length];
        for (int i=0;i<arr.length;i++){
            data[i] = arr[i];
        }
        tree = (E[])new Object[4 * arr.length];
        buildSegmentTree(0, 0, arr.length-1);
    }
    // 在treeIndex的位置创建表示区间[l...r]的线段树
    private void buildSegmentTree(int treeIndex, int l, int r){
        if (l == r){
            tree[treeIndex] = data[l];
            return;
        }

        int leftIndex = leftChild(treeIndex);
        int rightIndex = rightChild(treeIndex);
        int mid = (l + r) / 2;
//        int mid = l + (r - l) / 2;
        buildSegmentTree(leftIndex, l, mid);
        buildSegmentTree(rightIndex, mid+1, r);

        tree[treeIndex] = merger.merge(tree[leftIndex], tree[rightIndex]);
    }

    // 返回区间[queryL, queryR]的值
    public E query(int queryL, int queryR){

        if(queryL < 0 || queryL >= data.length ||
                queryR < 0 || queryR >= data.length || queryL > queryR)
            throw new IllegalArgumentException("Index is illegal.");

        return query(0, 0, data.length - 1, queryL, queryR);
    }

    // 在以treeIndex为根的线段树中[l...r]的范围里，搜索区间[queryL...queryR]的值
    private E query(int treeIndex, int l, int r, int queryL, int queryR){
        if (l == queryL && r == queryR){
            return tree[treeIndex];
        }
        int leftIndex = leftChild(treeIndex);
        int rightIndex = rightChild(treeIndex);
        int mid = (l + r) / 2;
        if (mid >= queryR){
            return query(leftIndex,l,mid, queryL, queryR);
        }else if (mid+1 <= queryL){
            return query(rightIndex,mid+1,r,queryL,queryR);
        }
        E leftResult = query(leftIndex,l,mid,queryL,mid);
        E rightResult = query(rightIndex, mid+1, r, mid+1, queryR);
        return  merger.merge(leftResult, rightResult);
    }

    public int getSize(){
        return data.length;
    }

    public E get(int index){
        if(index < 0 || index >= data.length)
            throw new IllegalArgumentException("Index is illegal.");
        return data[index];
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index){
        return 2*index + 1;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index){
        return 2*index + 2;
    }

    // 将index位置的值，更新为e
    public void set(int index, E e){

        if(index < 0 || index >= data.length)
            throw new IllegalArgumentException("Index is illegal");

        data[index] = e;
        set(0, 0, data.length - 1, index, e);
    }


    // 在以treeIndex为根的线段树中更新index的值为e
    private void set(int treeIndex, int l, int r, int index, E e){
        if (l == r){
            tree[treeIndex] = e;
            return;
        }
        int mid = l + r / 2;
        // treeIndex的节点分为[l...mid]和[mid+1...r]两部分
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        if (index >= mid+1){
            set(rightTreeIndex, mid+1, r, index, e);
        }else {
            set(leftTreeIndex, l,mid,index, e);
        }
        tree[treeIndex] = merger.merge(tree[leftTreeIndex],tree[treeIndex]);
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        for (int i = 0;i<tree.length;i++){
            if (tree[i]!=null){
                stringBuilder.append(tree[i]);
            }else {
                stringBuilder.append("null");
            }
            if(i != tree.length - 1) {
                stringBuilder.append(", ");
            }

        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public static void main(String[] args) {

        Integer[] nums = {-2, 0, 3, -5, 2, -1};

        SegmentTree<Integer> segTree = new SegmentTree<>(nums,
                (a, b) -> a + b);
        System.out.println(segTree);

        System.out.println(segTree.query(0, 2));
        System.out.println(segTree.query(2, 5));
        System.out.println(segTree.query(0, 5));
    }

}
