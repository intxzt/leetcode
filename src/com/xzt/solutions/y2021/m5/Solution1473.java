package com.xzt.solutions.y2021.m5;

import java.util.Arrays;

public class Solution1473 {

    private static final int INFTY = Integer.MAX_VALUE / 2;

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        for (int i = 0; i < houses.length; i++) {
            houses[i]--;
        }

        int[][][] dp = new int[m][n][target];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], INFTY);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (houses[i] != -1 && houses[i] != j) {
                    continue;
                }
                for (int k = 0; k < target; k++) {
                    for (int j0 = 0; j0 < n; j0++) {
                        if (j == j0) {
                            if (i == 0) {
                                if (k == 0) {
                                    // 第一个房子初始为0
                                    dp[i][j][k] = 0;
                                }
                            } else {
                                dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j][k]);
                            }
                        } else if (i > 0 && k > 0) {
                            // 非第一个房子
                            dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j0][k - 1]);
                        }

                    }
                    if (houses[i] == -1) {
                        // 第一个房子或者变更房区--未涂颜色
                        dp[i][j][k] += cost[i][j];
                    }
                }


            }
        }
        int ans = INFTY;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[m - 1][i][target - 1]);
        }
        return ans == INFTY ? -1 : ans;
    }
}
