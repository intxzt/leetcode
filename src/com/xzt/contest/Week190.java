package com.xzt.contest;

public class Week190 {
    /**
     * 5416. 检查单词是否为句中其他单词的前缀
     *
     * @param sentence
     * @param searchWord
     * @return
     */
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] strings = sentence.split(" ");
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].startsWith(searchWord))
                return i + 1;
        }
        return -1;
    }

    /**
     * 5417. 定长子串中元音的最大数目
     *
     * @param s
     * @param k
     * @return
     */
    public int maxVowels(String s, int k) {
        int ans = 0;
        int cur = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isChar(s, i))
                cur++;
            if (i >= k && isChar(s, i - k))
                cur--;
            ans = Math.max(ans, cur);
        }
        return ans;
    }

    private boolean isChar(String s, int index) {
        return s.charAt(index) == 'a' || s.charAt(index) == 'e' || s.charAt(index) == 'i' || s.charAt(index) == 'o'
                || s.charAt(index) == 'u';
    }


    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
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

    /**
     * 5418. 二叉树中的伪回文路径
     */
    private int[] nums = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int ans = 0;

    public int pseudoPalindromicPaths(TreeNode root) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null) {
            nums[root.val]++;
            if (isPes())
                ans++;
            nums[root.val]--;
            return ans;
        }
        nums[root.val]++;
        if (root.left != null)
            pseudoPalindromicPaths(root.left);
        if (root.right != null)
            pseudoPalindromicPaths(root.right);
        nums[root.val]--;
        return ans;
    }

    private boolean isPes() {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] % 2 == 1)
                count++;
        }
        return count < 2;
    }
}
