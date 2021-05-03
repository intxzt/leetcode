package com.xzt.solution;

import java.util.*;

public class Solution554 {

    public static void main(String[] args) {
        Integer[][] a = {{1, 2, 2, 1}, {3, 1, 2}, {1, 3, 2}, {2, 4}, {3, 1, 2}, {1, 3, 1, 1}};
        List<List<Integer>> wall = new ArrayList<>();
        for (Integer[] ints : a) {
            List<Integer> integers = Arrays.asList(ints);
            wall.add(integers);
        }

        System.out.println(new Solution554().leastBricks(new ArrayList<>(wall)));
    }

    /**
     * 输入：wall = [[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]]
     * 输出：2
     *
     * @param wall
     * @return
     */
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (List<Integer> integers : wall) {
            int sum = 0;
            int n = integers.size() - 1;
            for (int j = 0; j < n; j++) {
                sum += integers.get(j);
                cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
            }
        }
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            max = Math.max(max, entry.getValue());
        }
        return wall.size() - max;
    }
}
