package ru.noveogroup.winterschool.svichkarev;

public class Buffer<E> {
    private E element;

    public E removeItem() {
        return element;
    }

    public void putItem( E item ) {
        element = item;
    }
}
