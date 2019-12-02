package com.zone.structure.queue;

/**
 * @ClassName: LinkedListQueue
 * @Date 2019-12-02 11:52
 * @Author duanxin
 **/
public class LinkedListQueue<E> implements Queue<E> {
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

    private Node head,tail;
    private int size;
    public LinkedListQueue(){
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void enqueue(E e) {
        if (tail == null){
            tail = new Node(e);
            head = tail;
        }
        else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        Node retNode = head;
        head = head.next;
        retNode.next = null;
        if (head == null)
            tail = null;
        size--;
        return retNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        return head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Queue: front ");
        Node cur = head;
        while (cur != null) {
            stringBuilder.append(cur.e).append("->");
            cur = cur.next;
        }
        stringBuilder.append("NULL tail");
        return stringBuilder.toString();
    }
}
