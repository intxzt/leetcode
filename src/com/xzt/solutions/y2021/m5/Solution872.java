package com.xzt.solutions.y2021.m5;

public class Solution872 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return dfs(root1, "").equals(dfs(root2, ""));
    }

    public String dfs(TreeNode root, String path) {
        if (root == null)
            return path;

        if (root.left == null && root.right == null) {
            path += root.val;
        }

        return dfs(root.left, path) + dfs(root.right, path);
    }
}
