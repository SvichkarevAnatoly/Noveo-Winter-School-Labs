package ru.noveogroup.winterschool.svichkarev.binarytree;

import java.io.Serializable;

class Node<T> implements Serializable{
    private static final long serialVersionUID = 7L;
    private T value;
    private Node<T> left, right;
    
    public Node( T newValue ) {
        setValue(newValue);
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getLeftNode() {
        return left;
    }

    public void setLeftNode(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRightNode() {
        return right;
    }

    public void setRightNode(Node<T> right) {
        this.right = right;
    }
}
