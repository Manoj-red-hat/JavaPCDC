package MK;


public class JoinTestTest {
    JoinTest obj;

    @org.junit.jupiter.api.BeforeEach
    protected void setUp() {
        obj=new JoinTest();
    }

    @org.junit.jupiter.api.AfterEach
    protected void tearDown() {
        obj=null;
    }

    @org.junit.jupiter.api.Test
    void startThreadsInRandom() throws Exception{
        System.out.println("Thread executed with no delay ");
        obj.startThreadsInRandom();
        obj.alpha.join();
        obj.beta.join();
        obj.delta.join();

    }

    @org.junit.jupiter.api.Test
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