package com.xx.alg;

import com.xx.utils.PrintUtils;

import java.util.ArrayList;
import java.util.List;

public class NQueens extends AbstractAlg<int[][]> {
    private int n = 4;

    //表达每行皇后放置的位置
    int[] queens = new int[n];

    //表示一行的某一列是否有占用，因为是按照行进行递归，行天然的+1,不会同行
    int[] cols = new int[n];

    //主对角线，/, col + row = const  <= 2n -2
    int[] hills = new int[2 * n - 1];

    //主对角线， \ row -col = const  > -(n-1) ,考虑到越界的问题，才需要这么做
    int[] dales = new int[4 * n - 1];

    List<List<String>> output = new ArrayList<>();

    @Override
    protected int[][] prepareData() {
        return new int[0][];
    }

    @Override
    protected void realRun(int[][] data) {
        backTrace(0);
        PrintUtils.print(getTAG() + "size : " + output.size());
    }

    public boolean isNotUnderAttack(int row, int col) {
        int res = cols[col] + hills[row + col] + dales[row - col + 2 * n];
        return res == 0;
    }

    public void placeQueen(int row, int col) {
        queens[row] = col;

        cols[col] = 1;
        hills[row + col] = 1;
        dales[row - col + 2 * n] = 1;
    }

    public void removeQueen(int row, int col) {
        queens[row] = 0;

        cols[col] = 0;
        hills[row + col] = 0;
        dales[row - col + 2 * n] = 0;
    }

    public void addSolution() {
        List<String> solution = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            int col = queens[i];
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < col; ++j) {
                sb.append(".");
            }
            sb.append("Q");
            for (int j = 0; j < n - col - 1; ++j) {
                sb.append(".");
            }
            solution.add(sb.toString());
        }
        output.add(solution);
    }

    private void backTrace(int row) {
        for (int col = 0; col < n; col++) {
            //不在攻击范围内
            if (isNotUnderAttack(row, col)) {
                //把皇后放在row col里面
                placeQueen(row, col);
                if (row + 1 == n) {
                    //有了解决方法
                    addSolution();
                } else {
                    backTrace(row + 1);
                }
                //移除掉皇后
                removeQueen(row, col);
            }
        }
    }
}
