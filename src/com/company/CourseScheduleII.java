package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleII {

  //TC: O(Vertex + Edges) SC: O(Vertex + Edges)
  public int[] findOrder(int numCourses, int[][] prerequisites) {

    int[] emptyResult = new int[numCourses];

    if (numCourses == 0) {
      return emptyResult;
    }

    if (prerequisites == null || prerequisites.length == 0) {
      for (int i = 0; i < numCourses; i++) {
        emptyResult[i] = i;
      }
      return emptyResult;
    }

    int[] indegree = new int[numCourses];
    Queue<Integer> zeroDegrees = new LinkedList<>();
    Queue<Integer> result = new LinkedList<>();

    countIndegreeForEachCourse(prerequisites, indegree);

    addCoursesWithNoPrerToQueue(indegree, zeroDegrees);

    //No course has no degrees (no connection between vertexes)
    if (zeroDegrees.isEmpty()) {
      return new int[0];
    }

    //BFS across graph of courses deleting vertex with no in-degree edges and terminating connections with other vertexes
    while (!zeroDegrees.isEmpty()) {
      int course = zeroDegrees.poll();
      result.add(course);

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
        return new int[0];
      }
    }

    return result.stream().mapToInt(Integer::intValue).toArray();


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
