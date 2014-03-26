package ru.noveogroup.winterschool.svichkarev;

import java.util.concurrent.Semaphore;

public class Buffer<E> {
    private E element;
    
    private Semaphore fillCount = new Semaphore( 0 );
    private Semaphore emptyCount = new Semaphore( 1 );

    public E removeItem() {
        try {
            fillCount.acquire();
        } catch (InterruptedException e) {
            return null;
        }
        E removeEl = element;
        emptyCount.release();
        
        return removeEl;
    }

    public void putItem( E item ) {
        try {
            emptyCount.acquire();
        } catch (InterruptedException e) {
            return;
        }
        element = item;
        fillCount.release();
    }
}
