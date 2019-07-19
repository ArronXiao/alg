package com.xx;

import com.xx.alg.AbstractAlg;
import com.xx.alg.Combination;
import com.xx.alg.DoubleNumsSum;
import com.xx.alg.FirstMissPositive;
import com.xx.alg.GroupAnagrams;
import com.xx.alg.KMP;
import com.xx.alg.LengthOfLongestSubstring;
import com.xx.alg.NQueens;
import com.xx.alg.Permutations;
import com.xx.alg.PhoneNumberCombine;
import com.xx.alg.ReverseLink;
import com.xx.alg.SearchRotate;
import com.xx.alg.tree.RootFirtTreeTraversal;

import java.util.ArrayList;
import java.util.List;

public class algMain {

    public static void main(String[] args) {
        List<AbstractAlg> list = new ArrayList<>();
        list.add(new DoubleNumsSum());
        list.add(new LengthOfLongestSubstring());
        list.add(new NQueens());
        list.add(new RootFirtTreeTraversal());

        runAll(list, false);
    }

    private static void runAll(List<AbstractAlg> list, boolean isTrue) {
        if (isTrue) {
            for (AbstractAlg abstractAlg : list) {
                abstractAlg.run();
            }
        } else {
            list.get(list.size() - 1).run();
        }
    }

}
