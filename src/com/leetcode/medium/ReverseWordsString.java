package com.leetcode.medium;

public class ReverseWordsString {

    public static String reverseWords(String s) {
        String[] sClean = s.trim().split("\\s+");
        StringBuilder result = new StringBuilder();

        for (int i = sClean.length - 1; i >= 0 ; i--) {
            result.append(sClean[i]);
            if(i != 0) {
                result.append(" ");
            }
        }
        return result.toString();
    }

}
