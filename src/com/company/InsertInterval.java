package com.company;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

  public int[][] insert(int[][] intervals, int[] newInterval) {

    int pointer = 0;

    List<int[]> result = new ArrayList<>();

    while(pointer < intervals.length && intervals[pointer][1] < newInterval[0]) {
      result.add(intervals[pointer]);
      pointer++;
      //fastforward to the interval that overlaps with newInterval
    }

    while(pointer < intervals.length && intervals[pointer][0] <= newInterval[1]) {
      newInterval[0] = Math.min(intervals[pointer][0], newInterval[0]);
      newInterval[1] = Math.max(intervals[pointer][1], newInterval[1]);
      pointer++;
      //merge all the overlapping intervals
    }

    result.add(newInterval);

    while(pointer < intervals.length) {
      result.add(intervals[pointer]); //add rest of intervals left in the intervals;
      pointer++;
    }

    int [][] resultArray = new int [result.size()][];

    return result.toArray(resultArray);
  }

  //TC: O(N) SC: O(N)


}
