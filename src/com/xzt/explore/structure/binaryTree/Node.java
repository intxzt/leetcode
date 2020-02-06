package com.xzt.explore.structure.binaryTree;

import java.util.*;

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
        System.out.println("层次遍历----");
        System.out.println(binaryTree.levelOrder().toString());
        System.out.println("深度（先序）----");
        System.out.println(binaryTree.getDepthFront());
        System.out.println("深度（后序）----");
        System.out.println(binaryTree.getDeepBack());
        System.out.println("深度（后序）（类内部）----");
        System.out.println(binaryTree.maxDepthBack());
    }

    private int data;
    private Node left;
    private Node right;
    private int depth;

    public Node() {
        super();
    }

    public Node(int data) {
        this.data = data;
    }

    public List<Integer> DLR() {
        List<Integer> list = new ArrayList<>();
        return DLR(list);
    }

    public List<Integer> LDR() {
        List<Integer> list = new ArrayList<>();
        return LDR(list);
    }

    public List<Integer> LRD() {
        List<Integer> list = new ArrayList<>();
        return LRD(list);
    }

    /**
     * 先序遍历（循环）
     *
     * @return
     */
    public List<Integer> DLRLoop() {
        List<Integer> list = new ArrayList<>();
        Node pop;
        Stack<Node> values = new Stack<>();
        values.push(this);
        while (!values.isEmpty()) {
            pop = values.pop();
            list.add(pop.data);
            if (pop.right != null) values.push(pop.right);
            if (pop.left != null) values.push(pop.left);
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
     *
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
            if ((pop = pop.right) != null) values.push(pop);
        }
        return list;
    }

    /**
     * 中序遍历（递归）
     *
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
     * 后序遍历（循环）
     *
     * @return
     */
    public List<Integer> LRDLoop() {
        Node pop;
        List<Integer> list = new ArrayList<>();
        Stack<Node> values = new Stack<>();
        Stack<Node> result = new Stack<>();
        values.push(this);
        while (!values.isEmpty()) {
            pop = values.pop();
            result.push(pop);
            if (pop.left != null) values.push(pop.left);
            if (pop.right != null) values.push(pop.right);
        }
        while (!result.isEmpty()) {
            list.add(result.pop().data);
        }
        return list;
    }

    /**
     * 后序遍历（递归）
     *
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
     * 层序遍历
     *
     * @return
     */
    public List<List<Integer>> levelOrder() {
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(this);
        while (!q.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int nums = q.size();
            for (int i = 0; i < nums; i++) {
                Node temp = q.poll();
                if (temp == null) break;
                list.add(temp.data);
                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
            }
            res.add(list);
        }
        return res;
    }

    /**
     * 添加元素
     *
     * @param data
     */
    public void add(int data) {
        if (this.data > data) {
            if (this.left == null) {
                this.left = new Node(data);
            } else {
                this.left.add(data);
            }
        } else {
            if (this.right == null) {
                this.right = new Node(data);
            } else {
                this.right.add(data);
            }
        }
    }

    /**
     * 后序遍历求深度（类内部）
     *
     * @return
     */
    public int maxDepthBack() {
        int left_depth = 0;
        int right_depth = 0;
        if (this.left != null) {
            left_depth = this.left.maxDepthBack();
        }
        if (this.right != null) {
            right_depth = this.right.maxDepthBack();
        }
        return Math.max(left_depth, right_depth) + 1;
    }

    /**
     * 后序遍历求深度
     *
     * @param n
     * @return
     */
    private int maxDepthBack(Node n) {
        if (n == null) {
            return 0;
        }
        int left_depth = maxDepthBack(n.left);
        int right_depth = maxDepthBack(n.right);
        return Math.max(left_depth, right_depth) + 1;
    }

    public int getDeepBack() {
        return maxDepthBack(this);
    }

    /**
     * 先序遍历求深度
     *
     * @param n
     * @param d
     */
    private void maxDepthFront(Node n, int d) {
        if (n == null) {
            return;
        }
        if (n.left == null && n.right == null) {
            depth = Math.max(depth, d);
        }
        maxDepthFront(n.left, d + 1);
        maxDepthFront(n.right, d + 1);
    }

    public int getDepthFront() {
        depth = 0;
        maxDepthFront(this, 1);
        return depth;
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