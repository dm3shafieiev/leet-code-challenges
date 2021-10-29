package com.company;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.function.ToDoubleFunction;

public class ClosesKPoint {

  public int[][] kClosest(int[][] points, int k) {

    ToDoubleFunction<int[]> calcCoord = coordinates -> Math.sqrt(
        Math.pow(coordinates[0], 2) + Math.pow(coordinates[1], 2));

    PriorityQueue<int[]> queue = new PriorityQueue<>(k,
        Comparator.comparingDouble(calcCoord).reversed());

    for (int pointer = 0; pointer < k; pointer++) {
      queue.add(points[pointer]);
    }

    for (int pointer = k; pointer < points.length; pointer++) {

      double dist = calcCoord.applyAsDouble(points[pointer]);
      double maxDistFromHeap = calcCoord.applyAsDouble(queue.peek());

      if (dist < maxDistFromHeap) {
        queue.poll();
        queue.add(points[pointer]);
      }
    }

    return queue.toArray(new int[k][]);
  }

}

