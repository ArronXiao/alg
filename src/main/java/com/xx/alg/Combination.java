package com.xx.alg;

import com.xx.utils.PrintUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination extends AbstractAlg<List<Integer>> {

    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> origin = new ArrayList<>();

    @Override
    protected List<Integer> prepareData() {
        origin.add(2);
        origin.add(3);
        origin.add(6);
        origin.add(7);
        return origin;
    }

    @Override
    protected void realRun(List<Integer> data) {
        //如果是无序的则需要进行排序后进行递归回溯

        //回溯需要保存中间的状态值，需要进行切割最适合这种组合的， 当选中A，剩下的需要从哪里选择
        backTrace(7, 0, new ArrayList<>());
        PrintUtils.print(res);
    }

    private void backTrace(int target, int startIndex, ArrayList<Integer> tmpArrayList) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(tmpArrayList));
            return;
        }
        for(int i = startIndex; i < origin.size(); i++) {
            if (origin.get(i) > target) {
                break;
            }
            tmpArrayList.add(origin.get(i));
            int left = target - origin.get(i);
            backTrace(left, i, tmpArrayList);
            tmpArrayList.remove(tmpArrayList.size() - 1);
        }
    }
}
