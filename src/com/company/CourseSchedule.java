package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {

  //TC: O(V*E) SC: O(V*E);

  public boolean canFinish(int numCourses, int[][] prerequisites) {

    if (prerequisites.length == 0) {
      return true;
    }

    int[] indegree = new int[numCourses];
    Queue<Integer> zeroDegrees = new LinkedList<>();

    countIndegreeForEachCourse(prerequisites, indegree);

    addCoursesWithNoPrerToQueue(indegree, zeroDegrees);

    //NO course has degrees (no connection between vertexes)
    if (zeroDegrees.isEmpty()) {
      return false;
    }

    //BFS across graph of courses deleting vertex with no in-degree edges and terminating connections with other vertexes
    while (!zeroDegrees.isEmpty()) {
      int course = zeroDegrees.poll();

      for (int[] prer : prerequisites) {

        if (prer[1] == course) {
          indegree[prer[0]]--;

          if (indegree[prer[0]] == 0) {
            zeroDegrees.add(prer[0]);
          }
        }
      }
    }

    for (int elem : indegree) {
      if (elem != 0) {
        return false;
      }
    }

    return true;

  }



  private void addCoursesWithNoPrerToQueue(int[] indegree, Queue<Integer> zeroDegrees) {
    for (int pointer = 0; pointer < indegree.length; pointer++) {

      if (indegree[pointer] == 0) {
        zeroDegrees.add(pointer);
      }

    }
  }

  private void countIndegreeForEachCourse(int[][] prerequisites, int[] indegree) {
    for (int[] prer : prerequisites) {

      indegree[prer[0]]++;

    }
  }

}
