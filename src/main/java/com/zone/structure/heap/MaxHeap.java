package com.zone.structure.heap;

import com.zone.structure.array.Array;

/**
 * @ClassName: MaxHeap
 * @Date 2019-12-03 16:36
 * @Author duanxin
 **/
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    //将任意数组整理成堆  heapify
    public MaxHeap(E[] arr) {
        data = new Array<>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i--)
            shiftDown(i);
    }

    //返回堆中元素的个数
    public int size() {
        return data.getSize();
    }

    //返回堆中是否为空
    public boolean isEmpty() {
        return data.isEmpty();
    }

    //返回完全二叉树中的数组表示中，一个索引所表示的元素的父亲节点的索引
    private int parent(int index) {
        if (index == 0)
            throw new IllegalArgumentException("index-0 doesn't have parent!");
        return (index - 1) / 2;
    }

    //返回完全二叉树中的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    //返回完全二叉树中的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    //向堆中添加元素
    public void add(E e) {
        data.addLast(e);
        shiftUp(data.getSize() - 1);
    }

    private void shiftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    //看堆中最大的元素
    public E findMax() {
        if (data.getSize() == 0)
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        return data.get(0);
    }

    //向堆中取出最大元素
    public E extractMax() {

        E ret = findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();

        shiftDown(0);
        return ret;
    }

    private void shiftDown(int k) {

        while (leftChild(k) < data.getSize()) {

            int j = leftChild(k);
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0)
                //data.get(j + 1).compareTo(data.get(j)) > 0   说明右孩子的值大于左孩子
                //与值大的交换
                j = j + 1;

            if (data.get(k).compareTo(data.get(j)) >= 0)
                break;
            data.swap(k, j);
            k = j;
        }
    }

    //取出堆中最大的元素，并且替换成e
    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        shiftDown(0);
        return ret;
    }
}
