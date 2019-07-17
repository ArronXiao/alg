package com.xx.alg;

public class MaxChildSequence extends AbstractAlg<int[]> {
    @Override
    protected int[] prepareData() {
        return new int[0];
    }

    @Override
    protected void realRun(int[] data) {
        int sum = 0;
        int result = -1;
        for(int i = 0 ; i < data.length; i++) {
            //前面的已知的最大的和和当前数值进行处理，只能从当前的数值为正数时，对结果有受益，如果是负数，则不要相加，直接赋值
            if (data[i] > 0) {
                sum = sum + data[i];
            } else {
                sum = data[i];
            }
            result = Math.max(sum, result);
        }
    }
}
