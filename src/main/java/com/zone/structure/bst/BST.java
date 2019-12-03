package com.zone.structure.bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @ClassName: BST
 * @Date 2019-12-02 17:38
 * @Author duanxin
 **/
public class BST<E extends Comparable<E>> {

    private class Node {
        E e;
        Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }

        public Node() {
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //向二分搜索树中添加新的元素e
    public void add(E e) {
        root = add(root, e);
    }

    //以node为根插入元素，递归算法
    private Node add(Node node, E e) {

        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0)
            node.left = add(node.left, e);
        else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    //看以node为根的二分搜索树中是否包含元素e，递归算法
    private boolean contains(Node node, E e) {

        if (node == null)
            return false;

        if (e.compareTo(node.e) == 0)
            return true;
        else if (e.compareTo(node.e) < 0)
            return contains(node.left, e);
        else
            return contains(node.right, e);

    }

    //前序遍历
    public void preOrder() {
        preOrder(root);
    }

    //前序遍历以node为根的二分搜索树，递归算法
    private void preOrder(Node node) {

        if (node == null)
            return;

//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(node.e).append("-");
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void preOrderNR(){

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){

            Node cur = stack.pop();
            System.out.println(cur.e);

            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }
    }
    //中序遍历
    public void inOrder(){
        inOrder(root);
    }

    //中序遍历以node为根的二分搜索树，递归算法
    private void inOrder(Node node){

        if (node == null)
            return;

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    //后序遍历
    public void postOrder(){
        postOrder(root);
    }

    //后序遍历以node为根的二分搜索树，递归算法
    private void postOrder(Node node){

        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    //二分搜索树的层序遍历
    public void levelOrder(){
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()){
            Node cur = queue.remove();
            System.out.println(cur.e);

            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
        }
    }

    //寻找二分搜索树的最小元素
    public E minimum(){
        if (size == 0)
            throw new IllegalArgumentException("BST is empty");
        return minimum(root).e;
    }

    private Node minimum(Node node){
        if (node.left == null)
            return node;
        return minimum(node.left);
    }

    //寻找二分搜索树的最大元素
    public E maximum(){
        if (size == 0)
            throw new IllegalArgumentException("BST is empty");
        return maximum(root).e;
    }

    private Node maximum(Node node){
        if (node.right == null)
            return node;
        return maximum(node.right);
    }

    //从二分搜索树中删除值最小的节点，返回最小值
    public E removeMin(){

        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    //删除以node为根的二分搜索树中的最小节点
    //返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node){

        if (node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    //从二分搜索树中删除值最大的节点，返回最大值
    public E removeMax(){
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    //删除以node为根的二分搜索树中的最大节点
    //返回删除节点后新的二分搜索树的根
    private Node removeMax(Node node){

        if (node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    //从二分搜索树中删除元素为e的节点
    public void remove(E e){

        root = remove(root,e);

    }

    private Node remove(Node node,E e){

        if (node == null)
            return null;

        if (e.compareTo(node.e) < 0){
            node.left = remove(node.left,e);
            return node;
        }else if (e.compareTo(node.e) > 0){
            node.right = remove(node.right,e);
            return node;
        }else {

            //待删除节点左子树为空的情况
            if (node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            //待删除节点右子树为空的情况
            if (node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            /**
             * 待删除的节点左右子树均不为空的情况
             * 找到比待删除节点大的最小的节点，即待删除节点右子树的最小节点
             * 用这个节点顶替待删除节点的位置
             */
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;
            return successor;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        generatorBSTString(root, 0, stringBuilder);
        return stringBuilder.toString();
    }

    private void generatorBSTString(Node node, int depth, StringBuilder builder) {
        if (node == null) {
            builder.append(generatorDepthString(depth) + "null\n");
            return;
        }

        builder.append(generatorDepthString(depth) + node.e + "\n");
        generatorBSTString(node.left, depth + 1, builder);
        generatorBSTString(node.right, depth + 1, builder);

    }

    private String generatorDepthString(int depth) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < depth; i++)
            stringBuilder.append("--");
        return stringBuilder.toString();
    }

}
