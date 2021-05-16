package com.xzt.solutions.y2021.m5;

public class Solution1482 {
    public static void main(String[] args) {
        int[] b = {7, 7, 7, 7, 12, 7, 7};
        Solution1482 solution1482 = new Solution1482();
        solution1482.minDays(b, 2, 3);
    }

    public int minDays(int[] bloomDay, int m, int k) {
        // 花不够
        if (m * k > bloomDay.length) {
            return -1;
        }
        int low = Integer.MAX_VALUE, high = 0;
        for (int i : bloomDay) {
            low = Math.min(low, i);
            high = Math.max(high, i);
        }
        while (low < high) {
            int days = (high + low) >> 1;
            if (canMake(bloomDay, days, m, k)) {
                high = days;
            } else {
                low = days + 1;
            }
        }
        return low;
    }

    public boolean canMake(int[] bloomDay, int days, int m, int k) {
        int bouquets = 0;
        int flowers = 0;
        for (int curDay : bloomDay) {
            if (bouquets >= m) {
                break;
            }
            if (curDay <= days) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                // 必须相邻
                flowers = 0;
            }
        }
        return bouquets >= m;
    }
}
