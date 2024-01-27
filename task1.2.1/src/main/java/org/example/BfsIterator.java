package org.example;

import java.util.*;

public class BfsIterator<T> implements Iterator<Node<T>> {
    public Node<T> myTree;
    public Queue<Node<T>> myQueue;
    private long expectedModificationCount;
    public BfsIterator(Node<T> tree){
        myQueue = new LinkedList<>();
        myQueue.add(tree);
        this.myTree=tree;
        this.expectedModificationCount = tree.getModificationCount();
    }

    @Override
    public boolean hasNext() {
        if (expectedModificationCount != myTree.getModificationCount()) {
            throw new ConcurrentModificationException();
        }
        return !this.myQueue.isEmpty();
    }
    @Override
    public Node<T> next(){
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        Node<T> next = this.myQueue.poll();
        if(next == null){
            return null;
        }else{
            this.myQueue.addAll(next.neighbours);
        }
        return next;
    }
}
