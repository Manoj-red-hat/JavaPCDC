package MK;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WaitNotifyTest {
    @Test
    void producer() {
    }

    WaitNotify obj;
    @BeforeEach
    void setUp() throws InterruptedException {
        obj = new WaitNotify();
        obj.Producer.start();
        obj.Consumer.start();
        obj.Producer.join();
        obj.Consumer.join();
    }

}