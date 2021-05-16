package com.xzt.solutions.y2021.m5;

public class Solution1486 {

    public int xorOperation(int n, int start) {
        int ans = start;
        for (int i = 1; i < n; i++) {
            ans ^= start + 2 * i;
        }
        return ans;
    }

}
