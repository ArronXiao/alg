package com.xx.alg;

import com.xx.utils.PrintUtils;
import com.xx.utils.TimeRecord;

public abstract class AbstractAlg  <T> {

    private String TAG = this.getClass().getSimpleName() + " --> ";

    public String getTAG() {
        return TAG;
    }

    protected abstract T prepareData();

    protected abstract void realRun(T data);

    public void run() {
        TimeRecord record = new TimeRecord(this.getClass().getSimpleName());
        record.start();
        realRun(prepareData());
        record.end();
    }
}
