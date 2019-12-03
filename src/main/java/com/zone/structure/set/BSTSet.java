package com.zone.structure.set;

import com.zone.structure.bst.BST;

/**
 * @ClassName: BSTSet
 * @Date 2019-12-03 08:42
 * @Author duanxin
 **/
public class BSTSet<E extends Comparable<E>> implements Set<E> {

    private BST bst;

    public BSTSet(){
        bst = new BST();
    }
    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
