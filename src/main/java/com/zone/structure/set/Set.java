package com.zone.structure.set;

/**
 * @ClassName: Set
 * @Date 2019-12-03 08:39
 * @Author duanxin
 **/
public interface Set<E> {

    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int getSize();

    boolean isEmpty();
}
