package MK;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

/**
 * Created by Manoj Kumar on 10/31/2017.
 * Contact: manoj.kumar.mbm@gmail.com
 */
public class DoublyLinkedListTest {
    DoublyLinkedList dl = new DoublyLinkedList();
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addNode() throws Exception {

        IntStream.range(1,10).forEach(x->{
            dl.addNode(x);
        });
        System.out.println(dl);

        dl.deleteNode(Math.abs(4));
        System.out.println(dl);

//        Random t=new Random();
//        IntStream.range(1,10).forEach(x->{
//           // System.out.println(t.nextInt()%10);
//            dl.deleteNode(Math.abs(t.nextInt()%10));
//            //System.out.println(dl);
//
//        });

    }

}