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
        System.out.println( "Her" );
        
        Buffer<Integer> commonBuffer = new Buffer<Integer>();
        
        Producer producer = new Producer( commonBuffer );
        Consumer consumer = new Consumer( commonBuffer );
        
        new Thread( producer ).start();
        new Thread( consumer ).start();
        
        // ждём 5 секунд и завершаем как-то потоки
    }
}
