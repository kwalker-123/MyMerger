package com.karl.src;


import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        long startTime = System.nanoTime();

        Interval itv1 = new Interval(25,30);
        Interval itv2 = new Interval(2,19);
        Interval itv3 = new Interval(14,23);
        Interval itv4 = new Interval(4,8);

        List<Interval> intervalList = new ArrayList<>();
        intervalList.add(itv1);
        intervalList.add(itv2);
        intervalList.add(itv3);
        intervalList.add(itv4);

        IntervalMerger im = new IntervalMerger();

        System.out.println("Output: " + im.merge(intervalList));

        // Time of programme to execute
        System.out.println((System.nanoTime() - startTime) /1000000 + " ms");



    }
}
