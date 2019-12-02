package com.zone.structure.stack;

/**
 * @ClassName: Stack
 * @Date 2019-11-29 09:21
 * @Author duanxin
 **/
public interface Stack<E> {

    void push(E e);

    E pop();

    E peek();

    int getSize();

    boolean isEmpty();
}
