package com.xzt.explore.structure.binaryTree;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

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
        System.out.println(binaryTree.DLRLoop().toString());
        System.out.println(binaryTree.DLR().toString());

        System.out.println(binaryTree.LDRLoop().toString());
        System.out.println(binaryTree.LDR().toString());
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

    /**
     * 先序遍历（循环）
     * @return
     */
    public List<Integer> DLRLoop() {
        List<Integer> list = new ArrayList<>();
        Node pop;
        Stack<Node> values = new Stack<>();
        values.add(this);
        while (!values.isEmpty()){
            pop = values.pop();
            list.add(pop.data);
            if (pop.right!=null)values.add(pop.right);
            if (pop.left!=null)values.add(pop.left);
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
        Stack<Node> stk = new Stack<>();
        List<Integer> list = new ArrayList<>();
        Node p = this;//辅助节点
        stk.add(p);
        while (!stk.isEmpty()) {
            //只要你有左孩子，就将左孩子压入栈中
            if (p != null && p.left != null) {
                stk.add(p.left);
                p = p.left;
            } else {
                p = stk.pop();//弹出栈顶节点  左孩子--->根节点
                list.add(p.data);
                if (p.right != null) {//如果栈点元素有右孩子的话，将右节点压入栈中
                    stk.add(p.right);
                    p = p.right;
                } else {
                    p = null;//p=stk.pop;已经访问过p了，p设置为null
                }
            }
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
