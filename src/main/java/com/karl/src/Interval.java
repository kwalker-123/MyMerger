package com.karl.src;

public class Interval implements Comparable<Interval>{

    private int first;
    private int second;

    public Interval (int first, int second){
        this.first = first;
        this.second = second;
    }

    // Sets the comparison function to compare first values
    // Allows sorting of list of Intervals into ascending first values
    @Override
    public int compareTo(Interval o) {
        if (o == null){
            return -1;
        }
        return first - o.first;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "{" +
                first + ","
                + second +
                '}';
    }


}
