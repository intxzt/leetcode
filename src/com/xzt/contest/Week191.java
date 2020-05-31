package com.xzt.contest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Week191 {

    private final long bigNum = 100000007;

    /**
     * 5424. 数组中两元素的最大乘积
     * 
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                max = Math.max(max, (nums[i] - 1) * (nums[j] - 1));
            }
        }
        return max;
    }

    /**
     * 5425. 切割后面积最大的蛋糕
     * 
     * @param h
     * @param w
     * @param horizontalCuts
     * @param verticalCuts
     * @return
     */
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int maxW = 0;
        int pre = 0;

        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        for (int i = 0; i < verticalCuts.length; i++) {
            maxW = Math.max(maxW, verticalCuts[i] - pre);
            pre = verticalCuts[i];
        }
        maxW = Math.max(maxW, w - pre);

        int maxH = 0;
        pre = 0;
        for (int i = 0; i < horizontalCuts.length; i++) {
            maxH = Math.max(maxH, horizontalCuts[i] - pre);
            pre = horizontalCuts[i];
        }
        maxH = Math.max(maxH, h - pre);

        return (int) (((maxH % bigNum) * (maxW % bigNum)) % bigNum);
    }

    /**
     * 5426. 重新规划路线
     * 
     * @param n
     * @param connections
     * @return
     */
    public int minReorder(int n, int[][] connections) {
        int ans = 0;
        int length = connections.length;
        int[] visited = new int[length];
        Set<Integer> set = new HashSet<>();
        set.add(0);
        while (!set.isEmpty()) {
            Set<Integer> curSet = new HashSet<>();
            for (int j = 0; j < length; j++) {
                if (visited[j] == 1)
                    continue;
                if (set.contains(connections[j][0])) {
                    visited[j] = 1;
                    curSet.add(connections[j][1]);
                    ans++;
                } else if (set.contains(connections[j][1])) {
                    visited[j] = 1;
                    curSet.add(connections[j][0]);
                }
            }
            set = curSet;
        }
        return ans;
    }
}