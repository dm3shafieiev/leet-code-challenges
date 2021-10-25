package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

  public int[][] merge(int[][] intervals) {

    List<int[]> resultList = new ArrayList<>();
    Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));

    int mergedIntervalsPointer = 0;

    resultList.add(intervals[0]);

    for(int pointer = 1; pointer < intervals.length; pointer++) {

      int[] currentArray = intervals[pointer];
      int previousArrayEnd = resultList.get(mergedIntervalsPointer)[1];
      int currentArraysStart = currentArray[0];
      int currentArraysEnd = currentArray[1];

      if(previousArrayEnd >= currentArraysStart) {
        resultList.get(mergedIntervalsPointer)[1] =  Math.max(currentArraysEnd, previousArrayEnd);
      }else {
        resultList.add(currentArray);
        mergedIntervalsPointer++;
      }
    }

    int[][] resultArray = new int[resultList.size()][];
    resultList.toArray(resultArray);

    return resultArray;
  }

}
