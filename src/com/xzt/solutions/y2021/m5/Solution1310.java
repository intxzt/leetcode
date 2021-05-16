package com.xzt.solutions.y2021.m5;

public class Solution1310 {

    public int[] xorQueries(int[] arr, int[][] queries) {
        int arrLength = arr.length;
        int[] xorS = new int[arrLength];

        xorS[0] = arr[0];
        for (int i = 1; i < arrLength; i++) {
            xorS[i] = xorS[i - 1] ^ arr[i];
        }

        int queriesLength = queries.length;
        int[] ans = new int[queriesLength];
        for (int i = 0; i < queriesLength; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            ans[i] = xorS[right] ^ (left > 0 ? xorS[left - 1] : 0);
        }
        return ans;
    }

}
