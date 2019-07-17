package com.xx.alg;

import com.sun.deploy.util.ArrayUtil;
import com.xx.utils.PrintUtils;

import java.util.Arrays;
import java.util.HashMap;

public class DoubleNumsSum extends AbstractAlg<int[]> {

    private int target = 10;


    @Override
    protected int[] prepareData() {
        int[] ints = new int[]{2, 4, 5, 3, 1, 9};
        return ints;
    }

    @Override
    protected void realRun(int[] data) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < data.length; i++) {
            int result = target - data[i];
            if (hashMap.containsKey(result)) {
                int otherIndex = hashMap.get(result);
                PrintUtils.print("index is i -> " + i + " --  j ->" + otherIndex);
                return;
            } else {
                hashMap.put(data[i], i);
            }
        }

        Arrays.sort(data);

    }
}
