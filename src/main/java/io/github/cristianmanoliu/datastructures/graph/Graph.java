package io.github.cristianmanoliu.datastructures.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Graph {

  private final Map<Integer, List<Integer>> adjList = new HashMap<>();

  public boolean addVertex(int vertex) {
    if (adjList.containsKey(vertex)) {
      return false;
    }
    adjList.put(vertex, new ArrayList<>());
    return true;
  }

  public boolean addEdge(int vertex1, int vertex2) {
    if (adjList.containsKey(vertex1) && adjList.containsKey(vertex2)) {
      adjList.get(vertex1).add(vertex2);
      adjList.get(vertex2).add(vertex1); // For undirected graph
      return true;
    }
    return false;
  }

  public boolean removeEdge(int vertex1, int vertex2) {
    if (adjList.containsKey(vertex1) && adjList.containsKey(vertex2)) {
      adjList.get(vertex1).remove(Integer.valueOf(vertex2));
      adjList.get(vertex2).remove(Integer.valueOf(vertex1)); // For undirected graph
      return true;
    }
    return false;
  }

  public boolean removeVertex(int vertex) {
    if (!adjList.containsKey(vertex)) {
      return false;
    }
    List<Integer> neighbors = adjList.get(vertex);
    for (Integer neighbor : neighbors) {
      adjList.get(neighbor).remove(Integer.valueOf(vertex));
    }
    adjList.remove(vertex);
    return true;
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
      for (int neighbor : this.adjList.getOrDefault(node, Collections.emptyList())) {
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
    for (int neighbor : this.adjList.getOrDefault(node, Collections.emptyList())) {
      if (!visited.contains(neighbor)) {
        dfsHelper(neighbor, visited);
      }
    }
  }


}
