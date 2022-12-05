package com.leetcode.easy;

import java.util.Arrays;

public class SingleNumber {

    public int singleNumber(int[] nums) {
        if(nums.length == 1) return nums[0];

        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 1; i < n; i+=2) {
            if(nums[i] != nums[i - 1]) return nums[i - 1];
        }

        return nums[n - 1];
    }

}
