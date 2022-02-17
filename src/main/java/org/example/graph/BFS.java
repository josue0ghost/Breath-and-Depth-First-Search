package org.example.graph;

import java.util.*;

public class BFS<T> {

    public static<T> String search(Node<T> start, T goal) {
        Queue<Node<T>> queue = new ArrayDeque<>();
        queue.add(start);

        Node<T> currentNode;
        Set<Node<T>> closed = new HashSet<>();

        // Can I continue expanding?
        while (!queue.isEmpty()) {
            // metodo de desempate lexicografico ?????
            // como saber el nodo que tenga menor altura???
            currentNode = queue.remove();
            System.out.print(currentNode.getValue());

            // if im on Goal
            if (currentNode.getValue().equals(goal)) {
                StringBuilder result = new StringBuilder();
                result.append(currentNode.getParentPath());
                return result.reverse().toString();
            } else {
                closed.add(currentNode); // explored items
                var neighbors = currentNode.getNeighbors();

                for (Node<T> node: neighbors) {
                    var newNode = new Node<>(node);
                    newNode.setParent(currentNode);
                    queue.add(newNode);
                }
                queue.removeAll(closed);
            }
        }

        return "";
    }
}
