package com.xzt.solutions.y2021.m5;

public class Solution7 {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }

    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            if (result < Integer.MIN_VALUE / 10 || result > Integer.MAX_VALUE / 10)
                return 0;
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return result;
    }
}
