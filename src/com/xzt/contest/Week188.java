package com.xzt.contest;

import java.util.ArrayList;
import java.util.List;

public class Week188 {
    /**
     * 1441. 用栈操作构建数组
     *
     * @param target
     * @param n
     * @return
     */
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int cur = 1;
        int i = 0;
        while (i < target.length) {
            if (target[i] != cur) {
                res.add("Push");
                res.add("Pop");
            } else {
                res.add("Push");
                i++;
            }
            cur++;
        }
        return res;
    }

    /**
     * 1442. 形成两个异或相等数组的三元组数目
     *
     * @param arr
     * @return
     */
    public int countTriplets(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int b = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                b ^= arr[j];
                if (b == 0) {
                    res += (j - i);
                }
            }
        }
        return res;
    }
}
