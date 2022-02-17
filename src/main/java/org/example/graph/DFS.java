package org.example.graph;

import java.util.*;

public class DFS {

    public static<T> String search(Node<T> start, T goal) {
        Stack<Node<T>> stack = new Stack<>();
        stack.push(start);

        Node<T> currentNode;
        Set<Node<T>> closed = new HashSet<>();

        // Can I continue expanding?
        while (!stack.isEmpty()) {

            currentNode = stack.pop();
            System.out.print(currentNode.getValue());

            // if im on Goal
            if (currentNode.getValue().equals(goal)) {
                StringBuilder result = new StringBuilder();
                result.append(currentNode.getParentPath());
                return result.reverse().toString();
            } else {
                closed.add(currentNode); // explored items

                List<Node<T>> neighbors = new ArrayList<>(currentNode.getNeighbors());
                Collections.sort(neighbors, Collections.reverseOrder());

                for (Node<T> node: neighbors) {
                    var newNode = new Node<>(node);
                    newNode.setParent(currentNode);
                    stack.add(newNode);
                }
                stack.removeAll(closed);
            }
        }

        return "";
    }
}
