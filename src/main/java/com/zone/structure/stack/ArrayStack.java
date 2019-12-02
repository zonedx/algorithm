package com.zone.structure.stack;

import com.zone.structure.array.Array;

/**
 *
 * 栈的应用
 *   1、undo操作-编辑器
 *   2、系统栈调用-操作系统
 *   3、括号匹配-编辑器
 * @ClassName: ArrayStack
 * @Date 2019-11-29 09:25
 * @Author duanxin
 **/
public class ArrayStack<E> implements Stack<E> {

    Array<E> array;

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayStack() {
        array = new Array<>();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Stack: ");
        stringBuilder.append("[");
        for (int i = 0; i < array.getSize(); i++) {
            stringBuilder.append(array.get(i));
            if (i != array.getSize()-1)
                stringBuilder.append(", ");
        }
        stringBuilder.append("] top");
        return stringBuilder.toString();
    }
}
