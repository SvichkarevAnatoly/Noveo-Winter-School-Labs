package ru.noveogroup.winterschool.svichkarev.binarytree;

import java.util.Iterator;

public interface BTreeInterface<T> extends Iterable<T> {
    public void add( T value );
    
    public void remove( T value );
    
    public Iterator<T> iterator();
}
