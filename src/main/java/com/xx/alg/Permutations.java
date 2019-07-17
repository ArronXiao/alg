package com.xx.alg;

import com.xx.utils.PrintUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations extends AbstractAlg<int[]> {

    private List<List<Integer>> res = new ArrayList<>();
    @Override
    protected int[] prepareData() {
        return new int[] {1,2,3};
    }

    @Override
    protected void realRun(int[] data) {
        backTrace(data,  new ArrayList<>());
        PrintUtils.print(res);
    }

    private void backTrace(int[] source, List<Integer> tmp) {
        if (tmp.size() == source.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for(int i = 0; i < source.length; i++) {
            if (tmp.contains(source[i])) {
                continue;
            }
            int currentInt = source[i];
            tmp.add(currentInt);
            backTrace(source,  tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
