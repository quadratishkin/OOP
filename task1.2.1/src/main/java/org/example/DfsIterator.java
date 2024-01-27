package org.example;

import java.util.*;

public class DfsIterator<T> implements Iterator<Node<T>> {
    public Node<T> myTree;
    public Stack<Node<T>> myStack;
    private long expectedModificationCount;
    public DfsIterator(Node<T> tree){
        myStack = new Stack<>();
        myStack.push(tree);
        this.myTree=tree;
        this.expectedModificationCount = tree.getModificationCount();
    }

    @Override
    public boolean hasNext() {
        if (expectedModificationCount != myTree.getModificationCount()) {
            throw new ConcurrentModificationException();
        }
        return !this.myStack.isEmpty();
    }
    @Override
    public Node<T> next(){
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        Node<T> next = this.myStack.pop();
        if(next == null){
            return null;
        }else{
            for (int i = next.neighbours.size() - 1; i >= 0; i--) {
                myStack.push(next.neighbours.get(i));
            }
        }
        return next;
    }
}
