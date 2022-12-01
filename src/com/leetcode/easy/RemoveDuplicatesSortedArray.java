package com.leetcode.easy;

public class RemoveDuplicatesSortedArray {

    public static int removeDuplicates(int[] nums) {
        if(nums == null ||nums.length == 0) return 0;
        int fast = 1, slow = 0, n = nums.length;

        while (fast < n) {
            if (nums[fast] > nums[slow] ) {
                nums[slow + 1] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow + 1;
    }
}
