package com.xzt.solutions.y2021.m5;

public class Solution13 {

    public int romanToInt(String s) {
        int length = s.length();
        int res = 0;
        int pre = 0;
        int num = 0;
        for (int i = 0; i < length; i++) {
            num = getVal(s.charAt(i));
            res += num;
            res += num > pre ? -pre << 1 : 0;
            pre = num;
        }
        return res;
    }

    private int getVal(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}

