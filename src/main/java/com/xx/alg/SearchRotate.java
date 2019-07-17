package com.xx.alg;

import com.xx.utils.PrintUtils;

import java.util.ArrayList;
import java.util.List;

public class SearchRotate extends AbstractAlg<List<Integer>> {

    @Override
    protected List<Integer> prepareData() {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(2);
        list.add(3);
        return list;
    }

    @Override
    protected void realRun(List<Integer> data) {
        PrintUtils.print("result roate: " + findRotateIndex(data, 0, data.size() - 1));


    }

    private int findRotateIndex(List<Integer> list, int left , int right) {
        if(list.get(left) < list.get(right)) {
            return 0;
        }
        while (left <= right) {
            int mid = (left + right) / 2;
            int midValue = list.get(mid);
            if (midValue > list.get(mid + 1)) {
                return mid + 1;
            } else {
                if (midValue < list.get(left)) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return 0;
    }
}
