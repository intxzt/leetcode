package com.xzt.solutions;

public class Solution70 {
    // 动态规划
    public int climbStairs(int n) {
        if (n < 2)
            return n;
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int temp = second;
            second = second + first;
            first = temp;
        }
        return second;
    }

    // 递归
    public int climbStairs2(int n) {
        return climbStairs(n, new int[n + 1]);
    }

    private int climbStairs(int n, int[] m) {
        if (n < 3)
            return n;
        if (m[n] != 0)
            return m[n];
        m[n] = climbStairs(n - 1, m) + climbStairs(n - 2, m);
        return m[n];
    }
}
