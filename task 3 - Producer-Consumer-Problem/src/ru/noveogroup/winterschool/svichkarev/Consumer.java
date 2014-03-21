package ru.noveogroup.winterschool.svichkarev;

public class Consumer<E> implements Runnable {
    private Buffer<E> buffer;
    
    public Consumer( Buffer<E> producerBuffer ){
        buffer = producerBuffer;
        System.out.println( "Consumer ready!" );
    }
    
    @Override
    public void run(){
        E item;
        while( true ){
            item = buffer.removeItem();
            consumItem( item );
        }
    }

    private void consumItem(E item) {
        System.out.println( "Consumer: consumItem" );
    }

}
