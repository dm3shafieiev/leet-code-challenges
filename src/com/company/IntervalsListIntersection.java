package com.company;

import java.util.ArrayList;
import java.util.List;

public class IntervalsListIntersection {

  public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

    int firstListPointer = 0;
    int secondListPointer = 0;

    List<int[]> resultList = new ArrayList<>();

    while(firstListPointer < firstList.length && secondListPointer < secondList.length) {

      int firstIntervalStart = firstList[firstListPointer][0];
      int firstIntervalEnd = firstList[firstListPointer][1];
      int secondIntervalStart = secondList[secondListPointer][0];
      int secondIntervalEnd = secondList[secondListPointer][1];

      if(firstIntervalStart <= secondIntervalEnd && firstIntervalEnd >= secondIntervalStart) {

        int [] mergedInterval = new int [2];

        mergedInterval[0] = Math.max(firstIntervalStart, secondIntervalStart);
        mergedInterval[1] = Math.min(firstIntervalEnd, secondIntervalEnd);

        resultList.add(mergedInterval);
      }

      if(firstList[firstListPointer][1] > secondList[secondListPointer][1] ) {
        secondListPointer++;
      }else {
        firstListPointer++;
      }

    }

    int [][]  resultArray = new int [resultList.size()][];

    return resultList.toArray(resultArray);

  }

  /**
   * more elegant solution
   */

  public int[][] intervalIntersectionElegant(int[][] firstList, int[][] secondList) {

    int firstListPointer = 0;
    int secondListPointer = 0;

    List<int[]> resultList = new ArrayList<>();

    while(firstListPointer < firstList.length && secondListPointer < secondList.length) {

      int firstIntervalStart = firstList[firstListPointer][0];
      int firstIntervalEnd = firstList[firstListPointer][1];
      int secondIntervalStart = secondList[secondListPointer][0];
      int secondIntervalEnd = secondList[secondListPointer][1];

      int intersectionStart = Math.max(firstIntervalStart, secondIntervalStart);
      int intersectionEnd = Math.min(firstIntervalEnd, secondIntervalEnd);

      if(intersectionStart <= intersectionEnd) {
        resultList.add(new int [] {intersectionStart, intersectionEnd});
      }

      if(firstList[firstListPointer][1] > secondList[secondListPointer][1] ) {
        secondListPointer++;
      }else {
        firstListPointer++;
      }

    }

    int [][]  resultArray = new int [resultList.size()][];

    return resultList.toArray(resultArray);

  }

  //TC: O(n+m) SC: O(n+m)

}
