package ru.noveogroup.winterschool.svichkarev;

public class Producer<E> implements Runnable {
    private Buffer<E> buffer;
    private Class<E> bufferClassE;
    
    public Producer( Buffer<E> commonBuffer, Class<E> classE ){
        buffer = commonBuffer;
        bufferClassE = classE;
        System.out.println( "Producer ready!" );
    }
    
    @Override
    public void run() {
        E item;
        while( true ){
            if( Thread.interrupted() ){
                System.out.println( "Producer: end run");
                return;
            }
            item = produceItem();
            buffer.putItem( item );
        }
    }

    private E produceItem() {
        E newItem = null;
        try {
            newItem = bufferClassE.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println( "Producer: produce Item " + newItem.toString() );
        return newItem;
    }

}