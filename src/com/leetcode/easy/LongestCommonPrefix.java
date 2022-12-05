package com.leetcode.easy;

import java.util.Arrays;

public class LongestCommonPrefix {

    /*public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length() ; i++){
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }*/

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if(strs.length == 1) return strs[0];

        StringBuilder result = new StringBuilder();
        //sort the array
        Arrays.sort(strs);

        //get the first and last strings
        String first = strs[0];
        String last = strs[strs.length - 1];

        int min = Math.min(first.length(), last.length());

        //start comparing
        for (int i = 0; i < min; i++ ) {
            if(first.charAt(i) != last.charAt(i)) {
                break;
            }
            result.append(first.charAt(i));
        }
        return result.toString();
    }

}
