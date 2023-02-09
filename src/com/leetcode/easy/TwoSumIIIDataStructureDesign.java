package com.leetcode.easy;

import java.util.HashMap;

public class TwoSumIIIDataStructureDesign {

    private HashMap<Integer, Integer> num_counts;

    public TwoSumIIIDataStructureDesign() {
        this.num_counts = new HashMap<>();
    }

    public void add(int number) {
        this.num_counts.put(number, num_counts.getOrDefault(number, 0) + 1);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for(Integer key : this.num_counts.keySet()) {
            int complement = value - key;
            if(complement != key) {
                if(this.num_counts.containsKey(complement))
                    return true;
            } else if(this.num_counts.get(key) > 1)
                return true;
        }
        return false;
    }
}
