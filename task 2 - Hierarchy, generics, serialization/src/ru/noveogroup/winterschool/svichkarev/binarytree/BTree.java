package ru.noveogroup.winterschool.svichkarev.binarytree;

import java.util.Iterator;
import java.util.jar.JarException;

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
        Node<T> tmpNode = root;
        Node<T> preNode = null;
        
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
      //? проверка, что не null
        Node<T> tmpNode = root;
        Node<T> preNode = null;
        
        while( tmpNode != null ){
            int cmp = value.hashCode() - tmpNode.hashCode();
            if( cmp == 0 ){
                break;
            } else{
                preNode = tmpNode;
                if( cmp < 0 ){
                    tmpNode = tmpNode.left;
                } else{
                    tmpNode = tmpNode.right;
                }
            }
        }
        // if empty tree
        if( tmpNode == null ){
            return;
        }
        
        if( tmpNode.right == null ){
            // if right subtree is empty
            if( preNode == null ){
                // if tmpNode == root
                root = tmpNode.left;
            } else{
                if( tmpNode == preNode.left ){
                    // tmpNode in left subtree of preNode
                    preNode.left = tmpNode.left;
                } else{
                    // tmpNode in right subtree of preNode
                    preNode.right = tmpNode.left;
                }
            }
        } else{
            // find in right subtree the biggest element
            Node<T> leftMost = tmpNode.right;
            preNode = null;
            while( leftMost.left != null ){
                preNode = leftMost;
                leftMost = leftMost.left;
            }
            if( preNode != null ){
                preNode.left = leftMost.right; //?
            } else{
                tmpNode.right = leftMost.right; //?
            }
            tmpNode.value = leftMost.value;
        }
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {
            private Node<T> currentNode = null;
            
            @Override
            public boolean hasNext() {
                // TODO
                
                return false;
            }

            @Override
            public T next() {
                if( ! hasNext() ){
                    throw new java.util.NoSuchElementException( "no more elements" );
                }
                // TODO
                return null;
            }

            @Override
            public void remove() {
                throw new java.lang.UnsupportedOperationException( "remove" );
            }
        };
        
        return it;
    }
    
    
}
