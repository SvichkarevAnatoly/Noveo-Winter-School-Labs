package ru.noveogroup.winterschool.svichkarev.binarytree;

import java.io.Serializable;
import java.util.Iterator;

import ru.noveogroup.winterschool.svichkarev.binarytree.exception.NodeNotFoundException;
import ru.noveogroup.winterschool.svichkarev.binarytree.exception.NullNodeFoundException;

public interface BTreeInterface<T> extends Iterable<T>, Serializable {
    void add( T value ) throws NullNodeFoundException;
    
    void remove( T value ) throws NullNodeFoundException, NodeNotFoundException;
    
    int countLeafs();
    
    Iterator<T> iterator();
}
