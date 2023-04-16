package me.whiteship.java8to11;

public class AppThread {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                System.out.println("Thread: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    throw new IllegalStateException(e);
                }
            }
        });
        thread.start();
        System.out.println("hello: " + Thread.currentThread().getName());
        thread.join();
        System.out.println(thread + " is finished");
    }
}
