import java.util.concurrent.CompletableFuture;

public class CompletableFutureWhenCompleteException {
    public static void main(String[] args) {


        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            if (Math.random() > 0.5) {
                throw new RuntimeException("Something went wrong!");
            }
            return 42;
        });

        CompletableFuture<Integer> whenCompleteFuture = future.whenComplete((result, ex) -> {
            if (ex != null) {
                System.out.println("Exception: " + ex.getMessage());
            } else {
                System.out.println("Result: " + result);
            }
        });
    }
}

