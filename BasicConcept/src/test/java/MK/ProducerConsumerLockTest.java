package MK;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProducerConsumerLockTest {
    @BeforeEach
    void setUp() throws InterruptedException {
        ProducerConsumerLock obj = new ProducerConsumerLock();
        obj.Producer.start();
        obj.Consumer.start();
        obj.Producer.join();
        obj.Consumer.join();
    }
    @Test
    void producer() {
    }
}