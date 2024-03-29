package com.xzt.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {
    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        solution15.threeSum(new int[]{34, 55, 79, 28, 46, 33, 2, 48, 31, -3, 84, 71, 52, -3, 93, 15, 21, -43, 57, -6, 86, 56, 94,
                74, 83, -14, 28, -66, 46, -49, 62, -11, 43, 65, 77, 12, 47, 61, 26, 1, 13, 29, 55, -82, 76, 26, 15, -29, 36, -29, 10, -70, 69, 17, 49});
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < len - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1])
                continue;
            int left = i + 1, right = len - 1;
            int sum = nums[i] + nums[left];
            while (sum <= 0 && left < right) {
                sum += nums[right];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[++left]) ;
                    while (right > left && nums[right] == nums[--right]) ;
                } else if (sum > 0) {
                    while (right > left && nums[right] == nums[--right]) ;
                } else {
                    while (left < right && nums[left] == nums[++left]) ;
                }
                sum = nums[i] + nums[left];
            }
        }
        return ans;
    }
}
