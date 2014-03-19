package ru.noveogroup.winterschool.svichkarev.binarytree;

import java.util.Iterator;

import ru.noveogroup.winterschool.svichkarev.binarytree.exception.NodeNotFoundException;
import ru.noveogroup.winterschool.svichkarev.hierarhy.Parent;

public class BTree<T extends Parent> implements BTreeInterface<T>{
    private static final String ERROR_MESSAGE = "Null node found as argument";
    private static final long serialVersionUID = 7L;
    private Node<T> root;

    @Override
    public void add( T value ) throws IllegalArgumentException {
        if( value == null ){
            throw new IllegalArgumentException( ERROR_MESSAGE );
        }
        
        Node<T> tmpNode = root;
        Node<T> preNode = null;
        
        while( tmpNode != null ){
            int cmp = value.compareTo( tmpNode.getValue() );
            if( cmp == 0 ){
                // do not dublicate values in tree
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
            if( value.compareTo( preNode.getValue() ) < 0 ){
                preNode.setLeftNode(newNode);
            } else{
                preNode.setRightNode(newNode);
            }
        }
    }

    @Override
    public void remove( T value ) throws IllegalArgumentException, NodeNotFoundException{
        if( value == null ){
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        
        Node<T> tmpNode = root;
        Node<T> preNode = null;
        
        while( tmpNode != null ){
            int cmp = value.compareTo( tmpNode.getValue() );
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
        // if node is not in tree
        if( tmpNode == null ){
            throw new NodeNotFoundException();
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
                preNode.setLeftNode(leftMost.getRightNode());
            } else{
                tmpNode.setRightNode(leftMost.getRightNode());
            }
            tmpNode.setValue(leftMost.getValue());
        }
    }

    @Override
    public Iterator<T> iterator() {
        // our iterator
        return new BTreeIterator<T>( root );
    }

    @Override
    public int countLeafs() {
        return root == null ? 0 : root.countNodeLeafs();
    }
}
