package ru.noveogroup.winterschool.svichkarev;

public class Producer<E> implements Runnable {
    private Buffer<E> buffer;
    
    public Producer( Buffer<E> commonBuffer ){
        buffer = commonBuffer;
        System.out.println( "Producer ready!" );
    }
    
    @Override
    public void run() {
        E item;
        while( true ){
            item = produceItem();
            //down(emptyCount);
            buffer.putItem( item );
            //up(fillCount);
        }
    }

    private E produceItem() {
        System.out.println( "Consumer: consumItem" );
        
        // как-то нужно исхитриться и создать объект generic
        return null;
    }

}