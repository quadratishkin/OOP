package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Node<T> implements Iterable<Node<T>> {
    private T value;
    private Node<T> pid;
    public List<Node <T>> neighbours;
    private long modificationCount;

    public Node(T value, Node<T> pid) {
        this.pid = pid;
        this.modificationCount = 0;
        this.neighbours = new ArrayList();
        this.value = value;
    }
    public Node<T> addNode(T value){
        incModificationCount();
        Node<T> neighbour = new Node(value, this);
        this.neighbours.add(neighbour);
        return neighbour;
    }

    public void deleteNode(){
        incModificationCount();
        if(this.pid != null){
            this.pid.neighbours.remove(this);
        }
        this.pid = null;
        this.value = null;
    }

    public void setValue(T value){
        this.value = value;
    }
    public T getValue() {
        return value;
    }

    public Node<T> getPid() {
        return pid;
    }

    public long getModificationCount() {
        return modificationCount;
    }
    private void incModificationCount() {
        modificationCount++;
        if (pid != null) {
            pid.incModificationCount();
        }
    }

    public Iterator<Node<T>> dfsIterator() {
        return new DfsIterator<T>(this);
    }
    public Iterator<Node<T>> bfsIterator() {
        return new BfsIterator<T>(this);
    }

    @Override
    public Iterator<Node<T>> iterator() {
        //return new BfsIterator<T>(this);
        return new DfsIterator<>(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Node<?> someTree = (Node<?>) obj;

        if (!value.equals(someTree.value)) {
            return false;
        }

        if (neighbours.size() != someTree.neighbours.size()) {
            return false;
        }

        for (int i = 0; i < this.neighbours.size(); i++) {
            if (!this.neighbours.get(i).equals(someTree.neighbours.get(i))) {
                return false;
            }
        }

        return true;
    }
}
