package me.whiteship.java8to11;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class AppExecutors {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService
                executorService = Executors.newFixedThreadPool(3);
        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "hello";
        };

        Callable<String> java = () -> {
            Thread.sleep(3000L);
            return "Java";
        };

        Callable<String> keesun = () -> {
            Thread.sleep(1000L);
            return "keesun";
        };

        String s = executorService.invokeAny(Arrays.asList(hello, java, keesun));

            System.out.println(s);


        executorService.shutdown();
    }
}
