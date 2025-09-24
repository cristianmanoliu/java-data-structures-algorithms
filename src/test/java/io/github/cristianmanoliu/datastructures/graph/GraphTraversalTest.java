package io.github.cristianmanoliu.datastructures.graph;

import org.junit.jupiter.api.Test;

class GraphTraversalTest {

  @Test
  public void testBFSvsDFS() {
    // Sample graph structure:
    //     1
    //    / \
    //   2   3
    //   |    \
    //   4     5
    GraphTraversal graph = new GraphTraversal();
    graph.addEdge(1, 2);
    graph.addEdge(1, 3);
    graph.addEdge(2, 4);
    graph.addEdge(3, 5);

    System.out.print("BFS starting from node 1: ");
    graph.bfs(1); // Expected output: 1 2 3 4 5
    System.out.println();

    System.out.print("DFS starting from node 1: ");
    graph.dfs(1); // Expected output: 1 2 4 3 5
    System.out.println();
  }

}