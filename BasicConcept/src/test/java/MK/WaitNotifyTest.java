package MK;

import org.junit.Before;
import org.junit.Test;

public class WaitNotifyTest {
    @Test
    void producer() {
    }

    WaitNotify obj;
    @Before
    void setUp() throws InterruptedException {
        obj = new WaitNotify();
        obj.Producer.start();
        obj.Consumer.start();
        obj.Producer.join();
        obj.Consumer.join();
    }

}