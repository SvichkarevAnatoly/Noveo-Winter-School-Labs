package ru.noveogroup.winterschool.svichkarev.binarytree;

class Node<T>{
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

    public int countNodeLeafs() {
        // in correct tree it's impossible, only if both equals null
        if( left == right ){
            return 1;
        }
        
        return ((left == null)? 0 : left.countNodeLeafs()) +
               ((right == null)? 0 : right.countNodeLeafs()) ;
    }
}
