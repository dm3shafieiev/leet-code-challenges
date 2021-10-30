package com.company;

public class NumberofConnectedComponentsInAnUndirectedGraph {

  //TC: O(n * a(n) SC: O(n)
  public int countComponents(int n, int[][] edges) {

    UnionFind unionFind = new UnionFind(n);

    for (int pointer = 0; pointer < edges.length; pointer++) {

      int[] connection = edges[pointer];
      unionFind.union(connection[0], connection[1]);

    }

    return unionFind.count;

  }

  class UnionFind {

    private int[] root;
    private int[] rank;
    public int count;

    public UnionFind(int size) {
      root = new int[size];
      rank = new int[size];
      for (int i = 0; i < size; i++) {
        root[i] = i;
        rank[i] = 1;
      }
      count = size;
    }

    public int find(int x) {
      if (x == root[x]) {
        return x;
      }
      return root[x] = find(root[x]);
    }

    public void union(int x, int y) {
      int rootX = find(x);
      int rootY = find(y);
      if (rootX != rootY) {
        if (rank[rootX] > rank[rootY]) {
          root[rootY] = rootX;
        } else if (rank[rootX] < rank[rootY]) {
          root[rootX] = rootY;
        } else {
          root[rootY] = rootX;
          rank[rootX] += 1;
        }

        count--;
      }
    }




    public boolean isConnected(int x, int y) {
      return find(x) == find(y);
    }

  }
}
