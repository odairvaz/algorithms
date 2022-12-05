package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> curr, prev = new ArrayList<>() {
            {
                add(1);
            }
        };

        for (int i = 1; i <= rowIndex; i++) {
            curr = new ArrayList<>(i + 1) {
                        {
                            add(1);
                        }
                    };

            for (int j = 1; j < i; j++) {
                curr.add(prev.get(j - 1) + prev.get(j));
            }
            curr.add(1);
            prev = curr;
        }

        return prev;
    }

}
