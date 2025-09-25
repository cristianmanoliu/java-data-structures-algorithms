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
import java.util.Stack;

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
  public List<Integer> bfs(int start) {
    List<Integer> output = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();
    Queue<Integer> queue = new LinkedList<>();
    visited.add(start);
    queue.offer(start);
    while (!queue.isEmpty()) {
      int node = queue.poll();
      output.add(node);
      for (int neighbor : this.adjList.getOrDefault(node, Collections.emptyList())) {
        if (!visited.contains(neighbor)) {
          visited.add(neighbor);
          queue.offer(neighbor);
        }
      }
    }
    return output;
  }

  /**
   * Depth-First Search (DFS) traversal from a starting node. Using recursion.
   *
   * @param start the starting node
   */
  public List<Integer> dfsRecursion(int start) {
    List<Integer> output = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();
    dfsRecursionHelper(start, visited, output);
    return output;
  }

  /**
   * Helper method for DFS traversal.
   */
  private void dfsRecursionHelper(int node, Set<Integer> visited, List<Integer> output) {
    visited.add(node);
    output.add(node);
    for (int neighbor : this.adjList.getOrDefault(node, Collections.emptyList())) {
      if (!visited.contains(neighbor)) {
        dfsRecursionHelper(neighbor, visited, output);
      }
    }
  }


  /**
   * Depth-First Search (DFS) traversal from a starting node. Iterative approach.
   *
   * @param start the starting node
   */
  public List<Integer> dfsIterative(int start) {
    List<Integer> output = new ArrayList<>();

    Set<Integer> visited = new HashSet<>();
    Stack<Integer> stack = new Stack<>();

    // Start with the initial node
    stack.push(start);

    while (!stack.isEmpty()) {
      int node = stack.pop();

      // Process the node only if not visited
      if (!visited.contains(node)) {
        visited.add(node);
        output.add(node);

        // Push neighbors on stack in reverse order
        // so the first neighbor is processed first
        List<Integer> neighbors = this.adjList.getOrDefault(node, Collections.emptyList());
        for (int i = neighbors.size() - 1; i >= 0; i--) {
          int neighbor = neighbors.get(i);
          if (!visited.contains(neighbor)) {
            stack.push(neighbor);
          }
        }
      }
    }
    return output;
  }
}
