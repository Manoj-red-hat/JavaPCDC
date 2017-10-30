package MK;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Manoj Kumar on 10/30/2017.
 * Contact: manoj.kumar.mbm@gmail.com
 */
public class ProducerConsumerLockTest {
    @Before
    public void setUp() throws Exception {
        ProducerConsumerLock obj = new ProducerConsumerLock();
        obj.Producer.start();
        obj.Consumer.start();
        obj.Producer.join();
        obj.Consumer.join();
    }

    @Test
    public void pro(){

    }
}