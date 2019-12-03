package com.zone.structure.list;

/**
 * 自定义链表
 *
 * @ClassName: LinkedList
 * @Date 2019-11-21 17:22
 * @Author duanxin
 **/
public class LinkedList<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node node) {
            this.e = e;
            this.next = node;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    //获取链表中元素的个数
    public int getSize() {
        return size;
    }

    //返回链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //向链表头添加新的元素e
    public void addFirst(E e) {
//        Node node = new Node(e);
//        node.next = head;
//        head = node;
//        head = new Node(e, head);
//        size++;
        add(0, e);
    }


    //在链表的index位置添加元素
    //不是一个常用的操作，练习用
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed.Illegal index.");

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        prev.next = new Node(e, prev.next);

        size++;

    }

    //在链表末尾添加元素
    public void addLast(E e) {
        add(size, e);
    }

    //获得链表的第index个位置的元素
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed.Illegal index.");

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    //修改链表的第index个位置的元素
    public void set(int index , E e){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed.Illegal index.");
        Node cur = dummyHead.next;
        for (int i = 0 ; i < index ; i++)
            cur = cur.next;
        cur.e =e ;
    }

    //查找链表中是否有元素e
    public boolean contains(E e){
        Node cur = dummyHead.next;
        while (cur != null){
            if (cur.e.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }
    //删除链表的第index位置的元素
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Delete fail.Illegal index.");

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;
        return retNode.e;

    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size-1);
    }

    //从链表中删除元素e
    public void removeElement(E e){

        Node prev = dummyHead;
        while (prev.next != null){
            if (prev.next.e.equals(e))
                break;
            prev = prev.next;
        }

        if (prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            stringBuilder.append(cur.e).append("->");
            cur = cur.next;
        }
        stringBuilder.append("NULL");
        return stringBuilder.toString();
    }

}
