package org.example.graph;

import java.util.*;

public class Node<T> implements Comparable<Node<T>> {

    private T value;
    private Set<Node<T>> neighbors;

    private Node<T> parent;

    public Node(T value){
        this.value = value;
        this.neighbors = new HashSet<>();
    }

    /**
     * Deep copy constructor, creates a new node with the same value and neighbors but no parent in different memory reference
     * @param node
     */
    public Node(Node<T> node){
        this.value = node.value;
        this.neighbors = new HashSet<>(node.neighbors);
    }

    public T getValue(){
        return this.value;
    }

    public Set<Node<T>> getNeighbors(){
        return new TreeSet<>(this.neighbors);
    }

    public void setParent(Node<T> node) {
        this.parent = node;
    }

    public Optional<Node<T>> getParent(){
        return Optional.ofNullable(this.parent);
    }

    public void connect(Node<T> node){
        if (this == node)
            throw new IllegalArgumentException("Un nodo intenta referenciarse a si mismo");
        this.neighbors.add(node);
        node.neighbors.add(this);
    }

    public String toString(){
        return this.value.toString();
    }

    /**
     * Compares two nodes only by their value, useful for collections based on Comparable interface
     * @param tNode
     * @return
     */
    @Override
    public int compareTo(Node<T> tNode) {
        return this.value.toString().compareTo(tNode.value.toString());
    }

    public String getParentPath(){
        if(parent == null){
            return this.value.toString();
        } else{
            return this.value.toString()+">-"+parent.getParentPath();
        }
    }

    /**
     * Compares two nodes only by their value, useful for collections and hashmaps
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node<?> node = (Node<?>) o;

        return value.equals(node.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
