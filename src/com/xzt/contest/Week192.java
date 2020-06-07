package com.xzt.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Week192 {
    /**
     * 5428. 重新排列数组
     * 
     * @param nums
     * @param n
     * @return
     */
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];

        for (int i = 0; i < n; i++) {
            ans[2 * i] = nums[i];
            ans[2 * i + 1] = nums[i + n];
        }
        return ans;
    }

    /**
     * 5429. 数组中的 k 个最强值
     * 
     * @param arr
     * @param k
     * @return
     */
    public int[] getStrongest(int[] arr, int k) {
        Integer[] newArr = new Integer[arr.length];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = arr[i];
        }
        Arrays.sort(arr);
        int m = arr[(arr.length - 1) >> 1];

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1 - m) == Math.abs(o2 - m)) {
                    return o2 - o1;
                }
                return Math.abs(o2 - m) - Math.abs(o1 - m);
            }
        };

        Arrays.sort(newArr, comparator);
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = newArr[i];
        }
        return ans;
    }

    /**
     * 5430. 设计浏览器历史记录
     */
    class BrowserHistory {
        String homePage;
        List<String> history = new ArrayList<>();
        int index;

        public BrowserHistory(String homepage) {
            history.add(homepage);
            index = 0;
            this.homePage = homepage;
        }

        public void visit(String url) {
            for (int i = index + 1; i < history.size();) {
                history.remove(i);
            }
            history.add(url);
            index++;
        }

        public String back(int steps) {
            for (int i = 0; i < steps; i++) {
                if (index == 0)
                    break;
                index--;
            }
            return history.get(index);
        }

        public String forward(int steps) {
            int size = history.size();
            for (int i = 0; i < steps; i++) {
                if (index == size - 1)
                    break;
                index++;
            }
            return history.get(index);
        }
    }

}