package com.leetcode.easy;

import java.util.HashMap;

public class ValidWordAbbr {
    HashMap<String, String> map;

    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();
        for(String str:dictionary){
            String key = getKey(str);
            // If there is more than one string belong to the same key
            // then the key will be invalid, we set the value to ""
            if(map.containsKey(key) && !map.get(key).equals(str)) {
                map.put(key, "");
            } else {
                map.put(key, str);
            }
        }
    }

    public boolean isUnique(String word) {
        String key = getKey(word);
        return !map.containsKey(key)||map.get(key).equals(word);
    }

    private String getKey(String str){
        if(str.length()<=2) return str;
        return str.charAt(0)+Integer.toString(str.length()-2)+str.charAt(str.length()-1);
    }

    public static void main(String[] args) {
        String [] words = {"ValidWordAbbr", "isUnique", "isUnique", "isUnique", "isUnique", "isUnique"};
        ValidWordAbbr validWordAbbr = new ValidWordAbbr(words);
        System.out.println(validWordAbbr);

    }
}
