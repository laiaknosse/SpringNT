package com.example.NT.logic;

public class Range {
    private final int start;
    private final int end;

    public Range(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public boolean inRange(int num) {
        return (num >= start && num <= end);
    }
}
