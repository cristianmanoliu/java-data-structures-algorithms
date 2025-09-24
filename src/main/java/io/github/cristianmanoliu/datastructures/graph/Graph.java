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

  public boolean addVertex(int vertex, List<Integer> edges) {
    if (adjList.containsKey(vertex)) {
      return false;
    }
    adjList.put(vertex, edges);
    return true;
  }
}
