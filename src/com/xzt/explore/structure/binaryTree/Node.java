package com.xzt.explore.structure.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Node {
    public static void main(String[] args) {
        Node binaryTree = new Node(8);
        binaryTree.add(3);
        binaryTree.add(1);
        binaryTree.add(6);
        binaryTree.add(4);
        binaryTree.add(7);
        binaryTree.add(10);
        binaryTree.add(14);
        binaryTree.add(13);
        System.out.println("先序遍历----");
        System.out.println(binaryTree.DLRLoop().toString());
        System.out.println(binaryTree.DLR().toString());
        System.out.println("中序遍历----");
        System.out.println(binaryTree.LDRLoop().toString());
        System.out.println(binaryTree.LDR().toString());
        System.out.println("后序遍历----");
        System.out.println(binaryTree.LRDLoop().toString());
        System.out.println(binaryTree.LRD().toString());
    }
    private int data;
    private Node left;
    private Node right;

    public Node() {
        super();
    }

    public Node(int data){
        this.data = data;
    }

    public List<Integer> DLR(){
        List<Integer> list = new ArrayList<>();
        return DLR(list);
    }
    public List<Integer> LDR(){
        List<Integer> list = new ArrayList<>();
        return LDR(list);
    }
    public List<Integer> LRD(){
        List<Integer> list = new ArrayList<>();
        return LRD(list);
    }

    /**
     * 先序遍历（循环）
     * @return
     */
    public List<Integer> DLRLoop() {
        List<Integer> list = new ArrayList<>();
        Node pop;
        Stack<Node> values = new Stack<>();
        values.push(this);
        while (!values.isEmpty()){
            pop = values.pop();
            list.add(pop.data);
            if (pop.right!=null)values.push(pop.right);
            if (pop.left!=null)values.push(pop.left);
        }
        return list;
    }

    /**
     * 先序遍历（递归）
     */
    private List<Integer> DLR(List<Integer> list) {
        list.add(this.data);
        if (this.left != null) {
            this.left.DLR(list);
        }
        if (this.right != null) {
            this.right.DLR(list);
        }
        return list;
    }

    /**
     * 中序遍历（循环）
     * @return
     */
    public List<Integer> LDRLoop() {
        Stack<Node> values = new Stack<>();
        List<Integer> list = new ArrayList<>();
        Node pop = this;//辅助节点
        values.push(pop);
        while (!values.isEmpty()) {
            //左子树和根节点入栈
            while (pop != null && pop.left != null) {
                values.push(pop.left);
                pop = pop.left;
            }
            //出栈
            pop = values.pop();
            list.add(pop.data);
            //右子树入栈
            if ((pop = pop.right)!=null)values.push(pop);
        }
        return list;
    }

    /**
     * 后序遍历（循环）
     * @return
     */
    public List<Integer> LRDLoop() {
        Node pop;
        List<Integer> list = new ArrayList<>();
        Stack<Node> values = new Stack<>();
        Stack<Node> result = new Stack<>();
        values.push(this);
        while (!values.isEmpty()){
            pop = values.pop();
            result.push(pop);
            if (pop.left!=null)values.push(pop.left);
            if (pop.right!=null)values.push(pop.right);
        }
        while (!result.isEmpty()){
            list.add(result.pop().data);
        }
        return list;
    }

    /**
     * 中序遍历（递归）
     * @param list
     * @return
     */
    private List<Integer> LDR(List<Integer> list) {
        if (this.left != null) {
            this.left.LDR(list);
        }
        list.add(this.data);
        if (this.right != null) {
            this.right.LDR(list);
        }
        return list;
    }

    /**
     * 后序遍历（递归）
     * @param list
     * @return
     */
    private List<Integer> LRD(List<Integer> list) {
        if (this.left != null) {
            this.left.LRD(list);
        }
        if (this.right != null) {
            this.right.LRD(list);
        }
        list.add(this.data);
        return list;
    }

    /**
     * 添加元素
     * @param data
     */
    public void add(int data){
        if (this.data> data){
            if (this.left==null){
                this.left = new Node(data);
            }else {
                this.left.add(data);
            }
        }else {
            if (this.right==null){
                this.right = new Node(data);
            }else {
                this.right.add(data);
            }
        }
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
