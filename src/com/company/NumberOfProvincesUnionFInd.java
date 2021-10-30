package com.company;

import java.util.Arrays;

public class NumberOfProvincesUnionFInd {

   //TC: O(n2) (Since UnionFind is used compressed path and weights it's TC is O(a(n) which is close to O(1) in best case) SC: O(n)
   public int findCircleNum(int[][] isConnected) {
     if (isConnected == null || isConnected.length == 0) {
       return 0;
     }

     UnionFind unionFind  = new UnionFind(isConnected.length);

     for(int pointer = 0; pointer < isConnected.length; pointer++) {

       int[] cityConnections = isConnected[pointer];

       for(int cityConnectPointer = 0; cityConnectPointer < cityConnections.length; cityConnectPointer++) {
         if(cityConnections[cityConnectPointer] == 1) {
           unionFind.union(pointer, cityConnectPointer);
         }
       }
     }

     return unionFind.connectedCities();

   }



  class UnionFind {

    private final int[] cityConnections;
    private final int[] ranks;
    private int count;


    public UnionFind(int size) {
      cityConnections = new int[size];
      ranks = new int[size];

      for (int i = 0; i < size; i++) {
        cityConnections[i] = i;
        ranks[i] = 1;
      }

      count = size;

    }

    public int find(int city) {
      if(city == cityConnections[city]) {
        return city;
      }

      int connectedCity = cityConnections[city];

      return cityConnections[city] = find(connectedCity);
    }

    public void union(int cityOne, int cityTwo) {
      int cityOneRoot = find(cityOne);
      int cityTwoRoot = find(cityTwo);

      if(cityOneRoot != cityTwoRoot) {

        if(ranks[cityOneRoot] > ranks[cityTwoRoot]) {
          cityConnections[cityTwoRoot] = cityOneRoot;

        }else if(ranks[cityOneRoot] < ranks[cityTwoRoot]) {
          cityConnections[cityOneRoot] = cityTwoRoot;

        }else {
          cityConnections[cityTwoRoot] = cityOneRoot;
          ranks[cityOneRoot]++;
        }

        count--;
      }

    }

    public int connectedCities() {

      return count;
    }

    @Override
    public String toString(){
      return Arrays.toString(cityConnections);
    }
  }

}
