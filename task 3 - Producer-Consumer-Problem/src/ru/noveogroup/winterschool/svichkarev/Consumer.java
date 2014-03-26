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
            if( Thread.interrupted() ){
                return;
            }
            item = buffer.removeItem();
            consumeItem( item );
        }
    }

    private void consumeItem(E item) {
        if( item == null ){
            System.out.println( "Consumer: Item is null" );
            return;
        }
        System.out.println( "Consumer: consume Item " + item.toString() );
    }

}
