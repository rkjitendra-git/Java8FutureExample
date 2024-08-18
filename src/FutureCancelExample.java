import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureCancelExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        
        Callable<Integer> task = () -> {
            Thread.sleep(5000);
            return 123;
        };
        
        Future<Integer> future = executor.submit(task);
        
        try {
            Thread.sleep(1000);
            boolean canceled = future.cancel(true); // Attempt to cancel the task
            System.out.println("Task canceled: " + canceled);
            
            if (!future.isCancelled()) {
                System.out.println("Future result: " + future.get()); // Blocking call
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
