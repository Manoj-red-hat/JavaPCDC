package MK;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JoinTestTest {
    JoinTest obj;

    @Before
    protected void setUp() {
        obj=new JoinTest();
    }

    @After
    protected void tearDown() {
        obj=null;
    }

    @Test
    void startThreadsInRandom() throws Exception{
        System.out.println("Thread executed with no delay ");
        obj.startThreadsInRandom();
        obj.alpha.join();
        obj.beta.join();
        obj.delta.join();

    }

    @Test
    void joinMilliSec() throws Exception{
        obj.JoinMilliSec();
        obj.alpha.start();
        obj.alpha.join(3000);
        obj.beta.start();
        obj.beta.join();
        obj.delta.start();
        obj.delta.join(1000);


    }

}