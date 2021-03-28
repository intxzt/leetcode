package com.xzt.solution;

public class Solution11 {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int maxArea = 0;
        while (i < j) {
            maxArea = Math.max(maxArea,
                    (j - i) * (height[i] < height[j] ? height[i++] : height[j--]));
        }
        return maxArea;
    }
}
