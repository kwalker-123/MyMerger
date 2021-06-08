package com.karl.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//General plan
//1: Sort intervals by ascending first values, this allows for checking adjacent intervals instead of needing to compare whole set
//2: Store first,second values of 1st interval (curFirst, curSecond).
//3: Is next interval's first > curSecond?
//            Yes -> add Interval object to output with curFirst, curSecond
//                      then store first,second values of next interval (as curFirst, curSecond)
//4:          No  -> Is next interval's second > curSecond?
//                      Yes -> set curSecond = next interval's second
//                      No  -> do nothing
//5: After iterating through the list of intervals, add Interval object with remaining curFirst, curSecond
//6: Return output


public class IntervalMerger {
    public List<Interval> merge(List<Interval> input){


        //System.out.println("Input: " + input);
        Collections.sort(input);
        //System.out.println("Sorted: " + input);

        List<Interval> output = new ArrayList<>();

        int curFirst = input.get(0).getFirst();
        int curSecond = input.get(0).getSecond();

        for (int i = 1; i < input.size(); i++){
            if( input.get(i).getFirst() > curSecond){
                output.add(new Interval(curFirst,curSecond));
                curFirst = input.get(i).getFirst();
                curSecond = input.get(i).getSecond();
            }else if(input.get(i).getSecond() > curSecond){
                curSecond = input.get(i).getSecond();
            }
        }
        output.add(new Interval(curFirst,curSecond));

        return output;
    }
}
