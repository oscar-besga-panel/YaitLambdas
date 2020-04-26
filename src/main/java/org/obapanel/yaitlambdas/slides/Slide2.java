package org.obapanel.yaitlambdas.slides;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Slide2 {

    ExecutorService executor = Executors.newSingleThreadExecutor();

    public void exampleWithoutLamda() {
        executor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world");
            }
        });
    }

    public void exampleWithLamda() {
        executor.submit(() -> System.out.println("Hello world"));
    }

}