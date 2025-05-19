import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolClass {

    public void runn() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
    }
}
