package com.xx.alg;

import com.xx.utils.PrintUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams extends AbstractAlg<List<String>> {
    @Override
    protected List<String> prepareData() {
        String[] str = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
        return Arrays.asList(str);
    }

    private Map<String, List<String>> res = new HashMap<>();
    @Override
    protected void realRun(List<String> data) {
        for(String str : data) {
            String key = translateString(str);
            if (res.containsKey(key)) {
                res.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                res.put(key,list);
            }
        }
        List<List<String>> lists = new ArrayList<>();
        for(List<String> values : res.values()) {
            lists.add(values);
        }
        PrintUtils.print(lists);
    }

    private String translateString(String string) {
        char[] resut = string.toCharArray();
        Arrays.sort(resut);
        return new String(resut);
    }



}
