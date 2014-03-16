package ru.noveogroup.winterschool.svichkarev.binarytree;

import java.util.Iterator;

import ru.noveogroup.winterschool.svichkarev.binarytree.exception.NodeNotFoundException;
import ru.noveogroup.winterschool.svichkarev.binarytree.exception.NullNodeFoundException;
import ru.noveogroup.winterschool.svichkarev.hierarhy.Parent;

public class BTree<T extends Parent> implements BTreeInterface<T>{
    private static final long serialVersionUID = 7L;
    private Node<T> root = null;
    
    public void add( T value ) throws NullNodeFoundException {
        if( value == null ){
            throw new NullNodeFoundException();
        }
        
        Node<T> tmpNode = root;
        Node<T> preNode = null;
        
        while( tmpNode != null ){
            /*  Если хеш-коды разные, то и входные объекты гарантированно разные.
            Если хеш-коды равны, то входные объекты не всегда равны.*/
            int cmp = value.hashCode() - tmpNode.getValue().hashCode();
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
            if( value.hashCode() < preNode.getValue().hashCode() ){
                preNode.setLeftNode(newNode);
            } else{
                preNode.setRightNode(newNode);
            }
        }
    }

    public void remove( T value ) throws NullNodeFoundException, NodeNotFoundException{
        if( value == null ){
            throw new NullNodeFoundException();
        }
        
        Node<T> tmpNode = root;
        Node<T> preNode = null;
        
        while( tmpNode != null ){
            int cmp = value.hashCode() - tmpNode.getValue().hashCode();
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
