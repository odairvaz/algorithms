package com.leetcode.medium;

import java.util.*;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        if(k == nums.length) return nums;

        Map<Integer, Integer> numFreq = new HashMap<>();
        for (int num: nums) {
            numFreq.put(num, numFreq.getOrDefault(num, 0) +1);
        }
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int key: numFreq.keySet()) {
            buckets[numFreq.get(key)].add(key);
        }

        List<Integer> flatened = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 ; i--) {
            for (int num: buckets[i]) {
                flatened.add(num);
            }
        }
        
        int[] top = new int[k];
        for (int i = 0; i < k; i++) {
            top[i] = flatened.get(i);
        }

        return top;
    }

}
