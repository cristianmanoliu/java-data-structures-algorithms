package io.github.cristianmanoliu.datastructures.graph;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class GraphTest {

  @Test
  public void testAddVertex() {
    Graph graph = new Graph();

    // Test adding a new vertex
    assertTrue(graph.addVertex(1));
    assertTrue(graph.addVertex(2));

    // Test adding an existing vertex
    assertFalse(graph.addVertex(1));
  }

  @Test
  public void testAddEdge() {
    Graph graph = new Graph();
    graph.addVertex(1);
    graph.addVertex(2);
    graph.addVertex(3);
    graph.addVertex(4);

    // Test adding edges
    assertTrue(graph.addEdge(1, 2));
    assertTrue(graph.addEdge(1, 3));
    assertTrue(graph.addEdge(2, 4));
  }

}