package io.github.cristianmanoliu.misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class GraphTraversal {

  private final Map<Integer, List<Integer>> graph;

  public GraphTraversal() {
    graph = new HashMap<>();
  }

  /**
   * Adds an undirected edge between two nodes in the graph.
   *
   * @param u one endpoint of the edge
   * @param v the other endpoint of the edge
   */
  public void addEdge(int u, int v) {
    graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
    graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
  }

  /**
   * Breadth-First Search (BFS) traversal from a starting node.
   *
   * @param start the starting node
   */
  public void bfs(int start) {
    Set<Integer> visited = new HashSet<>();
    Queue<Integer> queue = new LinkedList<>();
    visited.add(start);
    queue.offer(start);
    while (!queue.isEmpty()) {
      int node = queue.poll();
      System.out.print(node + " ");
      for (int neighbor : graph.getOrDefault(node, Collections.emptyList())) {
        if (!visited.contains(neighbor)) {
          visited.add(neighbor);
          queue.offer(neighbor);
        }
      }
    }
  }

  /**
   * Depth-First Search (DFS) traversal from a starting node.
   *
   * @param start the starting node
   */
  public void dfs(int start) {
    Set<Integer> visited = new HashSet<>();
    dfsHelper(start, visited);
  }

  /**
   * Helper method for DFS traversal.
   */
  private void dfsHelper(int node, Set<Integer> visited) {
    visited.add(node);
    System.out.print(node + " ");
    for (int neighbor : graph.getOrDefault(node, Collections.emptyList())) {
      if (!visited.contains(neighbor)) {
        dfsHelper(neighbor, visited);
      }
    }
  }
}

