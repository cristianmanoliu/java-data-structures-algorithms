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

  @Test
  public void removeEdge() {
    Graph graph = new Graph();
    graph.addVertex(1);
    graph.addVertex(2);
    graph.addVertex(3);
    graph.addVertex(4);

    graph.addEdge(1, 2);
    graph.addEdge(1, 3);
    graph.addEdge(2, 4);

    // Test removing edges
    assertTrue(graph.removeEdge(1, 2));
    assertFalse(graph.removeEdge(9, 99)); // Vertex and edges does not exist
    assertTrue(graph.removeEdge(2, 4));
  }

  @Test
  public void removeVertex() {
    Graph graph = new Graph();
    graph.addVertex(1);
    graph.addVertex(2);
    graph.addVertex(3);
    graph.addVertex(4);

    graph.addEdge(1, 2);
    graph.addEdge(1, 3);
    graph.addEdge(2, 4);

    // Test removing vertex
    assertTrue(graph.removeVertex(2));
    assertFalse(graph.removeVertex(9));
  }

}