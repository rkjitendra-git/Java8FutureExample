import java.util.concurrent.CompletableFuture;

public class CompletableFutureHandleException {
    public static void main(String[] args) {


        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            if (Math.random() > 0.5) {
                throw new RuntimeException("Something went wrong!");
            }
            return 42;
        });

        CompletableFuture<Integer> handleFuture = future.handle((result, ex) -> {
            if (ex != null) {
                System.out.println("Exception: " + ex.getMessage());
            return -1;
            }
            return result;
        });
//        handleFuture.thenAccept(System.out::println);
        handleFuture.thenAccept(result-> System.out.println("result " +result));
    }
}

