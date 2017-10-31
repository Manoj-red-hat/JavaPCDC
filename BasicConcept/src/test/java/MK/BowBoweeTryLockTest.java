package MK;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Manoj Kumar on 10/30/2017.
 * Contact: manoj.kumar.mbm@gmail.com
 */
public class BowBoweeTryLockTest {
    @Before
    public void setUp() throws Exception {
        final BowBoweeTryLock.Friend alphonse =
                new BowBoweeTryLock.Friend("Alphonse");
        final BowBoweeTryLock.Friend gaston =
                new BowBoweeTryLock.Friend("Gaston");
        Thread t1= new Thread(new BowBoweeTryLock.BowLoop(alphonse, gaston));
        Thread t2=new Thread(new BowBoweeTryLock.BowLoop(gaston, alphonse));
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    @Test
    public void produce(){

    }

}