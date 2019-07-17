package com.xx.alg;

import com.xx.utils.PrintUtils;

public class KMP extends AbstractAlg<String> {

    @Override
    protected String prepareData() {
        return "abcdefg";
    }

    @Override
    protected void realRun(String data) {
        String target = "bcd";
        int[] next = getNextArray(target);
        int j = 0;
        int i = 0;
        PrintUtils.print("realRun  1");
        while (i < data.length() && j < target.length()) {
            if (j == -1 || (data.charAt(i) == target.charAt(j))) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        PrintUtils.print("realRun  2");
        if (j == target.length()) {
            PrintUtils.print("find i " + (i - j) + " j: " + j + " i: " + i);
            return;
        }
    }

    private int[] getNextArray(String target) {
        char[] targetChars = target.toCharArray();
        int[] next = new int[targetChars.length];
        int k = -1;   //初始化为-1
        int i = 0;
        next[0] = -1; //当第一次的肯定是为0
        while (i < targetChars.length - 1) {
            if(k == -1 || (targetChars[i] == targetChars[k])) {
                if (targetChars[++i] == targetChars[++k]) {
                    next[i] = next[k]; //如果两数相等，则直接平移
                } else {
                    next[i] = k;
                }
            } else {
                k = next[k];
            }
        }
        PrintUtils.print("getNextArray  ");
        return next;
    }

}
