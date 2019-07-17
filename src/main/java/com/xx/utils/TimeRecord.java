package com.xx.utils;

public class TimeRecord {
    private long startTime;
    private String tag;
    public TimeRecord(String tag) {
        this.tag = tag;
    }

    public void start() {
        startTime = System.currentTimeMillis();
    }

    public void end() {
        PrintUtils.print(tag + " ----> total time: " + (System.currentTimeMillis() - startTime));
    }
}
