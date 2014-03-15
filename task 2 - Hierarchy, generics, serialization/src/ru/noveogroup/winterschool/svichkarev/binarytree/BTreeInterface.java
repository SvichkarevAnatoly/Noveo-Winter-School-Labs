package ru.noveogroup.winterschool.svichkarev.binarytree;

import java.util.Iterator;

import ru.noveogroup.winterschool.svichkarev.binarytree.exception.NodeNotFoundException;
import ru.noveogroup.winterschool.svichkarev.binarytree.exception.NullNodeFoundException;

public interface BTreeInterface<T> extends Iterable<T> {
    public void add( T value ) throws NullNodeFoundException;
    
    public void remove( T value ) throws NullNodeFoundException, NodeNotFoundException;
    
    public Iterator<T> iterator();
}
