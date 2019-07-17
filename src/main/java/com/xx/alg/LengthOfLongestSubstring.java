package com.xx.alg;

import com.xx.utils.PrintUtils;

import java.util.HashMap;

public class LengthOfLongestSubstring extends AbstractAlg<String> {
    @Override
    protected String prepareData() {
        return " ";
    }

    @Override
    protected void realRun(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))) {
                max = Math.max(max, hashMap.size());
                i = hashMap.get(s.charAt(i));
                hashMap.clear();
            } else {
                hashMap.put(s.charAt(i), i);
            }
        }
        PrintUtils.print("max: " + Math.max(max, hashMap.size()) + " ");
    }
}
