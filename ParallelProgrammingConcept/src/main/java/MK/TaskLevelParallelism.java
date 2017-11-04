package MK;

import java.util.concurrent.Callable;

/**
 * Created by Manoj Kumar on 11/1/2017.
 * Contact: manoj.kumar.mbm@gmail.com
 */
public class TaskLevelParallelism implements Callable<Integer   >{
    @Override
    public Integer call() throws Exception {
        Thread.sleep(500);
        return new Integer(100);
    }
}
