package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfProvincesBFS {

   //TC: O(n2) SC: O(n)
  public int findCircleNum(int[][] isConnected) {

    int numberOfProvinces = 0;
    int cities = isConnected.length;
    int[] visited = new int[cities];

    for(int cityPointer = 0; cityPointer < cities; cityPointer ++) {

      if(visited[cityPointer] == 0) {

        numberOfProvinces++;

        Queue<Integer> cityToBeVisited = new LinkedList<>();

        cityToBeVisited.add(cityPointer);

        while(!cityToBeVisited.isEmpty()) {

          int city = cityToBeVisited.poll();
          visited[city] = 1;
          int [] connections = isConnected[city];

          for(int connectionPointer = 0; connectionPointer < connections.length; connectionPointer++) {

            if(connections[connectionPointer] == 1 && visited[connectionPointer] == 0) {
              cityToBeVisited.add(connectionPointer);
            }

          }

        }

      }

    }

    return numberOfProvinces;
  }


}
