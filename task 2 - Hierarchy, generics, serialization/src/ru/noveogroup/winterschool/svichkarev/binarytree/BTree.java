package ru.noveogroup.winterschool.svichkarev.binarytree;

import java.util.Iterator;

import ru.noveogroup.winterschool.svichkarev.hierarhy.Parent;

/*
    Если хеш-коды разные, то и входные объекты гарантированно разные.
    Если хеш-коды равны, то входные объекты не всегда равны.
 */
public class BTree<T extends Parent> implements Iterable<T> {
    private Node<T> root = null;
    
    private static class Node<T>{
        private T value;
        private Node<T> left, right;
        
        public Node( T newValue ) {
            value = newValue;
        }
    }
    
    public void add( T value ) {
        //? проверка, что не null
        Node<T> tmpNode = root; //?
        Node<T> preNode = null; //?
        
        while( tmpNode != null ){
            int cmp = value.hashCode() - tmpNode.hashCode();
            if( cmp == 0 ){
                tmpNode.value = value;
                return;
            } else{
                preNode = tmpNode;
                if( cmp < 0 ){
                    tmpNode = tmpNode.left;
                } else{
                    tmpNode = tmpNode.right;
                }
            }
        }
        
        Node<T> newNode = new Node<T>( value );
        if( preNode == null ){
            root = newNode;
        } else{
            if( value.hashCode() < preNode.hashCode() ){
                preNode.left = newNode;
            } else{
                preNode.right = newNode;
            }
        }
    }

    public void remove( T value ){
        
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {

            @Override
            public boolean hasNext() {
                // TODO Auto-generated method stub
                return false;
            }

            @Override
            public T next() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public void remove() {
                // TODO Auto-generated method stub
                
            }
        };
        
        return it;
    }
    
    
}
