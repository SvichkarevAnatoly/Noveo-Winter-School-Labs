package ru.noveogroup.winterschool.svichkarev.binarytree;

import java.util.Iterator;
import ru.noveogroup.winterschool.svichkarev.hierarhy.Parent;

/*
    Если хеш-коды разные, то и входные объекты гарантированно разные.
    Если хеш-коды равны, то входные объекты не всегда равны.
 */
public class BTree<T extends Parent> implements Iterable<T> {
    private Node<T> root = null;
    
    public void add( T value ) {
        //? проверка, что не null
        Node<T> tmpNode = root;
        Node<T> preNode = null;
        
        while( tmpNode != null ){
            int cmp = value.hashCode() - tmpNode.hashCode();
            if( cmp == 0 ){
                tmpNode.setValue(value);
                return;
            } else{
                preNode = tmpNode;
                if( cmp < 0 ){
                    tmpNode = tmpNode.getLeftNode();
                } else{
                    tmpNode = tmpNode.getRightNode();
                }
            }
        }
        
        Node<T> newNode = new Node<T>( value );
        if( preNode == null ){
            root = newNode;
        } else{
            if( value.hashCode() < preNode.hashCode() ){
                preNode.setLeftNode(newNode);
            } else{
                preNode.setRightNode(newNode);
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
                    tmpNode = tmpNode.getLeftNode();
                } else{
                    tmpNode = tmpNode.getRightNode();
                }
            }
        }
        // if empty tree
        if( tmpNode == null ){
            return;
        }
        
        if( tmpNode.getRightNode() == null ){
            // if right subtree is empty
            if( preNode == null ){
                // if tmpNode == root
                root = tmpNode.getLeftNode();
            } else{
                if( tmpNode == preNode.getLeftNode() ){
                    // tmpNode in left subtree of preNode
                    preNode.setLeftNode(tmpNode.getLeftNode());
                } else{
                    // tmpNode in right subtree of preNode
                    preNode.setRightNode(tmpNode.getLeftNode());
                }
            }
        } else{
            // find in right subtree the biggest element
            Node<T> leftMost = tmpNode.getRightNode();
            preNode = null;
            while( leftMost.getLeftNode() != null ){
                preNode = leftMost;
                leftMost = leftMost.getLeftNode();
            }
            if( preNode != null ){
                preNode.setLeftNode(leftMost.getRightNode()); //?
            } else{
                tmpNode.setRightNode(leftMost.getRightNode()); //?
            }
            tmpNode.setValue(leftMost.getValue());
        }
    }

    @Override
    public Iterator<T> iterator() {
        // our iterator
        return new BTreeIterator<T>( root );
    }
    
    // for testing
    @Override
    public String toString() {
        String result = "";
        
        Iterator<T> it = iterator();
        for (T el : this) {
            //result += node.toString() + "(" + toString( el.getLeft() ) + ", " +
            //        toString(node.getRight()) + ")";
        }
        
        return result;
    }
}
