package io.github.cristianmanoliu.datastructures.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}
