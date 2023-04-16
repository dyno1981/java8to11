package me.whiteship.java8to11;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppCompletableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            System.out.println("hello" + Thread.currentThread().getName());
            return "hello";
        });

        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> {
            System.out.println("world" + Thread.currentThread().getName());
            return "world";
        });

        CompletableFuture<Void> future = CompletableFuture.allOf(hello, world)
                .thenAccept(System.out::println);
        System.out.println(future.get());
    }
}
