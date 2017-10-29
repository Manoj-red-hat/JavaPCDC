package MK;

/**
 * Hello world!
 *
 */

import java.lang.Thread;
import java.util.stream.IntStream;

public class JoinTest
{

    public Thread alpha;
    public Thread beta;
    public Thread delta;

    JoinTest() {
        Runnable task = () ->
            IntStream.range(1,5).forEach(x-> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Current Thread name" + Thread.currentThread().getName());
            });

        alpha = new Thread(task);
        beta = new Thread(task);
        delta = new Thread(task);

        alpha.setName("Alpha");
        beta.setName("Beta");
        delta.setName("delta");
    }

    void startThreadsInRandom(){
        alpha.start();
        beta.start();
        delta.start();
    }
    void JoinMilliSec(){
        System.out.println("Thread executed with delay ");
    }

}
