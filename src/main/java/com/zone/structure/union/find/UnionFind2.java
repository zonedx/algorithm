package com.zone.structure.union.find;

/**
 * @ClassName: UnionFind2
 * @Date 2019-12-04 19:57
 * @Author duanxin
 **/
public class UnionFind2 implements UF {

    private int[] parent;

    public UnionFind2(int size){

        parent = new int[size];

        for (int i = 0 ; i < size ; i++)
            parent[i] = i;

    }

    //时间复杂度O(h)
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {

        int qRoot = find(q);
        int pRoot = find(p);
        if (qRoot == pRoot)
            return;

        parent[pRoot] = qRoot;
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    //查找过程，查找元素p所对应的集合编号
    //O(h)复杂度
    private int find(int p){
        if (p < 0 || p >= parent.length)
            throw new IllegalArgumentException("p is out of bound");

        while (p != parent[p])
            p = parent[p];
        return p;
    }
}
