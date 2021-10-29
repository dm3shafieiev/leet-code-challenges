package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

  public int numIslands(char[][] grid) {
    if(grid == null || grid.length == 0) {
      return 0;
    }

    int numberOfRows = grid.length;
    int numberOfColumns = grid[0].length;
    int numberOfIslands = 0;

    for(int rowPointer = 0; rowPointer < numberOfRows; rowPointer++) {

      for(int columnPointer = 0; columnPointer < numberOfColumns; columnPointer++) {

        if(grid[rowPointer][columnPointer] == '1') {

          numberOfIslands++;
          grid[rowPointer][columnPointer] = '0';

          Queue<int[]> adjacentCells = new LinkedList<>();
          adjacentCells.add(new int [] {rowPointer, columnPointer});

          while(!adjacentCells.isEmpty()) {

            int [] coordinates = adjacentCells.poll();
            int rowIndex = coordinates[0];
            int columnIndex = coordinates[1];


            //check cell above
            if(rowIndex - 1 >= 0 && grid[rowIndex - 1][columnIndex] == '1') {
              adjacentCells.add(new int [] {rowIndex - 1, columnIndex});
              grid[rowIndex - 1][columnIndex] = '0';
            }
            //check down below
            if(rowIndex + 1 < numberOfRows && grid[rowIndex + 1][columnIndex] == '1') {
              adjacentCells.add(new int [] {rowIndex + 1, columnIndex});
              grid[rowIndex + 1][columnIndex] = '0';
            }
            //check cell from right side
            if(columnIndex - 1 >= 0 && grid[rowIndex][columnIndex - 1] == '1') {
              adjacentCells.add(new int [] {rowIndex, columnIndex - 1});
              grid[rowIndex][columnIndex - 1] = '0';
            }
            //check cell from left side
            if(columnIndex + 1 < numberOfColumns && grid[rowIndex][columnIndex + 1] == '1') {
              adjacentCells.add(new int [] {rowIndex, columnIndex + 1});
              grid[rowIndex][columnIndex + 1] = '0';

            }
          }
        }
      }



    }
    return numberOfIslands;
  }

  // TC: O(M * N), SC: O(M || N) (min from M || N)

}
