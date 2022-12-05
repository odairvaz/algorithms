package com.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        if(nums == null ||nums.length < 2 ) return false;

        Set<Integer> duplicate = new HashSet<>();
        for(Integer n : nums) {
            if(duplicate.contains(n)) return true;
            duplicate.add(n);
        }

        return false;
    }
}
