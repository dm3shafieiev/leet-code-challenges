package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms2 {
  public int minMeetingRooms(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt(intr -> intr[0]));

    PriorityQueue<Integer> roomBlockedUntil = new PriorityQueue<>(Comparator.comparingInt(intr -> intr));

    roomBlockedUntil.add(intervals[0][1]);

    for(int pointer = 1; pointer < intervals.length; pointer++) {

      int[] meeting = intervals [pointer];
      int meetingStart = meeting[0];
      int meetingEnd = meeting[1];

      if(meetingStart >= roomBlockedUntil.peek()) {
        roomBlockedUntil.poll();
      }

      roomBlockedUntil.add(meetingEnd);
    }

    return roomBlockedUntil.size();
  }

  //TC: nlogN SC: O(n)
}
