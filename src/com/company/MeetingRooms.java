package com.company;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {

  public boolean canAttendMeetings(int[][] intervals) {

    Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));

    for(int pointer = 1; pointer < intervals.length; pointer ++) {

      if(intervals[pointer - 1][1] > intervals[pointer][0]) {
        return false;
      }

    }

    return true;
  }

  //TC: O(N) SC: O(1);

}
