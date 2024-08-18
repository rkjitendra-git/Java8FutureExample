import java.util.concurrent.*;

public class CallableExample {



    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(1);
        Callable callable=()->{
            System.out.println("Calling -------------");
            return 1;
        };
        Future future=executorService.submit(callable);

        try {
            System.out.println(future.get());
        } catch (InterruptedException|ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            executorService.shutdown();
        }


    }
}
