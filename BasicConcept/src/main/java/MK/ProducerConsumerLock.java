package MK;

import java.util.Vector;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class ProducerConsumerLock {
    public Vector<Boolean> eatingQueue = new Vector<>(5, 2);

    Thread Producer;
    Thread Consumer;

    Lock lk = new ReentrantLock();

    private final Condition bufferEmpty=lk.newCondition();
    private final Condition bufferFull=lk.newCondition();

    Runnable producer = () ->
        IntStream.range(1, 4).forEach((int x) -> {
            if(lk.tryLock()) {
                lk.lock();
                try {
                    if (eatingQueue.size() > 0) {
                        bufferEmpty.await();
                    } else {
                        System.out.println("Food is cooked");
                        eatingQueue.add(true);
                        bufferFull.signal();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lk.unlock();
                }
            }
        });

    Runnable consumer = () ->
        IntStream.range(1, 10).forEach(x -> {
            if(lk.tryLock()) {
                lk.lock();
                try {
                    if (eatingQueue.size() == 0) {
                        bufferFull.await(10, TimeUnit.MILLISECONDS);
                    } else {
                        eatingQueue.remove(0);
                        System.out.println("Cooked Food consumed, Require More");
                        bufferEmpty.signal();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lk.unlock();
                }
            }
        });

    ProducerConsumerLock(){
        Producer = new Thread(producer);
        Consumer = new Thread(consumer);
    }
}
