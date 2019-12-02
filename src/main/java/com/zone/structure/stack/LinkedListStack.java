package com.zone.structure.stack;

import com.zone.structure.list.LinkedList;

/**
 * @ClassName: LinkedListStack
 * @Date 2019-12-02 11:21
 * @Author duanxin
 **/
public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> linkedList;

    public LinkedListStack(){
        linkedList = new LinkedList<>();
    }
    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Stack:top ");
        stringBuilder.append(linkedList);
        return stringBuilder.toString();
    }
}
