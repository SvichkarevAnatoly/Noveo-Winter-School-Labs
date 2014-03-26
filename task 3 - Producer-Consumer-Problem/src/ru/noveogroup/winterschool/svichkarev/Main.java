package ru.noveogroup.winterschool.svichkarev;

/*Необходимо реализовать классическую задачу потребителей/производителей.
Суть задачи:
Существует некоторый буфер, который доступен из двух потоков, буфер может содержать максимум 1 элемент.
Один поток (производитель) способен добавлять значения в буфер, другой поток(потребитель) извлекать их из него.
Необходимо реализовать такое взаимодействие упомянутых потоков, при котором потребитель будет осуществлять попытку извлечения только в случае, если буфер полон, а производитель будет записывать значение в буфер, только если буфер пуст.
Подробнее о задаче можно прочитать здесь: http://en.wikipedia.org/wiki/Producer–consumer_problem
Hint: Для организации подобного взаимодействия можно использовать wait/notify/notifyAll или классы из пакета java.util.concurrent.*/


/* Пример из вики
semaphore fillCount = 0; // items produced
semaphore emptyCount = BUFFER_SIZE; // remaining space
 
procedure producer() {
    while (true) {
        item = produceItem();
        down(emptyCount);
            putItemIntoBuffer(item);
        up(fillCount);
    }
}
 
procedure consumer() {
    while (true) {
        down(fillCount);
            item = removeItemFromBuffer();
        up(emptyCount);
        consumeItem(item);
    }
}
*/
public class Main {
    public static void main(String[] args) {
        Buffer<Object> commonBuffer = new Buffer<Object>();
        
        Producer<?> producer = new Producer<Object>( commonBuffer, Object.class );
        Consumer<?> consumer = new Consumer<Object>( commonBuffer );
        
        Thread threadProducer = new Thread( producer );
        Thread threadConsumer = new Thread( consumer );
        
        threadProducer.start();
        threadConsumer.start();
        
        // ждём 1 секунду и завершаем как-то потоки
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        threadProducer.interrupt();
        threadConsumer.interrupt();
    }
}
