package com.xx.alg;

import com.xx.utils.PrintUtils;

public class FirstMissPositive extends AbstractAlg<int[]> {

    @Override
    protected int[] prepareData() {
        return new int[]{1, 1};
    }

    @Override
    protected void realRun(int[] data) {
        if (data == null || data.length == 0) {
            return;
        }
        int i = 0;
        for (i = 0; i < data.length; i++) {
            //j 应该放在 j - 1的位置上
            while (data[i] > 0 && data[i] < data.length + 1) {
                int j = data[i];
                if (j == i + 1) {
                    //j 应该放在 j - 1的位置上,该元素复合要求，可以保留
                    break;
                } else {
                    //如果不等，则负责把j放到合适的位置
                    //交换 data[i] 与 data[j - 1]
                    if (data[j - 1] != data[i]) {
                        int tmp = data[j - 1];
                        data[j - 1] = data[i];
                        data[i] = tmp;
                    } else {
                        break;
                    }
                }
            }
        }
        for (i = 0; i < data.length; i++) {
            if (data[i] != i + 1) {
                break;
            }
        }
        PrintUtils.print(" miss positive : " + (i + 1));
    }

}
