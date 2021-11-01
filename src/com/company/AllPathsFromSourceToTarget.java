package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AllPathsFromSourceToTarget {

  //TC: O(2^n-1 * N) SC: O(2^n-1 * N)
  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {


    List<List<Integer>> result = new ArrayList<>();
    Integer destinationNode = graph.length - 1;

    Queue<LinkedList<Integer>> queue = new LinkedList<>();

    LinkedList<Integer> path = new LinkedList<>();
    path.add(0);

    queue.add(path);

    while(!queue.isEmpty()) {

      LinkedList<Integer> currPath = queue.poll();
      Integer currNode = currPath.getLast();

      if(!currNode.equals(destinationNode)) {

        for(Integer nextNode: graph[currNode]) {

          LinkedList<Integer> currPathCopy = new LinkedList<>(currPath);
          currPathCopy.add(nextNode);
          queue.add(currPathCopy);
        }

      } else {
        result.add(currPath);
      }

    }


    return result;
  }

}
