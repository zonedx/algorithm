package com.zone.structure.union.find;

public interface UF {

    /**
     * 查看元素p和元素q是否所属一个集合
     * @param p
     * @param q
     * @return
     */
    boolean isConnected(int p , int q);

    /**
     * 合并元素p和元素q所属的集合
     * @param p
     * @param q
     */
    void unionElements(int p , int q);

    int getSize();
}
