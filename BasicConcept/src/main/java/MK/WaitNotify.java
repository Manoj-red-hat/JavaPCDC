package MK;

import java.util.Vector;
import java.util.stream.IntStream;

public class WaitNotify {

    public Vector<Boolean> eatingQueue = new Vector<>(5, 2);
    Thread Producer;
    Thread Consumer;

    Runnable producer = () -> {

        IntStream.range(1, 11).forEach(x -> {
            synchronized (eatingQueue) {
                if (eatingQueue.size() > 0) {
                    try {
                        eatingQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Food is cooked");
                    eatingQueue.add(true);
                    eatingQueue.notifyAll();
                }
            }
        });

    };

    Runnable consumer = () -> {
        IntStream.range(1, 11).forEach(x -> {
            synchronized (eatingQueue) {
                if (eatingQueue.size() == 0) {
                    try {
                        eatingQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    eatingQueue.remove(0);
                    System.out.println("Cooked Food consumed, Require More");
                    eatingQueue.notifyAll();
                }
            }
        });
    };

    WaitNotify() {
        Producer = new Thread(producer);
        Consumer = new Thread(consumer);
    }


}
