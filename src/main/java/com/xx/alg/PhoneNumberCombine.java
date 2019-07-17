package com.xx.alg;

import com.xx.utils.PrintUtils;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneNumberCombine extends AbstractAlg<HashMap<String,String>>{
    HashMap<String, String> phone;
    String inputString = "23456";
    ArrayList<String> arrayList = new ArrayList<>();

    @Override
    protected HashMap<String, String> prepareData() {
         phone = new HashMap<String, String>() {{
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }};
        return phone;
    }

    @Override
    protected void realRun(HashMap<String, String> data) {
        backTrace("", inputString);
        PrintUtils.print(arrayList);
    }

    private void backTrace(String combineStr, String next_digist) {
        if (combineStr.length() == inputString.length()) {
//            arrayList.add(combineStr);
            PrintUtils.print("result: " + combineStr);
            return;
        }
        String digist  = next_digist.substring(0,1);
        String map = phone.get(digist);
        for(int i = 0; i < map.length(); i++) {
            String letter = phone.get(digist).substring(i, i + 1);
            backTrace(combineStr + letter, next_digist.substring(1));
        }
    }
}
