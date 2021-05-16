package com.xzt.solutions.y2021.m5;

public class Solution1269 {

    public int numWays(int steps, int arrLen) {
        final int mod = 1000000007;
        int min = Math.min(steps, arrLen - 1);
        int[][] dp = new int[steps + 1][min + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= steps; i++) {
            for (int j = 0; j <= min; j++) {
                //不动
                dp[i][j] = dp[i - 1][j];
                // left
                if (j + 1 <= min) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % mod;
                }
                // right
                if (j - 1 >= 0) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % mod;
                }
            }
        }
        return dp[steps][0];
    }

}
