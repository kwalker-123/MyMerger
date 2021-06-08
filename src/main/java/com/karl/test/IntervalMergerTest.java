package com.karl.test;

import com.karl.src.Interval;
import com.karl.src.IntervalMerger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;


public class IntervalMergerTest {

    @Test
    public void testWithDisconnectedInterval(){

        List<Interval> intervalList = new ArrayList<>();
        intervalList.add(new Interval(25,30));
        intervalList.add(new Interval(2,19));
        intervalList.add(new Interval(14,23));
        intervalList.add(new Interval(4,8));

        List<Interval> expected = new ArrayList<>();
                expected.add(new Interval(2,23));
                expected.add(new Interval(25,30));

        IntervalMerger im = new IntervalMerger();

        assertEquals(expected.toString(),im.merge(intervalList).toString());
    }

    @Test
    public void testWithOneInterval(){

        List<Interval> intervalList = new ArrayList<>();
        intervalList.add(new Interval(2,30));

        List<Interval> expected = new ArrayList<>();
        expected.add(new Interval(2,30));

        IntervalMerger im = new IntervalMerger();

        assertEquals(expected.toString(),im.merge(intervalList).toString());
    }

    @Test
    public void testWithAllOverlappingIntervals(){

        List<Interval> intervalList = new ArrayList<>();
        intervalList.add(new Interval(2,30));
        intervalList.add(new Interval(4,52));
        intervalList.add(new Interval(6,60));
        intervalList.add(new Interval(7,12));

        List<Interval> expected = new ArrayList<>();
        expected.add(new Interval(2,60));

        IntervalMerger im = new IntervalMerger();

        assertEquals(expected.toString(),im.merge(intervalList).toString());
    }

    @Test
    public void testWithManyIntervals(){

        List<Interval> intervalList = new ArrayList<>();
        intervalList.add(new Interval(25,30));
        intervalList.add(new Interval(3,19));
        intervalList.add(new Interval(14,23));
        intervalList.add(new Interval(4,8));
        intervalList.add(new Interval(11,20));
        intervalList.add(new Interval(41,45));
        intervalList.add(new Interval(32,44));
        intervalList.add(new Interval(27,28));
        intervalList.add(new Interval(25,28));
        intervalList.add(new Interval(39,43));
        intervalList.add(new Interval(20,21));
        intervalList.add(new Interval(30,31));
        intervalList.add(new Interval(1,2));

        List<Interval> expected = new ArrayList<>();
        expected.add(new Interval(1,2));
        expected.add(new Interval(3,23));
        expected.add(new Interval(25,31));
        expected.add(new Interval(32,45));

        IntervalMerger im = new IntervalMerger();

        assertEquals(expected.toString(),im.merge(intervalList).toString());
    }

    @Test
    public void testWithNoIntervals(){
        List<Interval> intervalList = new ArrayList<>();
        List<Interval> expected = new ArrayList<>();

        IntervalMerger im = new IntervalMerger();

        assertEquals(expected.toString(),im.merge(intervalList).toString());
    }







}
