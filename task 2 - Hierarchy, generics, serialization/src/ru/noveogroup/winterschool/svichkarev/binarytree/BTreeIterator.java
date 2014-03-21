package ru.noveogroup.winterschool.svichkarev.binarytree;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Deque;

// http://www2.hawaii.edu/~esb/2010spring.ics211/TreeIterator.java.html
public final class BTreeIterator<T> implements Iterator<T> {
    final static String ERROR_NO_MORE_ELEMENTS = "no more elements";
    final static String ERROR_REMOVE_UNSUPPORTED = "remove";
    
    Node<T> root = null;
    /* the class variables keep track of how much the iterator
     * has done so far, and what remains to be done.
     * root is null when the iterator has not been initialized,
     * or the entire tree has been visited.
     * the first stack keeps track of the last node to return
     * and all its ancestors
     * the second stack keeps track of whether the node visited
     * is to the left (false) or right (true) of its parent
     */
    private Deque<Node<T>> visiting;
    public BTreeIterator( Node<T> treeRoot ){
        this.root = treeRoot;
        visiting = new ArrayDeque<Node<T>>();
    }
    
    /* find the leftmost node from this root, pushing all the
     * intermediate nodes onto the visiting stack
     * @param   node the root of the subtree for which we
     *      are trying to reach the leftmost node
     * @changes visiting takes all nodes between node and the leftmost
     */
    private void pushLeftmostNode(Node<T> node) {
        // find the leftmost node
        if (node != null) {
            visiting.addFirst(node); // push this node
            pushLeftmostNode(node.getLeftNode()); // recurse on next left node
        }
    }
    
    /* return the leftmost node that has not yet been visited
     * that node is normally on top of the stack
     * inorder traversal doesn't use the visitingRightChild stack
     */
    private T inorderNext() {
        if (visiting.isEmpty()) { // at beginning of iterator
            // find the leftmost node, pushing all the intermediate nodes
            // onto the visiting stack
            pushLeftmostNode(root);
        } // now the leftmost unvisited node is on top of the visiting stack
        Node<T> node = visiting.removeFirst();
        T result = node.getValue(); // this is the value to return
        // if the node has a right child, its leftmost node is next
        if (node.getRightNode() != null) {
            Node<T> right = node.getRightNode();
            // find the leftmost node of the right child
            pushLeftmostNode (right);
            // note "node" has been replaced on the stack by its right child
        } // else: no right subtree, go back up the stack
          // next node on stack will be next returned
        if (visiting.isEmpty()) { // no next node left
            root = null;
        }
        return result;
    }

    @Override
    public boolean hasNext() {
        return (root != null);
    }

    @Override
    public T next() {
        if (! hasNext()) {
            throw new java.util.NoSuchElementException( ERROR_NO_MORE_ELEMENTS );
        }
        
        return inorderNext();
    }

    /* not implemented */
    @Override
    public void remove() {
        throw new java.lang.UnsupportedOperationException( ERROR_REMOVE_UNSUPPORTED );
    }
    
}