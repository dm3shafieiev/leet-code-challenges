package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {

  public static final int[][] DIRECTIONS = new int[][]{new int[]{-1, -1}, new int[]{-1, 0},
      new int[]{-1, 1},
      new int[]{0, -1}, new int[]{0, 1}, new int[]{1, -1}, new int[]{1, 0}, new int[]{1, 1}};

  public int shortestPathBinaryMatrix(int[][] grid) {

    if (grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1) {
      return -1;
    }

    if (grid.length == 1 && grid[0].length == 1) {
      return 1;
    }

    int[][] visited = new int[grid.length][grid[0].length];

    Queue<int[]> queue = new LinkedList<>();

    queue.add(new int[]{0, 0, 0});
    visited[0][0] = 1;

    while (!queue.isEmpty()) {

      int[] cell = queue.poll();

      int cellRow = cell[0];
      int cellColumn = cell[1];
      int stepCount = cell[2] + 1;

      if (cellRow == grid.length - 1 && cellColumn == grid[0].length - 1) {
        return stepCount;
      }
      visitAllAdjacentCells(grid, queue, visited, cell );

    }

    return -1;
  }

  private void visitAllAdjacentCells(int[][] grid, Queue<int[]> queue,
      int[][] visited, int[] cell) {

    int cellRow = cell[0];
    int cellColumn = cell[1];
    int stepCount = cell[2] + 1;

    int rowsCount = grid.length;
    int columnsCount = grid[0].length;

    for (int pointer = 0; pointer < ShortestPathInBinaryMatrix.DIRECTIONS.length; pointer++) {

      int rowDirectChange = ShortestPathInBinaryMatrix.DIRECTIONS[pointer][0];
      int columnDirectChange = ShortestPathInBinaryMatrix.DIRECTIONS[pointer][1];

      boolean isRowInARange = (cellRow + rowDirectChange) >= 0;
      boolean isColumnInARange = (cellColumn + columnDirectChange) >= 0;
      boolean isRowNotOverflow = (cellRow + rowDirectChange) < rowsCount;
      boolean isColumnNotOverflow = (cellColumn + columnDirectChange) < columnsCount;

      if (isRowInARange && isRowNotOverflow && isColumnInARange && isColumnNotOverflow
          && visited[cellRow + rowDirectChange][cellColumn + columnDirectChange] != 1
          && grid[cellRow + rowDirectChange][cellColumn + columnDirectChange] != 1) {

        queue.add(new int[]{cellRow + rowDirectChange,
            cellColumn + columnDirectChange, stepCount});
        visited[cellRow + rowDirectChange][cellColumn + columnDirectChange] = 1;

      }

    }
  }

}
