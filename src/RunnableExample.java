import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RunnableExample implements Runnable {
    @Override
    public void run() {
        System.out.println("Running ------------");
    }

    public static void main(String[] args) {
        ExecutorService executorService= Executors.newSingleThreadExecutor();
        Future future=executorService.submit(new RunnableExample());
        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        finally {
            executorService.shutdown();
        }
    }
}
