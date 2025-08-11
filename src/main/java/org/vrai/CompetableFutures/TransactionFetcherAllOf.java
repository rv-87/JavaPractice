package org.vrai.CompetableFutures;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class TransactionFetcherAllOf {

    // Simulated external web service call
    private static String fetchTransactionDetail(String transactionId) {
        try {
            // Simulate network latency
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Details for transaction: " + transactionId;
    }

    public static void main(String[] args) {
        List<String> transactionIds = Arrays.asList("TXN001", "TXN002", "TXN003", "TXN004");

        ExecutorService executor = Executors.newFixedThreadPool(4);

        // Step 1: Create a CompletableFuture for each transactionId
        List<CompletableFuture<String>> futures = transactionIds.stream()
                .map(id -> CompletableFuture.supplyAsync(() -> fetchTransactionDetail(id), executor))
                .toList();

        // Step 2: Convert list of futures to a single CompletableFuture<Void> using allOf
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(
                futures.toArray(new CompletableFuture[0])
        );

        // Step 3: After all futures complete, collect the results
        CompletableFuture<List<String>> allResultsFuture = allFutures.thenApply(v ->
                futures.stream()
                        .map(CompletableFuture::join)
                        .collect(Collectors.toList())
        );

        // Step 4: Get and print the results
        List<String> results = allResultsFuture.join();
        results.forEach(System.out::println);

        executor.shutdown();
    }
}
