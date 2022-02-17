package org.example;

import org.example.graph.BFS;
import org.example.graph.DFS;
import org.example.graph.Node;

public class PathFinder<T> {

    public String exploreBFS(Node<T> start, T goal) {
        return BFS.search(start, goal);
    }

    public String exploreDFS(Node<T> start, T goal) {
        return DFS.search(start, goal);
    }
}
