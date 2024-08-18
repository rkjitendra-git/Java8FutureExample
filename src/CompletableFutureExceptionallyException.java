import java.util.concurrent.CompletableFuture;

public class CompletableFutureExceptionallyException {
    public static void main(String[] args) {


        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            if (Math.random() > 0.5) {
                throw new RuntimeException("Something went wrong!");
            }
            return 42;
        });

        CompletableFuture<Integer> exceptionallyFuture = future.exceptionally(ex->{
            System.out.println("Error "+ex.getMessage());
            return -1;
        });


        exceptionallyFuture.thenAccept(result-> System.out.println("result " +result));
    }
}

