package com.zone.structure.set;

import com.zone.structure.list.LinkedList;

/**
 * @ClassName: LinkedListSet
 * @Date 2019-12-03 08:58
 * @Author duanxin
 **/
public class LinkedListSet<E> implements Set<E> {

    private LinkedList<E> list;

    public LinkedListSet(){
        list = new LinkedList<>();
    }
    @Override
    public void add(E e) {

        if (!list.contains(e)){
            list.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {

        list.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
